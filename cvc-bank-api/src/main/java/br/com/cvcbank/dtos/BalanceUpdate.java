package br.com.cvcbank.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public final class BalanceUpdate {
    private final Long beneficiaryId;
    private final Long originId;
    private final BigDecimal transferAmount;
    private final BigDecimal amount;
}