package br.com.lucasmancan.services.impl;

import br.com.lucasmancan.dtos.BalanceUpdate;
import br.com.lucasmancan.exceptions.ValidationException;
import br.com.lucasmancan.repositories.AccountRepository;
import br.com.lucasmancan.security.exceptions.AuthenticationNotFoundException;
import br.com.lucasmancan.security.services.impl.AppSecurityContext;
import br.com.lucasmancan.services.BalanceService;
import lombok.AllArgsConstructor;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Arrays;

@Singleton
@AllArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final AppSecurityContext appSecurityContext;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public void updateBalance(BalanceUpdate balanceUpdate) {

        if (balanceUpdate.getBeneficiaryId().equals(appSecurityContext.getCurrentAccountId())) {
            throw new ValidationException("Transfer to the same account is not allowed.");
        }

        var account = accountRepository.findById(appSecurityContext.getCurrentAccountId())
                .orElseThrow(AuthenticationNotFoundException::new);

        if (account.getBalance().compareTo(balanceUpdate.getAmount()) < 0) {
            throw new ValidationException("Account does not have enough balance to complete the transaction");
        }

        account.setBalance(account.getBalance().subtract(balanceUpdate.getAmount()));

        var beneficiaryAccount = accountRepository.findById(balanceUpdate.getBeneficiaryId())
                .orElseThrow(AuthenticationNotFoundException::new);

        beneficiaryAccount.setBalance(beneficiaryAccount.getBalance().add(balanceUpdate.getTransferAmount()));

        accountRepository.saveAll(Arrays.asList(account, beneficiaryAccount));
    }
}
