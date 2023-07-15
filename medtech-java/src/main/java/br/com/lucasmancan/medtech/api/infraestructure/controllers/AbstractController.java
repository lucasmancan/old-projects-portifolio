package br.com.lucasmancan.medtech.api.infraestructure.controllers;

import br.com.lucasmancan.medtech.api.domain.entities.AbstractEntity;
import br.com.lucasmancan.medtech.api.domain.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class AbstractController<T extends AbstractEntity, S extends Service<T>> {

    @Autowired(required = false)
    protected S service;

    @ResponseBody
    @GetMapping("{id}")
    public T get(@PathVariable String id) {
        return service.findById(id);
    }

    @ResponseBody
    @PostMapping
    public T save(@RequestBody @Valid T data) {
        return service.save(data);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
