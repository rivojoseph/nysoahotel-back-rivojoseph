package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Photo;
import org.sid.inventoryservice.entities.ProductItim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItimRepository extends JpaRepository<ProductItim,Long> {
}
