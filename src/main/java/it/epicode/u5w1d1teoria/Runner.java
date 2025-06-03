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
    }
}
