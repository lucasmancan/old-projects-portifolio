package br.com.lucasmancan.medtech.api.domain.services;

import br.com.lucasmancan.medtech.api.domain.entities.PrescriptionItem;

import java.util.List;

public interface PrescriptionItemService extends Service<PrescriptionItem> {
    List<PrescriptionItem> findByPrescriptionId(String prescriptionId);
}
