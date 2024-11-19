package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.AppRole;
import org.sid.inventoryservice.entities.AppUser;
import org.sid.inventoryservice.entities.Commande;
import org.sid.inventoryservice.enums.StatuCommande;
import org.sid.inventoryservice.repository.AppRoleRepository;
import org.sid.inventoryservice.repository.AppUserRepository;
import org.sid.inventoryservice.repository.CommandeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CommandeServiceImpl implements CommandeService{
    private CommandeRepository commandeRepository;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;



    @Override
    public Commande getOneCommande(Long idCom) {
        return commandeRepository.findById(idCom).get();
    }

    @Override
    public Page<Commande> getAllCommandes(int page,int size) {
        return commandeRepository.findAllCommande(PageRequest.of(page,size));
    }

    @Override
    public Commande addCommande(AppUser appUser) {
        Commande commande = new Commande();
        commande.setAppUser(appUser);
        commande.setStatus(StatuCommande.CREATED);
        commande.setDateCreation(new Date());
        return commandeRepository.save(commande);
    }

    @Override
    public Commande editCommmande(Long idCom, Commande commande) {
        commande.setId(idCom);
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Long idCom) {
        Commande commande = commandeRepository.findById(idCom).get();
        commandeRepository.delete(commande);
    }

    @Override
    public int getCountComande(Long idUser) {

        return commandeRepository.countByAppUser_Id(idUser);
    }

    @Override
    public Page<Commande> getCommandeByCustomer(Long id, int page, int size) {
        return commandeRepository.findByAppUser_IdOrderByDateCreationDesc(id, PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeByCustomerStausCREATE(Long id, int page, int size) {
        return commandeRepository.findByAppUser_IdAndStatus(id,StatuCommande.CREATED,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeByCustomerStausCANCELED(Long id, int page, int size) {
        return commandeRepository.findByAppUser_IdAndStatus(id,StatuCommande.CANCELED,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeByCustomerStausPENDING(Long id, int page, int size) {
        return commandeRepository.findByAppUser_IdAndStatus(id,StatuCommande.PENDING,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeByCustomerStausDELIVRED(Long id, int page, int size) {
        return commandeRepository.findByAppUser_IdAndStatus(id,StatuCommande.DELIVERED,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeStausCREATE(int page, int size) {
        return commandeRepository.findAllByStatus(StatuCommande.CREATED,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeStausCANCELED(int page, int size) {
        return commandeRepository.findAllByStatus(StatuCommande.CANCELED,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeStausPENDING(int page, int size) {
        return commandeRepository.findAllByStatus(StatuCommande.PENDING,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeStausDELIVRED(int page, int size) {
        return commandeRepository.findAllByStatus(StatuCommande.DELIVERED,PageRequest.of(page,size));
    }

    @Override
    public Page<Commande> getCommandeByCustomerRole(String role, int page, int size) {
        AppRole appRole = appRoleRepository.findByRoleName(role);
        return commandeRepository.findByAppUser_AppRoles(appRole, PageRequest.of(page,size));
    }
}
