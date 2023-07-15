package br.com.lucasmancan.medtech.api.infraestructure.repositories.springData;

import br.com.lucasmancan.medtech.api.domain.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TokenRepositorySD extends JpaRepository<Token, String> {
    @Transactional(readOnly = true)
    @Query("Select t from Token t where t.tokenCode=:code and t.status='active'")
    Optional<Token> findByTokenCode(String code);
}
