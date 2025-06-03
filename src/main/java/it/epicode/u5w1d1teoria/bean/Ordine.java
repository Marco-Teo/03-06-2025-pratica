package it.epicode.u5w1d1teoria.bean;

import it.epicode.u5w1d1teoria.enumeration.StatoOrdine;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Ordine {

    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private List<Prodotto> prodotti;
    private Tavolo tavolo;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;

    public double getTotale() {
        double totaleProdotti = prodotti.stream()
                .mapToDouble(Prodotto::getPrezzo)
                .sum();
        double prezzoCoperti = numeroCoperti * 2.0;
        return totaleProdotti + prezzoCoperti;
    }
}
