package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.CategoryChambre;
import org.sid.inventoryservice.entities.Chambre;
import org.sid.inventoryservice.repository.ChambreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements ChambreService {
    private ChambreRepository chambreRepository;
    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre findOneChambre(Long idCh) {
        return chambreRepository.findById(idCh).get();
    }

    @Override
    public Chambre editChambre(Long idCham, Chambre chambre) {
        Chambre ch = chambreRepository.findById(idCham).get();
        ch.setCategoryChambre(chambre.getCategoryChambre());
        ch.setNumeroChambre(chambre.getNumeroChambre());
        ch.setSonorisation(chambre.isSonorisation());
        ch.setDecoration(chambre.isDecoration());
        ch.setNombrePerson(chambre.getNombrePerson());
        ch.setTv(chambre.isTv());
        ch.setWifi(chambre.isWifi());
        ch.setEauChaude(chambre.isEauChaude());
        ch.setClimatiseur(chambre.isClimatiseur());
        ch.setNombrelit(chambre.getNombrelit());
        ch.setPrix(chambre.getPrix());
        ch.setPromo(chambre.isPromo());
        ch.setPrixpromo(chambre.getPrixpromo());
        ch.setPhotoname(chambre.getPhotoname());
        ch.setSelected(chambre.getSelected());
        ch.setDisponible(chambre.isDisponible());
        return chambreRepository.save(ch);
    }

    @Override
    public Chambre modifierDisponibilite(Long id, boolean disponible) {
        Chambre c = chambreRepository.findById(id).get();
        c.setDisponible(disponible);
        return chambreRepository.save(c);
    }

    @Override
    public void deleteChambre(Chambre chambre) {
        chambreRepository.delete(chambre);
    }

    @Override
    public Page<Chambre> findByCategoryCh(CategoryChambre categoryChambre, int page, int size) {
        return chambreRepository.findByCategoryChambreOrderByIdDesc(categoryChambre, PageRequest.of(page,size));
    }
}
