package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.CategoryMenu;
import org.sid.inventoryservice.entities.Menu;
import org.sid.inventoryservice.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private MenuRepository menuRepository;
    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findOneMenu(Long idMen) {
        return menuRepository.findById(idMen).get();
    }

    @Override
    public Menu editMenu(Long idMen, Menu menu) {
        Menu me = menuRepository.findById(idMen).get();
        me.setName(menu.getName());
        me.setIngredient(menu.getIngredient());
        me.setPrix(menu.getPrix());
        me.setPromo(menu.isPromo());
        me.setPrixpromo(menu.getPrixpromo());
        me.setVailable(menu.isVailable());
        me.setSelected(menu.getSelected());
        me.setPhotoName(menu.getPhotoName());
        me.setCategoryMenu(menu.getCategoryMenu());
        return menuRepository.save(me);
    }

    @Override
    public void deleteMenu(Long idMen) {
        Menu m = menuRepository.findById(idMen).get();
        menuRepository.delete(m);
    }

    @Override
    public Menu modifVailableMenu(Long idMen, Boolean valable) {
        Menu m = menuRepository.findById(idMen).get();
        m.setVailable(valable);
        return menuRepository.save(m);
    }

    @Override
    public Page<Menu> findByCategoryM(CategoryMenu categoryMenu, int page, int size) {
        return menuRepository.findByCategoryMenuOrderByIdMenDesc(categoryMenu, PageRequest.of(page,size));
    }
}
