package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.Reserver;
import org.sid.inventoryservice.enums.StatuCommande;
import org.sid.inventoryservice.repository.ReserverRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private ReserverRepository reserverRepository;

    @Override
    public Reserver ceateReservation(Long idUser) {
        Reserver r = new Reserver();
        r.setDateRes(new Date());
        r.setStatus(StatuCommande.CREATED);
        r.setId(idUser);
        return reserverRepository.save(r);
    }

    @Override
    public Reserver getOnrservation(Long idRes) {
        return reserverRepository.findById(idRes).get();
    }

    @Override
    public Page<Reserver> getAllReservation(int page,int size) {
        return reserverRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Page<Reserver> getAllReservationByUser(Long idUser,int page,int size) {
        return reserverRepository.findAllByIdOrderByDateResDesc(idUser,PageRequest.of(page,size));
    }

    @Override
    public void delete(Long idRes) {
        reserverRepository.deleteById(idRes);
    }

    @Override
    public Reserver editReservation(Long idRes, Reserver reserver) {
        reserver.setIdRes(idRes);
        return reserverRepository.save(reserver);
    }

    @Override
    public Page<Reserver> getReserverStausCREATE(int page, int size) {
        return reserverRepository.findAllByStatus(StatuCommande.CREATED,PageRequest.of(page,size));
    }

    @Override
    public Page<Reserver> getReserverStausCANCELED(int page, int size) {
        return reserverRepository.findAllByStatus(StatuCommande.CANCELED,PageRequest.of(page,size));
    }

    @Override
    public Page<Reserver> getReserverStausPENDING(int page, int size) {
        return reserverRepository.findAllByStatus(StatuCommande.PENDING,PageRequest.of(page,size));
    }

    @Override
    public Page<Reserver> getReserverStausDELIVRED(int page, int size) {
        return reserverRepository.findAllByStatus(StatuCommande.DELIVERED,PageRequest.of(page,size));
    }
}
