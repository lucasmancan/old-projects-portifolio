package br.com.lucasmancan.medtech.api.infraestructure.controllers;

import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Customer;
import br.com.lucasmancan.medtech.api.domain.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("customers")
@RestController
public class CustomerController extends AbstractController<Customer, CustomerService> {

    @ResponseBody
    @GetMapping
    public Page<Customer> findAll(@PageableDefault(page = 0, size = 15)
                                  @SortDefault.SortDefaults({
                                          @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                                  }) Pageable paginator,
                                  @RequestParam(required = false) String search) {
        return service.search(paginator, new SearchText(search));
    }

    @ResponseBody
    @GetMapping("/search")
    public List<Customer> search() {
        return service.findAll();
    }
}
