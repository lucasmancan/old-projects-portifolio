package br.com.lucasmancan.pms.services;

import br.com.lucasmancan.pms.exceptions.AppException;
import br.com.lucasmancan.pms.exceptions.AppNotFoundException;
import br.com.lucasmancan.pms.models.Person;
import br.com.lucasmancan.pms.repositories.PersonRepository;
import br.com.lucasmancan.pms.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person create(Person person) throws AppException {
        return repository.save(person);
    }

    @Override
    public Person update(Long id, Person person) throws AppException {
        var savedPerson = findById(id);

        savedPerson.setAge(person.getAge());

        savedPerson.setName(person.getName());

        savedPerson.setSalary(person.getSalary());

        return repository.save(savedPerson);
    }


    @Override
    public List<Person> findAll(BigDecimal salary, String name) {
        return repository.findAll(salary, name);
    }

    @Override
    public Person findById(Long id) throws AppNotFoundException {
        return repository.findById(id).orElseThrow(() -> new AppNotFoundException("Pessoa não encontrada"));
    }

}
