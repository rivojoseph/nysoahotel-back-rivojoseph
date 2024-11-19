package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.Photo;
import org.springframework.hateoas.PagedModel;

public interface PhotoService {
    PagedModel<Photo> getAllPhotos();
    Photo addPhoto(Photo photo);
    Photo editPhoto(Long idPho,Photo photo);
    void deletePhoto(Long idPho);
}
