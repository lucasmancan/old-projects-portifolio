package br.com.lucasmancan.medtech.api.configurations.email.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    @Email
    @NotNull
    @Size(min = 1, message = "Please, set an email address to send the message to it")
    private String to;
    private String subject;
    private String body;
    private Date date;

    @Override
    public String toString() {
        return "MailObject{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                '}';
    }
}