package br.com.lucasmancan.medtech.api.domain.repositories;

import br.com.lucasmancan.medtech.api.domain.entities.PrescriptionItem;

import java.util.List;

public interface PrescriptionItemRepository extends Repository<PrescriptionItem, String> {
    List<PrescriptionItem> findByPrescriptionId(String id);
}
