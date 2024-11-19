package org.sid.inventoryservice.services;


import org.sid.inventoryservice.entities.CategoryMenu;

import java.util.List;

public interface CategoryMenuService {
    CategoryMenu addCategoryMenu(CategoryMenu categoryMenu);
    List<CategoryMenu> getAllcategory();
    CategoryMenu findOneCatMen(Long idMen);
    CategoryMenu editCategoryMenu(Long idCatmen,CategoryMenu categoryMenu);
    void delete(CategoryMenu categoryMenu);
}
