package br.com.lucasmancan.security.models;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class Credentials implements Serializable {
    private String email;
    private String password;
}