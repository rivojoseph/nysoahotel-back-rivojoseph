package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.CategoryChambre;

import java.util.List;

public interface CategoryChambreService {
    CategoryChambre addCategoryChambre(CategoryChambre categoryChambre);
    List<CategoryChambre> getAllcategory();
    CategoryChambre findOneCatChambre(Long idCh);
    CategoryChambre editCategoryChambre(Long idCatChm,CategoryChambre categoryChambre);
    void delete(CategoryChambre categoryChambre);
}
