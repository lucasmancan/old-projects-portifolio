package br.com.lucasmancan.pms.services.interfaces;

import br.com.lucasmancan.pms.exceptions.AppException;
import br.com.lucasmancan.pms.exceptions.AppNotFoundException;
import br.com.lucasmancan.pms.models.Person;

import java.math.BigDecimal;
import java.util.List;

public interface PersonService {
    Person create(Person person) throws AppException;

    Person update(Long id, Person person) throws AppException;

    List<Person> findAll(BigDecimal salary, String name);

    Person findById(Long id) throws AppNotFoundException;

}
