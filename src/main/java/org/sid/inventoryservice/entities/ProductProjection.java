package org.sid.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "fullProduct",types = Product.class)
public interface ProductProjection {
    public Long getId();
    public String getName();
    public String getDescription();
    public double getPrice();
    public Date getDateExpiration();
    public int getQuantity();
    public boolean getPromo();
    public double getPrixpromo();
    public boolean getSelected();
    public boolean getAvailable();
}
