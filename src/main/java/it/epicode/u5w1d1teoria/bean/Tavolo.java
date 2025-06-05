package it.epicode.u5w1d1teoria.bean;

import it.epicode.u5w1d1teoria.enumeration.StatoOrdine;
import it.epicode.u5w1d1teoria.enumeration.StatoTavolo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Tavolo {

    @Id
    private Long id;

    private int numeroTavolo;

    private StatoTavolo statoTavolo;

    private int numeroCoperti;


}
