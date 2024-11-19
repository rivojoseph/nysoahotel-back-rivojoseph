package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.Reserver;
import org.sid.inventoryservice.enums.StatuCommande;
import org.sid.inventoryservice.services.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@RolesAllowed({"CUSTOMER","USER","ADMIN"})
public class reserationRestController {
    private ReservationService reservationService;

    @PostMapping("/createReservation")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Reserver creatreservation(@RequestBody Long idUser){
      return   reservationService.ceateReservation(idUser);
    }
    @GetMapping("/getoneReservation/{idRes}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Reserver getOnReservation(@PathVariable Long idRes){
        return reservationService.getOnrservation(idRes);
    }
    @GetMapping("/allreservation")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public Page<Reserver> getAllReservation(@RequestParam int page,@RequestParam int size){
        return reservationService.getAllReservation(page,size);
    }
    @GetMapping("/reservationByUser/{idUser}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public  Page<Reserver> getAllReservationByUser(@PathVariable Long idUser,@RequestParam int page,@RequestParam int size){
        return reservationService.getAllReservationByUser(idUser,page,size);
    }
    @PutMapping("/edit/{idRes}")
    @RolesAllowed({"USER","ADMIN"})
    public Reserver editReservation(@PathVariable Long idRes,@RequestBody Reserver reserver){
        return reservationService.editReservation(idRes,reserver);
    }
    @PutMapping("/edituser/{idRes}")
    @RolesAllowed({"CUSTOMER",})
    public Reserver editReservationByuser(@PathVariable Long idRes,@RequestBody String statu){
        Reserver reserver = reservationService.getOnrservation(idRes);
        if (StatuCommande.CREATED.equals(statu)){
            reserver.setStatus(StatuCommande.CREATED);
        }else {
            reserver.setStatus(StatuCommande.CANCELED);
        }
        return reservationService.editReservation(idRes,reserver);
    }
    @DeleteMapping("/delete/{idRes}")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    public void deleteReservatin(@PathVariable Long idRes){
        reservationService.delete(idRes);
    }

    @GetMapping("/statusCreate")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Reserver> getReserverStausCREATE(@RequestParam int page, @RequestParam int size){
        return reservationService.getReserverStausCREATE(page,size);
    }
    @GetMapping("/statusCanceled")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Reserver> getReserverStausCANCELED(@RequestParam int page, @RequestParam int size){
        return reservationService.getReserverStausCANCELED(page,size);
    }
    @GetMapping("/statusPending")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Reserver> getReserverStausPENDING(@RequestParam int page, @RequestParam int size){
        return reservationService.getReserverStausPENDING(page,size);
    }
    @GetMapping("/statusDelivered")
    @RolesAllowed({"CUSTOMER","USER","ADMIN"})
    private Page<Reserver> getReserverStausDELIVRED(@RequestParam int page, @RequestParam int size){
        return reservationService.getReserverStausDELIVRED(page,size);
    }
}
