package br.com.lucasmancan.medtech.api.infraestructure.repositories.springData;

import br.com.lucasmancan.medtech.api.domain.dto.PrescriptionDTO;
import br.com.lucasmancan.medtech.api.domain.entities.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface PrescriptionRepositorySD extends JpaRepository<Prescription, String> {

    @Query("SELECT new br.com.lucasmancan.medtech.api.domain.dto.PrescriptionDTO(s.id, s.createdAt, s.expiresAt, c.name)\n" +
            "            from Prescription s \n" +
            "            JOIN Customer c on c.id = s.customerId where s.userId=:userId")
    @Transactional(readOnly = true)
    Page<PrescriptionDTO> findAll(Pageable pageable, String userId);

    @Query("SELECT new br.com.lucasmancan.medtech.api.domain.dto.PrescriptionDTO(s.id, s.createdAt, s.expiresAt, c.name) \n" +
            "            from Prescription s \n" +
            "            JOIN Customer c on c.id = s.customerId where s.userId=:userId \n" +
            "            and (CAST( s.id as string ) =:search OR lower(c.name) like concat('%',:search,'%')) ")
    @Transactional(readOnly = true)
    Page<PrescriptionDTO> findAllWithCustomSearch(Pageable pageable, String userId, String search);

    @Query("select p from Prescription p join fetch p.user join fetch p.customer left join fetch p.items i left join fetch i.drug where p.id=:id")
    @Transactional(readOnly = true)
    Prescription fetchAllById(String id);

    @Query("SELECT p FROM Prescription p left join fetch p.items i where p.id=:id order by i.createdAt")
    Optional<Prescription> findById(String id);

    @Query("SELECT p FROM Prescription p join fetch p.customer i where p.id=:prescriptionId")
    @Transactional(readOnly = true)
    Optional<Prescription> findWithCustomer(String prescriptionId);
}