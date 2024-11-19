package org.sid.inventoryservice.services;

import org.sid.inventoryservice.entities.Photo;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service

public class PhotoServiceImpl implements PhotoService{

    @Override
    public PagedModel<Photo> getAllPhotos() {
        return null;
    }

    @Override
    public Photo addPhoto(Photo photo) {
        return null;
    }

    @Override
    public Photo editPhoto(Long idPho, Photo photo) {
        return null;
    }

    @Override
    public void deletePhoto(Long idPho) {

    }
}
