package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.AppUser;
import org.sid.inventoryservice.entities.Commande;
import org.sid.inventoryservice.enums.StatuCommande;
import org.sid.inventoryservice.repository.CommandeRepository;
import org.sid.inventoryservice.services.CommandeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@AllArgsConstructor
@RequestMapping("/commande")
@RolesAllowed({"CUSTOMER","USER","ADMIN"})
public class OrderRestRepository {

    private CommandeService commandeService;
    private final CommandeRepository commandeRepository;

    @PostMapping("/addcommande")
    public Commande addCommande(@RequestBody AppUser appUser){
        return commandeService.addCommande(appUser);
    }
    @GetMapping("/commandeByCustomer/{id}")
    public Page<Commande> findCommandeByCustomer(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeByCustomer(id,page,size);
    }
    @GetMapping("/commandeByCustomerRole/{role}")
    public Page<Commande> findCommandeByCustomerRole(@PathVariable String role, @RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeByCustomerRole(role,page,size);
    }
    @GetMapping("/detail/{id}")
    public Commande getOnDetail(@PathVariable Long id){
        return commandeService.getOneCommande(id);
    }
    @GetMapping("/countCommande/{id}")
    public int countCommandeByCustomer(@PathVariable Long id){
        return commandeService.getCountComande(id);
    }
    @PutMapping("/editCreated/{idCom}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Commande editCommande0(@PathVariable Long idCom,@RequestBody Commande commande){
        commande.setStatus(StatuCommande.CREATED);
        return commandeService.editCommmande(idCom,commande);
    }
    @PutMapping("/editPending/{idCom}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Commande editCommande1(@PathVariable Long idCom,@RequestBody Commande commande){
        commande.setStatus(StatuCommande.PENDING);
        return commandeService.editCommmande(idCom,commande);
    }
    @PutMapping("/editDelivered/{idCom}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Commande editCommande2(@PathVariable Long idCom,@RequestBody Commande commande){
        commande.setStatus(StatuCommande.DELIVERED);
        return commandeService.editCommmande(idCom,commande);
    }
    @PutMapping("/editCanceled/{idCom}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Commande editCommande3(@PathVariable Long idCom,@RequestBody Commande commande){
        commande.setStatus(StatuCommande.CANCELED);
        return commandeService.editCommmande(idCom,commande);
    }

    @DeleteMapping("/delete/{idCom}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public void delete(@PathVariable Long idCom){
        commandeService.deleteCommande(idCom);
    }

    @GetMapping("/statusCreate/{id}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeByCustomerStausCREATE(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeByCustomerStausCREATE(id,page,size);
    }
    @GetMapping("/statusCanceled/{id}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeByCustomerStausCANCELED(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeByCustomerStausCANCELED(id,page,size);
    }
    @GetMapping("/statusPending/{id}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeByCustomerStausPENDING(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeByCustomerStausPENDING(id,page,size);
    }
    @GetMapping("/statusDelivered/{id}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeByCustomerStausDELIVRED(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeByCustomerStausDELIVRED(id,page,size);
    }
    @GetMapping("/statusCreate")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeStausCREATE(@RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeStausCREATE(page,size);
    }
    @GetMapping("/statusCanceled")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeStausCANCELED(@RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeStausCANCELED(page,size);
    }
    @GetMapping("/statusPending")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeStausPENDING(@RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeStausPENDING(page,size);
    }
    @GetMapping("/statusDelivered")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Commande> getCommandeStausDELIVRED(@RequestParam int page, @RequestParam int size){
        return commandeService.getCommandeStausDELIVRED(page,size);
    }
}
