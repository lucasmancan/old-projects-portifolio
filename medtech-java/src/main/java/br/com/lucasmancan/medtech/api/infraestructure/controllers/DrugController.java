package br.com.lucasmancan.medtech.api.infraestructure.controllers;

import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Drug;
import br.com.lucasmancan.medtech.api.domain.services.DrugService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("drugs")
@RestController
public class DrugController extends AbstractController<Drug, DrugService> {

    @ResponseBody
    @GetMapping
    public Page<Drug> search(@PageableDefault(page = 0, size = 15)
                             @SortDefault.SortDefaults({
                                     @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                             }) Pageable paginator, @RequestParam(required = false) String name) {
        return service.search(paginator, new SearchText(name));
    }

    @ResponseBody
    @GetMapping("/search")
    public List<Drug> search() {
        return service.findAll();
    }

}
