package org.sid.inventoryservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CategoryChambre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatCham;
    private String deco;
    private String nameCat;
    private String photoName;
}
