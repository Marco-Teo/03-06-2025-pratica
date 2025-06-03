package it.epicode.u5w1d1teoria.bean;

import it.epicode.u5w1d1teoria.enumeration.TipoDrink;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Drink extends Prodotto{

    private TipoDrink tipoDrink;
}
