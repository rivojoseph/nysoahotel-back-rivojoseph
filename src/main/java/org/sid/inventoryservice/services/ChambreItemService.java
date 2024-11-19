package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.ChambreItem;
import org.sid.inventoryservice.enums.StatuCommande;

import java.util.Date;
import java.util.List;

public interface ChambreItemService {
    ChambreItem addChambreItem(ChambreItem chambreItem);
    List<ChambreItem> getAllChamreItems();
    List<ChambreItem> getAllByChambreAndDate(Long idCam ,Date start,Date end);
    List<ChambreItem> getAllByChambre(Long idCham);
    List<ChambreItem> getAllByUser(Long idUs);
    List<ChambreItem> getAllByStatu(StatuCommande status);
}
