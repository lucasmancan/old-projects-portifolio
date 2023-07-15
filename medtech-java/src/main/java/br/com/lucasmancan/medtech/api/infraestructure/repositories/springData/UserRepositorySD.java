package br.com.lucasmancan.medtech.api.infraestructure.repositories.springData;

import br.com.lucasmancan.medtech.api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositorySD extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
