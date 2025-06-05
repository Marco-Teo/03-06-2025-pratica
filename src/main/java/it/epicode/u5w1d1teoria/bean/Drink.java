package it.epicode.u5w1d1teoria.bean;

import it.epicode.u5w1d1teoria.enumeration.TipoDrink;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Drink extends Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDrink tipoDrink;
}
