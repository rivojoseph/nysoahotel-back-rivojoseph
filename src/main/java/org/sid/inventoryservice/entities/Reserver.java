package org.sid.inventoryservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.inventoryservice.enums.StatuCommande;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Reserver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRes;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date dateRes;
    private StatuCommande status;
    @JoinColumn(name = "app_user_id")
    private Long id;
    @OneToMany(mappedBy = "reserver")
    private List<ChambreItem> chambreItems =new ArrayList<>();

    public double getTotal() {
        double somme= 0;
        for (ChambreItem chi: chambreItems){
            somme+= chi.getAmount();
        }
        return somme;
    }

}
