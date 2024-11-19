package org.sid.inventoryservice.services;


import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.CategoryMenu;
import org.sid.inventoryservice.repository.CategoryMenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryMenuServiceImpl implements CategoryMenuService {

    private CategoryMenuRepository menuRepository;

    @Override
    public CategoryMenu addCategoryMenu(CategoryMenu categoryMenu) {
        return menuRepository.save(categoryMenu);
    }

    @Override
    public List<CategoryMenu> getAllcategory() {
        return menuRepository.findAll();
    }

    @Override
    public CategoryMenu findOneCatMen(Long idMen) {
        return menuRepository.findById(idMen).get();
    }

    @Override
    public CategoryMenu editCategoryMenu(Long idCatmen, CategoryMenu categoryMenu) {
        CategoryMenu cmen = menuRepository.findById(idCatmen).get();
        cmen.setDeco(categoryMenu.getDeco());
        cmen.setNameCat(categoryMenu.getNameCat());
        cmen.setPhotoName(categoryMenu.getPhotoName());
        return menuRepository.save(cmen);
    }

    @Override
    public void delete(CategoryMenu categoryMenu) {
        menuRepository.delete(categoryMenu);
    }
}
