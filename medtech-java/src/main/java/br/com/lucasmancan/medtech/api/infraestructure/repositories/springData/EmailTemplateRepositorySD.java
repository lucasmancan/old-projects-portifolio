package br.com.lucasmancan.medtech.api.infraestructure.repositories.springData;

import br.com.lucasmancan.medtech.api.domain.entities.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmailTemplateRepositorySD extends JpaRepository<EmailTemplate, String> {

    @Transactional(readOnly = true)
    Optional<EmailTemplate> findByCode(String code);
}
