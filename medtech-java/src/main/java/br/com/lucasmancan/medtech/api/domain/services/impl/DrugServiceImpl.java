package br.com.lucasmancan.medtech.api.domain.services.impl;

import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Drug;
import br.com.lucasmancan.medtech.api.domain.services.DrugService;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.DrugRepositorySD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl extends AbstractService<Drug, DrugRepositorySD> implements DrugService {

    @Override
    public Page<Drug> search(Pageable pageable, SearchText searchText) {
        if (searchText.isEmpty())
            return repository.findAll(pageable);

        return super.repository.findAllWithCustonSearch(pageable, searchText.toString());
    }

    @Override
    public List<Drug> findAll() {
        return repository.findAll();
    }
}
