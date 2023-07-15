package br.com.lucasmancan.pms.repositories;

import br.com.lucasmancan.pms.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    List<Person> findBySalary(BigDecimal salary);

    @Query(value = "SELECT p FROM Person p where (:salary is null or p.salary =:salary) and (:name is null or p.name =:name)")
    List<Person> findAll(@Param("salary") BigDecimal salary,@Param("name")  String name);
}
