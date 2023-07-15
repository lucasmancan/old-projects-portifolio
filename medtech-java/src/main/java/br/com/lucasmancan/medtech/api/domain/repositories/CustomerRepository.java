package br.com.lucasmancan.medtech.api.domain.repositories;

import br.com.lucasmancan.medtech.api.domain.dto.paginator.Paginator;
import br.com.lucasmancan.medtech.api.domain.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAllByNameUserIdAndPaginate(Paginator paginator, String userId, String searchText);
}
