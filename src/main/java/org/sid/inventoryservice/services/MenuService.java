package org.sid.inventoryservice.services;


import org.sid.inventoryservice.entities.CategoryMenu;
import org.sid.inventoryservice.entities.Menu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MenuService {
    Menu addMenu(Menu menu);
    List<Menu> getAllMenus();
    Menu findOneMenu(Long idMen);
    Menu editMenu(Long idMen,Menu menu);
    void deleteMenu(Long idMen);
    //+++++++++++++++++++++++++++++++++++++++++++++++
    Menu modifVailableMenu(Long idMen,Boolean valable);
    Page<Menu> findByCategoryM(CategoryMenu categoryMenu,int page,int size);
}
