package br.com.lucasmancan.medtech.api.configurations.email.exceptions;

public class EmailTemplateNotFoundException extends RuntimeException {
    public EmailTemplateNotFoundException(String templateName) {
        super("The e-mail template " + templateName + " was not found in templete database");
    }
}
