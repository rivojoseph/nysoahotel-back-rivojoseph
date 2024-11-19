package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.Reserver;
import org.springframework.data.domain.Page;

public interface ReservationService {
    Reserver ceateReservation(Long idUser);
    Reserver getOnrservation(Long idRes);
    Page<Reserver> getAllReservation(int page,int size);
    Page<Reserver> getAllReservationByUser(Long idUser,int page,int size);
    void delete(Long idRes);
    Reserver editReservation(Long idRes,Reserver reserver);
    Page<Reserver> getReserverStausCREATE(int page, int size);
    Page<Reserver> getReserverStausCANCELED(int page, int size);
    Page<Reserver> getReserverStausPENDING(int page, int size);
    Page<Reserver> getReserverStausDELIVRED(int page, int size);
}
