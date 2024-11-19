package org.sid.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private Date dateExpiration;
    private int quantity;
    private boolean promo;
    private int prixpromo;
    private int selected;
    private boolean available;
    @OneToMany(mappedBy = "product")
    private Collection<Photo> photos;
    @ManyToOne
    private Category category;
}
