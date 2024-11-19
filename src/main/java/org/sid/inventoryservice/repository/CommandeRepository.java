package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.AppRole;
import org.sid.inventoryservice.entities.AppUser;
import org.sid.inventoryservice.entities.Commande;
import org.sid.inventoryservice.enums.StatuCommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Page<Commande> findByAppUser_IdOrderByDateCreationDesc(Long id, Pageable pageable);
    @Query("select c from Commande c where c.id=:x and c.status=:y order by c.dateCreation desc ")
    Page<Commande> findByAppUser_IdAndStatus(@Param("x") Long id,@Param("y") StatuCommande status, Pageable pageable);
    @Query("select c from Commande c where c.status=:y order by c.dateCreation desc ")
    Page<Commande> findAllByStatus(@Param("y") StatuCommande status, Pageable pageable);
    Page<Commande> findByAppUser_AppRoles(AppRole role, Pageable pageable);
    @Query("select c from Commande c order by c.dateCreation desc ")
    Page<Commande> findAllCommande(Pageable pageable);
    int countByAppUser_Id (Long id);

}
