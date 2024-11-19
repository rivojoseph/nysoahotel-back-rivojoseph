package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.ChambreItem;
import org.sid.inventoryservice.enums.StatuCommande;
import org.sid.inventoryservice.repository.ChambreItemRepository;
import org.sid.inventoryservice.repository.ReserverRepository;
import org.sid.inventoryservice.services.ChambreItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ChambreItemRestController {

    private ChambreItemService itemService;
    private ChambreItemRepository repository;

    @PostMapping("/chambreItem/additem")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public ChambreItem addChambreItem(@RequestBody ChambreItem chambreItem){
        return itemService.addChambreItem(chambreItem);
    }
    @GetMapping("/chambreItem/getByChambre/{idCham}")
    public List<ChambreItem> getByChambre(@PathVariable Long idCham){
        return itemService.getAllByChambre(idCham);
    }
    @GetMapping("/chambreItem/getByChambreAndDate/{idCham}")
    public List<ChambreItem> getByChambreAndDate(@PathVariable Long idCham,@RequestParam Date start,@RequestParam Date end){
        return itemService.getAllByChambreAndDate(idCham,start,end);
    }
    @GetMapping("/chambreItem/chambreItemListByUser/{id}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public List<ChambreItem> chambreItemListByUser(@PathVariable Long id){
        return itemService.getAllByUser(id);
    }
    @GetMapping("/chambreItem/byStatus/0")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public List<ChambreItem> gatAllByStatus0(){
        return itemService.getAllByStatu(StatuCommande.CREATED);
    }
    @GetMapping("/chambreItem/byStatus/1")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public List<ChambreItem> gatAllByStatus1(){
        return itemService.getAllByStatu(StatuCommande.PENDING);
    }
    @GetMapping("/chambreItem/byStatus/2")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public List<ChambreItem> gatAllByStatus2(){
        return itemService.getAllByStatu(StatuCommande.DELIVERED);
    }
    @GetMapping("/chambreItem/byStatus/3")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public List<ChambreItem> gatAllByStatus(){
        return itemService.getAllByStatu(StatuCommande.CANCELED);
    }
    @GetMapping("/chambreItem/findAll")
    @RolesAllowed({"USER","ADMIN"})
    public List<ChambreItem> gatAllChambreItem(){
        return repository.finAllChambreItems();
    }

}
