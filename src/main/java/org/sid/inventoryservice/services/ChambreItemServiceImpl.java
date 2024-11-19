package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.ChambreItem;
import org.sid.inventoryservice.enums.StatuCommande;
import org.sid.inventoryservice.repository.ChambreItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ChambreItemServiceImpl implements ChambreItemService {
    private ChambreItemRepository itemRepository;

    @Override
    public ChambreItem addChambreItem(ChambreItem chambreItem) {
        return itemRepository.save(chambreItem);
    }

    @Override
    public List<ChambreItem> getAllChamreItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<ChambreItem> getAllByChambreAndDate(Long idCham,Date start, Date end) {
        return itemRepository.findByChambre_IdAndStartAfterAndEndBefore(idCham,start,end);
    }

    @Override
    public List<ChambreItem> getAllByChambre(Long idCham) {
        return itemRepository.findByChambre_Id(idCham);
    }

    @Override
    public List<ChambreItem> getAllByUser(Long idUs) {
        return itemRepository.findAllByReserver_Id(idUs);
    }

    @Override
    public List<ChambreItem> getAllByStatu(StatuCommande status) {
        return itemRepository.finAllBySatus(status);
    }
}
