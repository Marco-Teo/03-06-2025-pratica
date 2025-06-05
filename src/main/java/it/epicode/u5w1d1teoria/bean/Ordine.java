package it.epicode.u5w1d1teoria.bean;

import it.epicode.u5w1d1teoria.enumeration.StatoOrdine;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@Entity
public class Ordine {

    @Id
    private Long id;

    private int numeroOrdine;

    private StatoOrdine statoOrdine;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Prodotto> prodotti;

    @ManyToOne
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
