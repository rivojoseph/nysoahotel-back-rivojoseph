package org.sid.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Chambre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroChambre;
    private String detailChambre;
    private boolean sonorisation;
    private double prixsono;
    private boolean decoration;
    private double prixdeco;
    private int nombrePerson;
    private boolean tv;
    private boolean wifi;
    private boolean eauChaude;
    private boolean climatiseur;
    private int nombrelit;
    private double prix;
    private boolean promo;
    private float prixpromo;
    private String photoname;
    private int selected;
    private boolean disponible;
    @ManyToOne
    private CategoryChambre categoryChambre;

}
