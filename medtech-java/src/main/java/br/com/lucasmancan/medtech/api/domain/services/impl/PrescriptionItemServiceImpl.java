package br.com.lucasmancan.medtech.api.domain.services.impl;

import br.com.lucasmancan.medtech.api.domain.entities.PrescriptionItem;
import br.com.lucasmancan.medtech.api.domain.services.PrescriptionItemService;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.PrescriptionItemRepositorySD;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PrescriptionItemServiceImpl extends AbstractService<PrescriptionItem, PrescriptionItemRepositorySD> implements PrescriptionItemService {

    @Override
    public List<PrescriptionItem> findByPrescriptionId(String prescriptionId) {
        return repository.findByPrescriptionId(prescriptionId);
    }
}