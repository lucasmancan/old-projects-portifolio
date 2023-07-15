package br.com.lucasmancan.medtech.api.domain.repositories;

import br.com.lucasmancan.medtech.api.domain.entities.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}
