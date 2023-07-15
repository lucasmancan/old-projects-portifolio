package br.com.lucasmancan.medtech.api.domain.services.impl;

import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Customer;
import br.com.lucasmancan.medtech.api.domain.services.CustomerService;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.CustomerRepositorySD;
import br.com.lucasmancan.medtech.api.infraestructure.security.utils.AppSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends AbstractService<Customer, CustomerRepositorySD> implements CustomerService {

    @Autowired
    private AppSecurityContext appSecurityContext;

    @Override
    public Page<Customer> search(Pageable pageable, SearchText searchText) {

        if (searchText.isEmpty())
            return super.repository.findPageableByUserId(pageable, appSecurityContext.getCurrentAccountId());

        return super.repository.findAllWithCustomSearch(pageable, appSecurityContext.getCurrentAccountId(), searchText.toString());
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAllByUser(appSecurityContext.getCurrentAccountId());
    }
}
