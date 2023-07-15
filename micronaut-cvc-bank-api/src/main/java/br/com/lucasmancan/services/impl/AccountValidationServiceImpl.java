package br.com.lucasmancan.services.impl;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.lucasmancan.dtos.CreateAccountDTO;
import br.com.lucasmancan.entities.AccountType;
import br.com.lucasmancan.exceptions.ValidationException;

import br.com.lucasmancan.repositories.AccountRepository;
import br.com.lucasmancan.services.AccountValidationService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Singleton;

@Singleton
@AllArgsConstructor
public class AccountValidationServiceImpl implements AccountValidationService {

    private final AccountRepository accountRepository;

    @Override
    public void validate(CreateAccountDTO account) {
        var cleanDocument = StringUtils.trimToNull(account.getDocument());

        if (accountRepository.findByDocument(account.getDocument()).isPresent()) {
            throw new ValidationException("Account already exists.");
        }

        if (account.getPassword().isEmpty() || account.getPassword().length() < 6) {
            throw new ValidationException("Password should have at least 6 chars.");
        }

        if (cleanDocument == null) {
            throw new ValidationException("Document is not valid.");
        }

        try {

            Validator<String> validator;

            if (AccountType.individual.equals(account.getType())) {
                validator = new CPFValidator();
            } else {
                validator = new CNPJValidator();
            }

            validator.assertValid(account.getDocument());
        } catch (InvalidStateException e) {
            throw new ValidationException("Document is not valid.");
        }
    }
}
