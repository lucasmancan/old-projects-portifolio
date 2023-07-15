package br.com.lucasmancan.medtech.api.infraestructure.security.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials implements Serializable {
    private String email;
    private String password;
}