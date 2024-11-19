package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.MenuItem;
import org.sid.inventoryservice.services.MenuItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@AllArgsConstructor
@RequestMapping("/menuItem")
@RolesAllowed({"CUSTOMER","USER","ADMIN"})
public class MenuItemRestController {
    private MenuItemService menuItemService;
    @PostMapping("/addMenuItem")
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem){
        return menuItemService.addMenuItem(menuItem);
    }
}
