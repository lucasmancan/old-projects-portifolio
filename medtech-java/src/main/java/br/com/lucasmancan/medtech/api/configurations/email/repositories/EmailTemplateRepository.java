package br.com.lucasmancan.medtech.api.configurations.email.repositories;

import br.com.lucasmancan.medtech.api.domain.entities.EmailTemplate;

import java.util.Optional;

public interface EmailTemplateRepository {
    Optional<EmailTemplate> findByCode(String code);
}
