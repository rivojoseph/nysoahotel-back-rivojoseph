package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Photo;
import org.sid.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.PagedModel;

public interface PhotoRepository extends JpaRepository<Photo,Long> {
    PagedModel<Photo> findPhotosByProduct(Product pd);
}
