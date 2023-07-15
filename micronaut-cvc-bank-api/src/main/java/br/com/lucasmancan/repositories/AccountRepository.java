package br.com.lucasmancan.repositories;


import br.com.lucasmancan.entities.Account;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

import javax.inject.Singleton;
import java.util.Optional;

@Repository
public interface AccountRepository extends PageableRepository<Account, Long> {
    Optional<Account> findByNumber(String number);

    Optional<Account> findByDocument(String document);
}
