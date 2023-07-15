package br.com.lucasmancan.converters;


import br.com.lucasmancan.dtos.AccountDTO;
import br.com.lucasmancan.dtos.CreateAccountDTO;
import br.com.lucasmancan.entities.Account;

public interface AccountConverter extends Converter<Account, AccountDTO> {
    Account dtoToEntity(CreateAccountDTO accountDTO);
}
