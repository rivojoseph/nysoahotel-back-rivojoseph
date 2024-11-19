package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.AppUser;
import org.sid.inventoryservice.entities.Commande;
import org.springframework.data.domain.Page;

public interface CommandeService {
    Commande getOneCommande(Long idCom);
    Page<Commande> getAllCommandes(int page,int size);
    Commande addCommande(AppUser appUser);
    Commande editCommmande(Long idCom,Commande commande);
    void deleteCommande(Long idCom);
    int getCountComande(Long idUser);
    Page<Commande> getCommandeByCustomer(Long id, int page, int size);
    Page<Commande> getCommandeByCustomerStausCREATE(Long id, int page, int size);
    Page<Commande> getCommandeByCustomerStausCANCELED(Long id, int page, int size);
    Page<Commande> getCommandeByCustomerStausPENDING(Long id, int page, int size);
    Page<Commande> getCommandeByCustomerStausDELIVRED(Long id, int page, int size);
    Page<Commande> getCommandeStausCREATE(int page, int size);
    Page<Commande> getCommandeStausCANCELED(int page, int size);
    Page<Commande> getCommandeStausPENDING(int page, int size);
    Page<Commande> getCommandeStausDELIVRED(int page, int size);
    Page<Commande> getCommandeByCustomerRole(String role, int page, int size);

}
