package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.Category;
import org.sid.inventoryservice.exceptions.CategoryException;
import org.sid.inventoryservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCateorys() {
        if (categoryRepository.findAll().isEmpty())  throw new CategoryException("Veiller remplire les categories!");
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category editCategry(Long idCat, Category category) {
        Category c = categoryRepository.findById(idCat).get();
        c.setName(category.getName());

        return categoryRepository.save(c);
    }

    @Override
    public void deleteCategory(Long idCat) {
         categoryRepository.deleteById(idCat);
    }
}
