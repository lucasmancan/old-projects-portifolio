package br.com.lucasmancan.medtech.api.infraestructure.repositories.springData;

import br.com.lucasmancan.medtech.api.domain.entities.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DrugRepositorySD extends JpaRepository<Drug, String> {

    @Query(" SELECT s from Drug s ")
    @Transactional(readOnly = true)
    List<Drug> findAllNameAndIdByUser(String userId);

    @Query(" SELECT s from Drug s ")
    @Transactional(readOnly = true)
    Page<Drug> findAllByUserId(Pageable pageable);

    @Query(" SELECT s \n" +
            "            from Drug s\n" +
            "            where (CAST( s.id as string ) =:search OR lower(s.name) like concat('%',:search,'%'))")
    @Transactional(readOnly = true)
    Page<Drug> findAllWithCustonSearch(Pageable pageable, String search);
}
