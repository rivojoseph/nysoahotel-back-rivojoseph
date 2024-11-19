package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.AppRole;
import org.sid.inventoryservice.entities.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

    Page<AppUser> findAllByAppRolesContains(AppRole appRole, Pageable pageable);

}
