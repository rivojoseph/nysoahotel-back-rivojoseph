package org.sid.inventoryservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ChambreItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    @ManyToOne
    private Chambre chambre;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Reserver reserver;
    private double prix;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date end;
    private int nombrenuit;
    private int nbadulte;
    private int nbenfant;
    private boolean isdeco;
    private boolean issono;
    private double discout;

    public double getAmount(){
        return prix*nombrenuit*(1-(discout/100));
    }

}
