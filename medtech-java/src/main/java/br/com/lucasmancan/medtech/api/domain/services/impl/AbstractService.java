package br.com.lucasmancan.medtech.api.domain.services.impl;

import br.com.lucasmancan.medtech.api.domain.entities.AbstractEntity;
import br.com.lucasmancan.medtech.api.domain.exceptions.NotFoundException;
import br.com.lucasmancan.medtech.api.domain.services.Service;
import br.com.lucasmancan.medtech.api.domain.services.persistenceListeners.PersistenceListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T extends AbstractEntity, R extends JpaRepository<T, String>> implements Service<T> {

    @Autowired(required = false)
    protected R repository;

    @Autowired(required = false)
    protected PersistenceListener<T> persistenceListener;

    public T save(T entity) {
        if (entity.getId() != null)
            return this.update(entity);
        return this.insert(entity);
    }

    public T insert(T entity) {
        if (persistenceListener != null)
            persistenceListener.beforeInsert(entity);

        entity = repository.save(entity);

        if (persistenceListener != null)
            persistenceListener.afterInsert(entity);

        return entity;
    }

    public T update(T entity) {
        if (persistenceListener != null)
            persistenceListener.beforeUpdate(entity);

        entity = repository.save(entity);

        if (persistenceListener != null)
            persistenceListener.afterUpdate(entity);

        return entity;
    }

    public T findById(String id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public T delete(T entity) {
        if (persistenceListener != null)
            persistenceListener.beforeDelete(entity);

        repository.delete(entity);

        if (persistenceListener != null)
            persistenceListener.afterDelete(entity);

        return entity;
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Page<T> findAll(Pageable paginator) {
        return repository.findAll(paginator);
    }
}
