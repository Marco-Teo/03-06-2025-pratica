package it.epicode.u5w1d1teoria;

import it.epicode.u5w1d1teoria.bean.Drink;
import it.epicode.u5w1d1teoria.bean.Menu;
import it.epicode.u5w1d1teoria.bean.Ordine;
import it.epicode.u5w1d1teoria.enumeration.TipoDrink;
import it.epicode.u5w1d1teoria.repository.DrinkRepository;
import it.epicode.u5w1d1teoria.repository.PizzaRepository;
import it.epicode.u5w1d1teoria.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private Menu menu;

    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

        menu.stampaMenu();




        Ordine ordine1 = ctx.getBean("ordine1", Ordine.class);
        Ordine ordine2 = ctx.getBean("ordine2", Ordine.class);
        Ordine ordine3 = ctx.getBean("ordine3", Ordine.class);

        stampaOrdine(ordine1);
        stampaOrdine(ordine2);
        stampaOrdine(ordine3);

        List<Drink> beers = drinkRepository.findByTipoDrink(TipoDrink.ANALCOLICO);
        System.out.println("\n--- BEER DRINKS ---");
        beers.forEach(d -> System.out.println(d.getNome()));

        List<Drink> expensiveDrinks = drinkRepository.findByPrezzoGreaterThan(5.0);
        System.out.println("\n--- DRINKS > 5 EURO ---");
        expensiveDrinks.forEach(d -> System.out.println(d.getNome()));
    }

    private void stampaOrdine(Ordine ordine) {
        System.out.println("\n===============================");
        System.out.println("ORDINE N°: " + ordine.getNumeroOrdine());
        System.out.println("Tavolo: " + ordine.getTavolo().getNumeroTavolo());
        System.out.println("Coperti: " + ordine.getNumeroCoperti());
        System.out.println("Stato: " + ordine.getStatoOrdine());
        System.out.println("Ora: " + ordine.getOraAcquisizione());
        System.out.println("Prodotti:");
        ordine.getProdotti().forEach(p -> {
            System.out.println(" - " + p.getNome() + " | €" + p.getPrezzo() + " | " + p.getCalorie() + " cal");
        });
        System.out.printf("Totale ordine (con coperto): €%.2f%n", ordine.getTotale());
    }
}
