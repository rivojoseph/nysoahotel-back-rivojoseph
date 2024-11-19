package org.sid.inventoryservice.services;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.MenuItem;
import org.sid.inventoryservice.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;
    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
}
