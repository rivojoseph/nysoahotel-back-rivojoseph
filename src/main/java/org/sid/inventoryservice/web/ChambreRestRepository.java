package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.CategoryChambre;

import org.sid.inventoryservice.entities.Chambre;
import org.sid.inventoryservice.services.ChambreService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestRepository {
    private ChambreService chambreService;

    @GetMapping("/listchambre")
    public List<Chambre> getAllCateMen(){
       return chambreService.getAllChambres();
    }
    @GetMapping("/onechambre/{idCh}")
    public Chambre getOneChambre(@PathVariable Long idCh){
        return chambreService.findOneChambre(idCh);
    }
    @PostMapping("/addchambre")
    public Chambre addCatmen(@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }
    @PutMapping("/editchambre/{id}")
    public Chambre editCatMen(@PathVariable Long id,@RequestBody Chambre chambre){
        return chambreService.editChambre(id,chambre);
    }
    @PutMapping("/modifdisponible/{idCh}")
    public Chambre modifValable(@PathVariable Long idCh, @RequestBody Boolean disponible){
        return chambreService.modifierDisponibilite(idCh,disponible);
    }
    @DeleteMapping("/deletechambre/{chambre}")
    public void deletecatmen(@PathVariable Chambre chambre){
        chambreService.deleteChambre(chambre);
    }

    //---------------gestion menu------------------

    @GetMapping("/listchambycat/{categoryChambre}")
    public Page<Chambre> getAllChambbyCat(@PathVariable CategoryChambre categoryChambre,@RequestParam int page,@RequestParam int size){
        return chambreService.findByCategoryCh(categoryChambre, page, size);
    }

}
