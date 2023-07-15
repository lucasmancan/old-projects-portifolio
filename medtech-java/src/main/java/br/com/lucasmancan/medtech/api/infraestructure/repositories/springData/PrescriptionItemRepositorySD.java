package br.com.lucasmancan.medtech.api.infraestructure.repositories.springData;

import br.com.lucasmancan.medtech.api.domain.entities.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PrescriptionItemRepositorySD extends JpaRepository<PrescriptionItem, String> {


    List<PrescriptionItem> findByPrescriptionId(String prescriptionId);
}
