package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.ProductItim;
import org.springframework.hateoas.PagedModel;

public interface ProductItemService {
    PagedModel<ProductItim> getAllProductItims();
    ProductItim addProductItem(ProductItim productItim);
    ProductItim editProductItim(Long idProI,ProductItim productItim);
    void dedleteProductItm(Long idProI);
}
