package br.com.lucasmancan.medtech.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    @NotBlank
    private String name;
    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    private String document;
}

