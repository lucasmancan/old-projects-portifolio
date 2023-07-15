package br.com.lucasmancan.services;

import br.com.lucasmancan.dtos.AccountDTO;
import br.com.lucasmancan.dtos.CreateAccountDTO;

public interface AccountService {
    AccountDTO findById(Long id);

    AccountDTO create(CreateAccountDTO accountDTO);

    String generateAccountNumber();

    AccountDTO findActiveAccount();
}
