package br.com.lucasmancan.pms.controllers;

import br.com.lucasmancan.pms.exceptions.AppException;
import br.com.lucasmancan.pms.models.AppResponse;
import br.com.lucasmancan.pms.models.Person;
import br.com.lucasmancan.pms.services.interfaces.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/pessoas")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "A pessoa foi salva."),
    })
    @ApiOperation(value = "Atualiza informações da pessoa.", response = AppResponse.class)
    public AppResponse save(@RequestBody @Valid Person person) throws AppException {
        personService.create(person);
        return AppResponse.valueOf("A pessoa foi salva.");
    }

    @PutMapping("{id}")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A pessoa foi salva."),
            @ApiResponse(code = 400, message = "Requisição inválida")
    })
    @ApiOperation(value = "Atualiza uma pessoa.", response = AppResponse.class)
    public AppResponse update(@PathVariable("id") Long id, @RequestBody Person person) throws AppException {
        return AppResponse.valueOf("A pessoa foi salva.", personService.update(id, person));
    }

    @GetMapping("{id}")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @ApiOperation(value = "Busca uma pessoa específica.", response = AppResponse.class)
    public AppResponse get(@PathVariable("id") Long id) throws AppException {
        return AppResponse.valueOf("",  personService.findById(id));
    }

    @GetMapping
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
    })
    @ApiOperation(value = "Busca todas as pessoas da conta.", response = AppResponse.class)
    public AppResponse getAll(@RequestParam(value = "salary", required = false) BigDecimal salary, @RequestParam(value = "name", required = false) String name) {
        return AppResponse.valueOf("",  personService.findAll(salary, name));
    }
}
