package it.epicode.u5w1d1teoria.bean;

import it.epicode.u5w1d1teoria.enumeration.StatoOrdine;
import it.epicode.u5w1d1teoria.enumeration.StatoTavolo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Tavolo {

    private int numeroTavolo;

    private StatoTavolo statoTavolo;

    private int numeroCoperti;


}
