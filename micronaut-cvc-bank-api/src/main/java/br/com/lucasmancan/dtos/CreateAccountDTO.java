package br.com.lucasmancan.dtos;

import br.com.lucasmancan.entities.AccountType;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreateAccountDTO {

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String password;

    @NotNull(message = "Account type is required")
    private AccountType type;
    @NotNull(message = "Document number is required")
    private String document;

    @NotNull(message = "initial balance is required")
    private BigDecimal initialBalance;

    public String getDocument() {
        return document != null ? document.replaceAll("\\D", "") : null;
    }
}
