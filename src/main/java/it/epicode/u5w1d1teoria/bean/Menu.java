package it.epicode.u5w1d1teoria.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Component
public class Menu {
    @Autowired
    private List<Prodotto> prodotti;

    private ApplicationContext context;

    public Menu(ApplicationContext context) {
        this.context = context;
    }

    public void stampaMenu() {
        System.out.println("------ MENU PIZZE ------");

        Map<String, Pizza> pizze = context.getBeansOfType(Pizza.class);
        pizze.forEach((nome, pizza) -> {
            System.out.printf("Pizza: %s - €%.2f - %d kcal\n",
                    capitalize(pizza.getNome()), pizza.getPrezzo(), pizza.getCalorie());
            System.out.println("  Toppings:");
            pizza.getToppings().forEach(t -> {
                System.out.printf("    - %s (€%.2f, %d kcal, Gluten Free: %s)\n",
                        t.getNome(), t.getPrezzo(), t.getCalorie(), t.isGlutenFree() ? "sì" : "no");
            });
            System.out.println();
        });

        System.out.println("------ MENU DRINK ------");

        Map<String, Drink> drinks = context.getBeansOfType(Drink.class);
        drinks.forEach((nome, drink) -> {
            System.out.printf("Drink: %s - €%.2f - %d kcal - Tipo: %s\n",
                    drink.getNome(), drink.getPrezzo(), drink.getCalorie(), drink.getTipoDrink());
        });
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
