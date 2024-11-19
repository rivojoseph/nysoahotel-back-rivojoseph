package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.CategoryChambre;
import org.sid.inventoryservice.entities.Chambre;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChambreService {
    Chambre addChambre(Chambre chambre);
    List<Chambre> getAllChambres();
    Chambre findOneChambre(Long idCh);
    Chambre editChambre(Long idCham,Chambre chambre);
    Chambre modifierDisponibilite(Long id,boolean disponible);
    void deleteChambre(Chambre chambre);
    //+++++++++++++++++++++++++++++++++++++++++++++++
    Page<Chambre> findByCategoryCh(CategoryChambre categoryChambre,int page,int size);
}
