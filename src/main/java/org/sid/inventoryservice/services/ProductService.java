package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.Category;
import org.sid.inventoryservice.entities.Product;
import org.springframework.hateoas.PagedModel;

public interface ProductService {
    PagedModel<Product> getAllProducts();
    Product addProduct(Product product);
    Product editProduct(Long idProd,Product product);
    void  deleteProduct(Long idProd);

    //////////////////////////////////////////////////////////////////////////
    void setSelected(Product product);
    boolean setPromo(Product product);
    boolean setAvailable(Product product);
    PagedModel<Product> findProductsByCategory(Category c);
    PagedModel<Product>findProductsByPromotionIsTrue();
    PagedModel<Product>findProductsByDisponibleIsTrue();
    PagedModel<Product>findProductsByDisponibleIsFalse();
}
