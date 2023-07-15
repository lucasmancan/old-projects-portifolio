package br.com.lucasmancan.medtech.api.domain.services.persistenceListeners.impl;


import br.com.lucasmancan.medtech.api.domain.entities.Customer;
import br.com.lucasmancan.medtech.api.domain.entities.Status;
import br.com.lucasmancan.medtech.api.domain.services.persistenceListeners.PersistenceListener;
import br.com.lucasmancan.medtech.api.infraestructure.security.utils.AppSecurityContext;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerPL implements PersistenceListener<Customer> {

    private final AppSecurityContext appSecurityContext;

    public CustomerPL(AppSecurityContext appSecurityContext) {
        this.appSecurityContext = appSecurityContext;
    }

    @Override
    public void beforeInsert(Customer data) {
        data.setUserId(appSecurityContext.getCurrentAccountId());
        data.setStatus(Status.active);
        data.setCreatedAt(new Date());
        data.setUpdatedAt(new Date());
    }

    @Override
    public void afterInsert(Customer data) {

    }

    @Override
    public void beforeUpdate(Customer data) {
        data.setUpdatedAt(new Date());
    }

    @Override
    public void afterUpdate(Customer data) {

    }

    @Override
    public void beforeDelete(Customer data) {

    }

    @Override
    public void afterDelete(Customer data) {

    }
}
