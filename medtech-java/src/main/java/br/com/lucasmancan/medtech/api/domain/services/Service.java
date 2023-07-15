package br.com.lucasmancan.medtech.api.domain.services;

import br.com.lucasmancan.medtech.api.domain.entities.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T extends AbstractEntity> {
    T save(T entity);

    T insert(T entity);

    T update(T entity);

    T findById(String id);

    T delete(T entity);

    void deleteById(String id);

    Page<T> findAll(Pageable paginator);
}
