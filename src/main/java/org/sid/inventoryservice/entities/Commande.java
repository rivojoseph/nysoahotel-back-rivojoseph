package org.sid.inventoryservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date dateCreation;
    private StatuCommande status;
    @ManyToOne
    private AppUser appUser;
    @OneToMany(mappedBy = "commande")
    private List<MenuItem> menuItems=new ArrayList<>();

    public Double getTotal(){
        double somme=0;
        for (MenuItem mi:menuItems){
            somme+=mi.getAmount();
        }
        return somme;
    }
}



























