package br.com.lucasmancan.medtech.api.configurations.email.services;

import br.com.lucasmancan.medtech.api.configurations.email.dtos.Mail;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);

    CompletableFuture<Mail> sendTemplateMessage(String to, String emailCode, Map<String, Object> templateModel);

    CompletableFuture<Mail> sendTemplateMessage(String to, String emailCode, Map<String, Object> templateModel, List<File> files);

}