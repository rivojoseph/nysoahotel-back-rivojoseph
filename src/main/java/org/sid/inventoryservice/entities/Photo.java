package org.sid.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Photo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String namePhoto;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Chambre chambre;
}
