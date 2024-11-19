package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.Category;
import org.springframework.hateoas.PagedModel;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCateorys();
    Category addCategory(Category category);
    Category editCategry(Long idCat,Category category);
    void deleteCategory(Long idCat);
}
