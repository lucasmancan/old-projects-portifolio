package br.com.lucasmancan.medtech.api.infraestructure.repositories.springData;

import br.com.lucasmancan.medtech.api.domain.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepositorySD extends JpaRepository<Customer, String> {

    @Query(" SELECT s \n" +
            "            from Customer s \n" +
            "            where s.userId=:userId")
    List<Customer> findAllByUser(String userId);

    @Query(" SELECT s \n" +
            "            from Customer s \n" +
            "            where s.userId=:userId")
    @Transactional(readOnly = true)
    Page<Customer> findPageableByUserId(Pageable pageable, String userId);

    @Query("SELECT s\n" +
            "            from Customer s \n" +
            "            where s.userId=:userId \n" +
            "            and (CAST( s.id as string ) =:search OR lower(s.name) like concat('%',:search,'%'))")
    @Transactional(readOnly = true)
    Page<Customer> findAllWithCustomSearch(Pageable pageable, String userId, String search);

}
