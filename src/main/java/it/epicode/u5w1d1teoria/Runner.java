package it.epicode.u5w1d1teoria;

import it.epicode.u5w1d1teoria.bean.Menu;
import it.epicode.u5w1d1teoria.bean.Ordine;
import it.epicode.u5w1d1teoria.configuration.AppConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class Runner implements CommandLineRunner {

    @Override

    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Menu menu = new Menu(ctx);
        menu.stampaMenu();

        Ordine ordine1 = (Ordine) ctx.getBean("ordine1");
        Ordine ordine2 = (Ordine) ctx.getBean("ordine2");
        Ordine ordine3 = (Ordine) ctx.getBean("ordine3");

        stampaOrdine(ordine1);
        stampaOrdine(ordine2);
        stampaOrdine(ordine3);

        ctx.close();
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
