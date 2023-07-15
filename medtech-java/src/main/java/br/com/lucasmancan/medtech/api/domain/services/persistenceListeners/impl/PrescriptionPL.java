package br.com.lucasmancan.medtech.api.domain.services.persistenceListeners.impl;


import br.com.lucasmancan.medtech.api.domain.entities.Prescription;
import br.com.lucasmancan.medtech.api.domain.entities.PrescriptionItem;
import br.com.lucasmancan.medtech.api.domain.entities.Status;
import br.com.lucasmancan.medtech.api.domain.services.persistenceListeners.PersistenceListener;
import br.com.lucasmancan.medtech.api.infraestructure.security.utils.AppSecurityContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;

@Component
public class PrescriptionPL implements PersistenceListener<Prescription> {

    private final AppSecurityContext appSecurityContext;

    public PrescriptionPL(AppSecurityContext appSecurityContext) {
        this.appSecurityContext = appSecurityContext;
    }

    @Override
    public void beforeInsert(Prescription data) {
        data.setUserId(appSecurityContext.getCurrentAccountId());
        data.setStatus(Status.active);
        data.setCreatedAt(new Date());
        data.setUpdatedAt(new Date());
        this.setItems(data);
    }

    public void setItems(Prescription data) {
        if (!CollectionUtils.isEmpty(data.getItems())) {
            for (PrescriptionItem prescriptionItem : data.getItems()) {
                prescriptionItem.setPrescription(data);
            }
        }
    }

    @Override
    public void afterInsert(Prescription data) {

    }

    @Override
    public void beforeUpdate(Prescription data) {
        data.setUpdatedAt(new Date());
        this.setItems(data);
    }

    @Override
    public void afterUpdate(Prescription data) {

    }

    @Override
    public void beforeDelete(Prescription data) {

    }

    @Override
    public void afterDelete(Prescription data) {

    }
}
