package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.CategoryChambre;
import org.sid.inventoryservice.repository.CategoryChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryChambreServiceImpl implements CategoryChambreService {

    private CategoryChambreRepository chambreRepository;

    @Override
    public CategoryChambre addCategoryChambre(CategoryChambre categoryChambre) {
        return chambreRepository.save(categoryChambre);
    }

    @Override
    public List<CategoryChambre> getAllcategory() {
        return chambreRepository.findAll();
    }

    @Override
    public CategoryChambre findOneCatChambre(Long idCh) {
        return chambreRepository.findById(idCh).get();
    }

    @Override
    public CategoryChambre editCategoryChambre(Long idCatChm, CategoryChambre categoryChambre) {
        CategoryChambre ccham = chambreRepository.findById(idCatChm).get();
        ccham.setDeco(categoryChambre.getDeco());
        ccham.setNameCat(categoryChambre.getNameCat());
        ccham.setPhotoName(categoryChambre.getPhotoName());
        return chambreRepository.save(ccham);
    }

    @Override
    public void delete(CategoryChambre categoryChambre) {
        chambreRepository.delete(categoryChambre);
    }
}
