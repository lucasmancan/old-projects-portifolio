package br.com.lucasmancan.medtech.api.domain.services;

import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DrugService extends Service<Drug> {
    Page<Drug> search(Pageable pageable, SearchText searchText);

    List<Drug> findAll();
}
