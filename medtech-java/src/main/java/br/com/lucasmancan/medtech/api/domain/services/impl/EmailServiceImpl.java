package br.com.lucasmancan.medtech.api.domain.services.impl;

import br.com.lucasmancan.medtech.api.configurations.email.dtos.Mail;
import br.com.lucasmancan.medtech.api.configurations.email.exceptions.EmailTemplateNotFoundException;
import br.com.lucasmancan.medtech.api.configurations.email.services.EmailService;
import br.com.lucasmancan.medtech.api.domain.entities.EmailTemplate;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.EmailTemplateRepositorySD;
import freemarker.template.Template;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static java.lang.String.format;

@Log4j2
@Service("EmailService")
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final EmailTemplateRepositorySD templateRepository;
    private final FreeMarkerConfigurer freemarkerConfigurer;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public CompletableFuture<Mail> sendTemplateMessage(String to, String emailCode, Map<String, Object> templateModel, List<File> files) {
        return CompletableFuture.supplyAsync(() -> {
            try {

                EmailTemplate emailTemplate = templateRepository.findByCode(emailCode)
                        .orElseThrow(() -> new EmailTemplateNotFoundException(emailCode));

                Template freemakerTemplate = new Template("htmlBody",
                        emailTemplate.getHtmlBody(),
                        freemarkerConfigurer.getConfiguration());

//                Template freemakerTemplate = freemarkerConfigurer.getConfiguration().getTemplate(format("%s.html", emailCode));

                String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(
                        freemakerTemplate,
                        templateModel);

                sendHtmlMessage(to, emailTemplate.getSubject(), htmlBody, files);

                var mail = new Mail(to, emailTemplate.getSubject(), htmlBody, new Date());
                log.info("An Email was sent {} ", mail);
                return mail;
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        }).exceptionally(error -> {
            log.error("An Error occurred trying to send an email {} to {} : {}", emailCode, to, error);
            return null;
        });
    }

    @Override
    public CompletableFuture<Mail> sendTemplateMessage(String to, String emailCode, Map<String, Object> templateModel) {
        return this.sendTemplateMessage(to, emailCode, templateModel, null);
    }

    private void sendHtmlMessage(String to, String subject, String htmlBody, List<File> files) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        if (!CollectionUtils.isEmpty(files)) {
            for (File file : files) {
                helper.addAttachment(file.getName(), file);
            }
        }

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);

        emailSender.send(message);
    }
}