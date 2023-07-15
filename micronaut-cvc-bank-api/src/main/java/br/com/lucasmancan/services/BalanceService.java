package br.com.lucasmancan.services;

import br.com.lucasmancan.dtos.BalanceUpdate;

public interface BalanceService {

    /**
     * Update balance of origin and beneficiary account and apply some transaction validations
     *
     * @param balanceUpdate credit exchange information
     */
    void updateBalance(BalanceUpdate balanceUpdate);
}
