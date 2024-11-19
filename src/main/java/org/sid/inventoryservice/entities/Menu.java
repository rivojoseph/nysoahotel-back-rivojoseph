package org.sid.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMen;
    private String name;
    private String ingredient;
    private double prix;
    private boolean promo;
    private int prixpromo;
    private boolean vailable;
    private int selected;
    private String photoName;
    @ManyToOne
    private CategoryMenu categoryMenu;

}
