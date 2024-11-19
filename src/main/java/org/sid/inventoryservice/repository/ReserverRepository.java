package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Reserver;
import org.sid.inventoryservice.enums.StatuCommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReserverRepository extends JpaRepository<Reserver, Long> {
    Page<Reserver> findAll(Pageable pageable);
    Page<Reserver> findAllByIdOrderByDateResDesc(Long id,Pageable pageable);
    @Query("select r from Reserver r where r.status=:y order by r.dateRes desc ")
    Page<Reserver> findAllByStatus(@Param("y") StatuCommande status, Pageable pageable);
}
