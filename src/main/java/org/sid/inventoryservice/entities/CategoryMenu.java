package org.sid.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CategoryMenu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCatM;
    private String deco;
    private String nameCat;
    private String photoName;
}
