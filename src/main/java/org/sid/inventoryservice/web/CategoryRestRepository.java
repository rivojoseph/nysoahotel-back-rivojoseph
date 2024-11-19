package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.CategoryChambre;
import org.sid.inventoryservice.entities.CategoryMenu;
import org.sid.inventoryservice.services.CategoryChambreService;
import org.sid.inventoryservice.services.CategoryMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")

public class CategoryRestRepository {
    private CategoryMenuService categoryMenuService;
    private CategoryChambreService categoryChambreService;

    @GetMapping("/listcatmenu")
    public List<CategoryMenu> getAllCateMen(){
       return categoryMenuService.getAllcategory();
    }
    @GetMapping("/onecatmen/{idMen}")
    public CategoryMenu getOneMenu(@PathVariable Long idMen){
        return categoryMenuService.findOneCatMen(idMen);
    }
    @PostMapping("/addcatmen")
    public CategoryMenu addCatmen(@RequestBody CategoryMenu categoryMenu){
        return categoryMenuService.addCategoryMenu(categoryMenu);
    }
    @PutMapping("/editcatmen/{id}")
    public CategoryMenu editCatMen(@PathVariable Long id,@RequestBody CategoryMenu categoryMenu){
        return categoryMenuService.editCategoryMenu(id,categoryMenu);
    }
    @DeleteMapping("/deletecatmen/{catmen}")
    public void deletecatmen(@PathVariable CategoryMenu categoryMenu){
        categoryMenuService.delete(categoryMenu);
    }
    //---------------gestion menu------------------

    @GetMapping("/listcatcham")
    public List<CategoryChambre> getAllCategory(){
        return categoryChambreService.getAllcategory();
    }
    @GetMapping("/onecatchambre/{idCh}")
    public CategoryChambre getOneChambre(@PathVariable Long idCH){
        return categoryChambreService.findOneCatChambre(idCH);
    }
    @PostMapping("/addcatcham")
    public CategoryChambre addCatChambre(@RequestBody CategoryChambre categoryChambre){
        return categoryChambreService.addCategoryChambre(categoryChambre);
    }
    @PutMapping("/editcatCham/{id}")
    public CategoryChambre editCatCham(@PathVariable Long id,@RequestBody CategoryChambre categoryChambre){
        return categoryChambreService.editCategoryChambre(id,categoryChambre);
    }
    @DeleteMapping("/deletecatcham/{catcham}")
    public void deletecatChambre(@PathVariable CategoryChambre categoryChambre){
        categoryChambreService.delete(categoryChambre);
    }
}
