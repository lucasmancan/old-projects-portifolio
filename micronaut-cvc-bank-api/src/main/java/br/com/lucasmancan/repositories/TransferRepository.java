package br.com.lucasmancan.repositories;


import br.com.lucasmancan.entities.Transfer;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

import javax.inject.Singleton;
import java.util.List;

@Singleton
@Repository
public interface TransferRepository extends PageableRepository<Transfer, Long> {
    List<Transfer> findAllByOriginId(Long currentAccountId);
}
