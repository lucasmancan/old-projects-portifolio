package br.com.lucasmancan.medtech.api.domain.services.persistenceListeners;

public interface PersistenceListener<T> {
    void beforeInsert(T data);

    void afterInsert(T data);

    void beforeUpdate(T data);

    void afterUpdate(T data);

    void beforeDelete(T data);

    void afterDelete(T data);
}
