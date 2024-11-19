package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.MenuItem;
import org.sid.inventoryservice.repository.MenuItemRepository;

public interface MenuItemService {
    MenuItem addMenuItem(MenuItem menuItem);
}
