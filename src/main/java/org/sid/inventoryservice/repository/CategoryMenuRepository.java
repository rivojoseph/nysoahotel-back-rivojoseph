package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMenuRepository extends JpaRepository<CategoryMenu, Long> {
}
