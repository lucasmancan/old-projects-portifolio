package br.com.lucasmancan.medtech.api.domain.repositories;

import br.com.lucasmancan.medtech.api.domain.dto.paginator.Paginator;
import br.com.lucasmancan.medtech.api.domain.entities.Prescription;

import java.util.List;

public interface PrescriptionRepository {
    List<Prescription> findWithCustomSearch(Paginator paginator, String userId, String searchText);

}
