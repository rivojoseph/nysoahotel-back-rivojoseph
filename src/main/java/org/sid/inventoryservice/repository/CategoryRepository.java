package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Category;
import org.sid.inventoryservice.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
