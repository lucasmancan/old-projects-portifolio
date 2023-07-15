package br.com.lucasmancan.medtech.api.domain.services;

import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService extends Service<Customer> {
    Page<Customer> search(Pageable pageable, SearchText searchText);

    List<Customer> findAll();
}
