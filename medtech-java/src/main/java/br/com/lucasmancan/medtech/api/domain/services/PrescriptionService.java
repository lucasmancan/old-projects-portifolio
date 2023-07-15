package br.com.lucasmancan.medtech.api.domain.services;

import br.com.lucasmancan.medtech.api.domain.dto.PrescriptionDTO;
import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Prescription;
import br.com.lucasmancan.medtech.api.domain.exceptions.ReportException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrescriptionService extends Service<Prescription> {
    Page<PrescriptionDTO> search(Pageable pageable, SearchText search);

    byte[] generatePrescription(String prescriptionId) throws ReportException;

    void sendPrescriptionToCustomer(String prescriptionId);

    Prescription clone(String prescriptionId);
}
