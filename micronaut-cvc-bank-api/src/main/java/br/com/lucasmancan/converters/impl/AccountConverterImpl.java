package br.com.lucasmancan.converters.impl;

import br.com.lucasmancan.converters.AccountConverter;
import br.com.lucasmancan.dtos.AccountDTO;
import br.com.lucasmancan.dtos.CreateAccountDTO;
import br.com.lucasmancan.entities.Account;

import javax.inject.Singleton;

@Singleton
public class AccountConverterImpl implements AccountConverter {

    @Override
    public Account dtoToEntity(AccountDTO accountDTO) {
        return Account.builder()
                .document(accountDTO.getDocument())
                .type(accountDTO.getType())
                .number(accountDTO.getNumber())
                .updatedAt(accountDTO.getUpdatedAt())
                .password(accountDTO.getPassword())
                .id(accountDTO.getId())
                .build();
    }

    @Override
    public Account dtoToEntity(CreateAccountDTO accountDTO) {
        return Account.builder()
                .document(accountDTO.getDocument())
                .type(accountDTO.getType())
                .password(accountDTO.getPassword())
                .balance(accountDTO.getInitialBalance())
                .build();
    }

    @Override
    public AccountDTO entityToDTO(Account account) {
        return AccountDTO.builder()
                .updatedAt(account.getUpdatedAt())
                .id(account.getId())
                .document(account.getDocument())
                .type(account.getType())
                .number(account.getNumber())
                .balance(account.getBalance())
                .build();
    }
}
