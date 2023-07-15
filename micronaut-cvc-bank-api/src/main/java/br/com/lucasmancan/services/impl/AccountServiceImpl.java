package br.com.lucasmancan.services.impl;

import br.com.lucasmancan.converters.AccountConverter;
import br.com.lucasmancan.dtos.AccountDTO;
import br.com.lucasmancan.dtos.CreateAccountDTO;
import br.com.lucasmancan.exceptions.NotFoundException;
import br.com.lucasmancan.repositories.AccountRepository;
import br.com.lucasmancan.security.exceptions.AuthenticationNotFoundException;
import br.com.lucasmancan.security.services.SecurityService;
import br.com.lucasmancan.security.services.impl.AppSecurityContext;
import br.com.lucasmancan.services.AccountService;
import br.com.lucasmancan.services.AccountValidationService;
import br.com.lucasmancan.services.PasswordEncoderService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountValidationService accountValidationService;
    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;
    private final PasswordEncoderService passwordEncoderService;
    private final SecurityService appSecurityContext;

    @Override
    public AccountDTO findById(Long id) {
        return accountRepository.findById(id)
                .map(accountConverter::entityToDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public AccountDTO create(CreateAccountDTO accountDTO) {
        accountValidationService.validate(accountDTO);

        var entity = accountConverter.dtoToEntity(accountDTO);
        entity.setNumber(generateAccountNumber());
        entity.setPassword(passwordEncoderService.encode(entity.getPassword()));
        return accountConverter.entityToDTO(accountRepository.save(entity));
    }

    @Override
    public String generateAccountNumber() {
        return RandomStringUtils.randomNumeric(6);
    }

    @Override
    public AccountDTO findActiveAccount() {
        return accountRepository.findById(appSecurityContext.getCurrentAccountId())
                .map(accountConverter::entityToDTO)
                .orElseThrow(AuthenticationNotFoundException::new);
    }
}
