package br.com.lucasmancan.medtech.api.domain.repositories;

import br.com.lucasmancan.medtech.api.domain.dto.paginator.Paginator;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    <S extends T> S save(S var1);

    Optional<T> findById(ID var1);

    List<T> findAll();

    List<T> findAll(Paginator paginator);

    void deleteById(ID var1);

    void delete(T var1);
}
