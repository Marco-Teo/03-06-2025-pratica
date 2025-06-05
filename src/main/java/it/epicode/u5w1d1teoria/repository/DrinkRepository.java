package it.epicode.u5w1d1teoria.repository;

import it.epicode.u5w1d1teoria.bean.Drink;
import it.epicode.u5w1d1teoria.enumeration.TipoDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findByTipoDrink(TipoDrink tipoDrink);

    @Query("SELECT d FROM Drink d WHERE d.prezzo > 1")
    List<Drink> findByPrezzoGreaterThan(double prezzo);
}

