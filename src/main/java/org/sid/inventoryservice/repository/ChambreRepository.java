package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.CategoryChambre;
import org.sid.inventoryservice.entities.Chambre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Page<Chambre> findByCategoryChambreOrderByIdDesc(CategoryChambre categoryChambre,Pageable pageable);
}
