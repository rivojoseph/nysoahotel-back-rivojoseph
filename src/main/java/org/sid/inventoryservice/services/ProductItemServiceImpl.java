package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.ProductItim;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service

public class ProductItemServiceImpl implements ProductItemService{

    @Override
    public PagedModel<ProductItim> getAllProductItims() {
        return null;
    }

    @Override
    public ProductItim addProductItem(ProductItim productItim) {
        return null;
    }

    @Override
    public ProductItim editProductItim(Long idProI, ProductItim productItim) {
        return null;
    }

    @Override
    public void dedleteProductItm(Long idProI) {

    }
}
