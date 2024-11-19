package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.PagedModel;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //produits par Categories
    @Query("select p from Product p where p.category.id=:x and p.promo=:y")
    PagedModel<Product> getProduitsByPromotion(@Param("x") Long idCat, @Param("y") boolean promo);

    @Query("select p from Product p where p.category.id=:x and  p.name like %:y%")
    PagedModel<Product> getProduitsByNameContains(@Param("x") Long idCat, @Param("y") String name);
    //Produit par categorie
    PagedModel<Product> findProductsByCategoryId(Long idCat);
    //Produit par promotion
    PagedModel<Product> findProductsByCategoryIdAndPromoIsTrue(Long IdCat);

}
