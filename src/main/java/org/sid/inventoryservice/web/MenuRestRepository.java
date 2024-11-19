package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;

import org.sid.inventoryservice.entities.CategoryMenu;
import org.sid.inventoryservice.entities.Menu;

import org.sid.inventoryservice.services.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuRestRepository {
    private MenuService menuService;


    @GetMapping("/listmenu")
    public List<Menu> getAllMenu() {
        return menuService.getAllMenus();
    }

    @GetMapping("/onemenu/{idMen}")
    public Menu getOneMenu(@PathVariable Long idMen){
        return menuService.findOneMenu(idMen);
    }

    @PostMapping("/addmenu")
    public Object addCatmen(@RequestBody Menu menu, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String, Object> errors=new HashMap<>();
            errors.put("errors",true);
            for(FieldError fe: bindingResult.getFieldErrors()){
                errors.put(fe.getField(),fe.getDefaultMessage());
            }
            return errors;
        }
        return menuService.addMenu(menu);
    }

    @PutMapping("/editmenu/{id}")
    public Object editMenu(@PathVariable Long id, @RequestBody Menu menu, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String, Object> errors=new HashMap<>();
            errors.put("errors",true);
            for(FieldError fe: bindingResult.getFieldErrors()){
                errors.put(fe.getField(),fe.getDefaultMessage());
            }
            return errors;
        }
        return menuService.editMenu(id, menu);
    }
    @PutMapping("/modifvailable/{idMen}")
    public Menu modifValable(@PathVariable Long idMen,@RequestBody Boolean vailable){
        return menuService.modifVailableMenu(idMen,vailable);
    }

    @DeleteMapping("/deletemenu/{idMen}")
    public void deletemenu(@PathVariable Long idMen) {
        menuService.deleteMenu(idMen);
    }
    //---------------gestion menu avec parameter------------------

    @GetMapping("/listmenByCat/{categoryMenu}")
    public Page<Menu> getAllMenuByCat(@PathVariable CategoryMenu categoryMenu,@RequestParam int page,@RequestParam int size) {
        return menuService.findByCategoryM(categoryMenu, page, size);
    }
}
