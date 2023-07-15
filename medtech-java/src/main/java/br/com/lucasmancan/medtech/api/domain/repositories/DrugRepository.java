package br.com.lucasmancan.medtech.api.domain.repositories;

import br.com.lucasmancan.medtech.api.domain.dto.paginator.Paginator;
import br.com.lucasmancan.medtech.api.domain.entities.Drug;

import java.util.List;

public interface DrugRepository extends Repository<Drug, String> {
    List<Drug> findByName(String name, Paginator paginator);
}
