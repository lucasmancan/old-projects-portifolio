package br.com.lucasmancan.services;

import br.com.lucasmancan.dtos.CreateAccountDTO;

public interface AccountValidationService {
    void validate(CreateAccountDTO dto);
}
