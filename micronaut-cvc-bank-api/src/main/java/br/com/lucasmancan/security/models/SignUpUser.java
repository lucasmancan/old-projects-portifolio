package br.com.lucasmancan.security.models;

import br.com.lucasmancan.security.exceptions.PasswordDoenstMatchException;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
@Introspected
public class SignUpUser {

    @NotEmpty(message = "A senha é necessária")
    private String password;
    @NotEmpty(message = "O confirmação de senha é necessária")
    private String confirmation;

    @NotEmpty(message = "O nome é necessário")
    private String name;

    @NotEmpty(message = "O telefone de contato é necessário")
    private String phone;

    @NotEmpty(message = "Digite um e-mail válido")
    @Email(message = "Digite um e-mail válido")
    private String email;

    public SignUpUser(@NotEmpty(message = "A senha é necessária") String password, @NotEmpty(message = "O confirmação de senha é necessária") String confirmation, @NotEmpty(message = "O nome é necessário") String name, @NotEmpty(message = "O telefone de contato é necessário") String phone, @NotEmpty(message = "Digite um e-mail válido") @Email(message = "Digite um e-mail válido") String email) {
        this.password = password;
        this.confirmation = confirmation;
        this.name = name;
        this.phone = phone;
        this.email = email;

        this.validar();
    }

    public void validar() {
        if (!this.password.equals(this.confirmation)) {
            throw new PasswordDoenstMatchException("Senha e confirmação de senha devem ser iguais.");
        }
    }
}
