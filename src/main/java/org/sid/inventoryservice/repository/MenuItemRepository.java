package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
