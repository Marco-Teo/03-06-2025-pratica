package it.epicode.u5w1d1teoria.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
public class Topping extends Prodotto{

    @Id
    private Long id;

    private boolean glutenFree;
}
