package br.com.lucasmancan.medtech.api.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class NewPassword {

    @NotEmpty(message = "Nova senha deve ser especificada.")
    private String password;

    @NotEmpty(message = "Confirmação de senha deve ser especificada.")
    private String confirmation;

    @NotEmpty(message = "Codigo de autorização deve ser especificado.")
    private String token;

    public NewPassword(@NotEmpty(message = "Nova senha deve ser especificada.") String password, @NotEmpty(message = "Confirmação de senha deve ser especificada.") String confirmation, @NotEmpty(message = "Codigo de autorização deve ser especificado.") String token) {
        this.setPassword(password);
        this.setConfirmation(confirmation);
        this.setToken(token);
    }

    public void setPassword(String password) {
        this.password = StringUtils.trim(password);
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = StringUtils.trim(confirmation);
    }

    public void setToken(String token) {
        this.token = StringUtils.trim(token);
    }

    public boolean dismatch() {
        return !this.password.equals(this.confirmation);
    }
}
