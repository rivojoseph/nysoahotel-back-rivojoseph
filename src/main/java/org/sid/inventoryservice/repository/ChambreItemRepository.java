package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.ChambreItem;
import org.sid.inventoryservice.enums.StatuCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ChambreItemRepository extends JpaRepository<ChambreItem, Long> {
    List<ChambreItem> findByChambre_IdAndStartAfterAndEndBefore(Long idcham,Date start, Date end);
    List<ChambreItem> findByChambre_Id(Long idcham);
    List<ChambreItem> findAllByReserver_Id(Long id);
    @Query("SELECT chi from ChambreItem chi where chi.reserver.status=:x order by chi.reserver.dateRes desc ")
    List<ChambreItem> finAllBySatus(@Param("x") StatuCommande status);
    @Query("SELECT chi from ChambreItem chi  order by chi.reserver.dateRes desc ")
    List<ChambreItem> finAllChambreItems();

}
