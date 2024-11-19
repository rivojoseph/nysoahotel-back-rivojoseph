package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.CategoryMenu;
import org.sid.inventoryservice.entities.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Page<Menu> findByCategoryMenuOrderByIdMenDesc(CategoryMenu categoryMenu, Pageable pageable);
}
