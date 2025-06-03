package it.epicode.u5w1d1teoria.configuration;

import it.epicode.u5w1d1teoria.bean.*;
import it.epicode.u5w1d1teoria.enumeration.StatoOrdine;
import it.epicode.u5w1d1teoria.enumeration.StatoTavolo;
import it.epicode.u5w1d1teoria.enumeration.TipoDrink;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean(name = "acqua")
    public Drink getWater(){
        Drink water = new Drink();
        water.setTipoDrink(TipoDrink.ANALCOLICO);
        water.setCalorie(0);
        water.setPrezzo(1);
        water.setNome("Acqua");
        return water;
    }

    @Bean(name = "coca-cola")
    public Drink getCocaCola(){
        Drink cocaCola = new Drink();
        cocaCola.setTipoDrink(TipoDrink.ANALCOLICO);
        cocaCola.setCalorie(157);
        cocaCola.setPrezzo(3);
        cocaCola.setNome("Coca Cola");
        return cocaCola;
    }

    @Bean(name = "coca-cola-zero")
    public Drink getCocaColaZero(){
        Drink cocaCola = new Drink();
        cocaCola.setTipoDrink(TipoDrink.ANALCOLICO);
        cocaCola.setCalorie(5);
        cocaCola.setPrezzo(3);
        cocaCola.setNome("Coca Cola zero");
        return cocaCola;
    }

    @Bean(name = "birra")
    public Drink getBirra(){
        Drink birra = new Drink();
        birra.setTipoDrink(TipoDrink.ANALCOLICO);
        birra.setCalorie(250);
        birra.setPrezzo(3);
        birra.setNome("Birra Morertti");
        return birra;
    }

    @Bean(name = "tomato")
    public Topping getTomato(){
        Topping tomato = new Topping();
        tomato.setNome("Pomodoro");
        tomato.setPrezzo(3);
        tomato.setCalorie(50);
        tomato.setGlutenFree(true);
        return tomato;
    }
    @Bean(name = "funghi")
    public Topping getFunghi(){
        Topping funghi = new Topping();
        funghi.setNome("Funghi");
        funghi.setPrezzo(1);
        funghi.setCalorie(150);
        funghi.setGlutenFree(true);
        return funghi;
    }

    @Bean(name = "cotto")
    public Topping getCotto(){
        Topping cotto = new Topping();
        cotto.setNome("Cotto");
        cotto.setPrezzo(1);
        cotto.setCalorie(280);
        cotto.setGlutenFree(true);
        return cotto;
    }

    @Bean(name = "patatine")
    public Topping getPatatine(){
        Topping patatine = new Topping();
        patatine.setNome("Patatine");
        patatine.setPrezzo(1);
        patatine.setCalorie(300);
        patatine.setGlutenFree(false);
        return patatine;
    }

    @Bean(name = "salsiccia")
    public Topping getSalsiccia(){
        Topping salsiccia = new Topping();
        salsiccia.setNome("Salsiccia");
        salsiccia.setPrezzo(1);
        salsiccia.setCalorie(400);
        salsiccia.setGlutenFree(true);
        return salsiccia;
    }


    @Bean(name = "mozzarella")
    public Topping getMozzarella(){
        Topping mozzarella = new Topping();
        mozzarella.setNome("Mozzarella");
        mozzarella.setPrezzo(1);
        mozzarella.setCalorie(300);
        mozzarella.setGlutenFree(true);
        return mozzarella;
    }

    @Bean(name = "pizza-margherita")
    public Pizza getPizzaMargherita(){
        Pizza margherita = new Pizza();
        margherita.setNome("Margherita");
        margherita.setPrezzo(8);
        margherita.setCalorie(1300);
        Topping mozzarella = getMozzarella();
        Topping pomodoro = getTomato();
        margherita.setToppings(List.of(mozzarella, pomodoro));
        return margherita;
    }

    @Bean(name = "pizza-cotto-patatine")
    public Pizza getPizzaCottoPatatine(){
        Pizza cottoPatatine = new Pizza();
        cottoPatatine.setNome("cotto e patatine");
        cottoPatatine.setPrezzo(11);
        cottoPatatine.setCalorie(1800);
        Topping mozzarella = getMozzarella();
        Topping pomodoro = getTomato();
        Topping patatine = getPatatine();
        Topping cotto = getCotto();
        cottoPatatine.setToppings(List.of(mozzarella, pomodoro,patatine, cotto));
        return cottoPatatine;
    }

    @Bean(name = "pizza-cotto-funghi")
    public Pizza getPizzaCottoFunghi(){
        Pizza cottoFunghi = new Pizza();
        cottoFunghi.setNome("cotto e funghi");
        cottoFunghi.setPrezzo(14);
        cottoFunghi.setCalorie(1350);
        Topping mozzarella = getMozzarella();
        Topping pomodoro = getTomato();
        Topping cotto = getCotto();
        Topping funghi = getFunghi();
        cottoFunghi.setToppings(List.of(mozzarella, pomodoro,cotto, funghi));
        return cottoFunghi;
    }

    @Bean(name = "pizza-funghi-salsiccia")
    public Pizza getPizzaFunghiSalsiccia(){
        Pizza salsicciaFunghi = new Pizza();
        salsicciaFunghi.setNome("cotto, funghi e salsiccia");
        salsicciaFunghi.setPrezzo(14);
        salsicciaFunghi.setCalorie(1600);
        Topping mozzarella = getMozzarella();
        Topping pomodoro = getTomato();
        Topping salsiccia = getSalsiccia();
        Topping funghi = getFunghi();
        salsicciaFunghi.setToppings(List.of(mozzarella, pomodoro,salsiccia, funghi));
        return salsicciaFunghi;
    }

    @Bean(name = "tavolo1")
    public Tavolo tavolo1() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(1);
        tavolo.setNumeroCoperti(4);
        tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);
        return tavolo;
    }

    @Bean(name = "tavolo2")
    public Tavolo tavolo2() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(2);
        tavolo.setNumeroCoperti(2);
        tavolo.setStatoTavolo(StatoTavolo.LIBERO);
        return tavolo;
    }

    @Bean(name = "tavolo3")
    public Tavolo tavolo3() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(3);
        tavolo.setNumeroCoperti(4);
        tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);
        return tavolo;
    }

    @Bean(name = "ordine1")
    public Ordine ordine1(@Qualifier("pizza-margherita") Pizza pizza,
                          @Qualifier("acqua") Drink acqua,
                          @Qualifier("tavolo1") Tavolo tavolo) {
        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(1);
        ordine.setProdotti(List.of(pizza, acqua));
        ordine.setTavolo(tavolo);
        ordine.setNumeroCoperti(4);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setOraAcquisizione(LocalDateTime.now());
        return ordine;
    }

    @Bean(name = "ordine2")
    public Ordine ordine2(@Qualifier("pizza-cotto-patatine") Pizza pizza,
                          @Qualifier("birra") Drink birra,
                          @Qualifier("tavolo2") Tavolo tavolo) {
        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(2);  // Numero ordine diverso
        ordine.setProdotti(List.of(pizza, birra));
        ordine.setTavolo(tavolo);
        ordine.setNumeroCoperti(2);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setOraAcquisizione(LocalDateTime.now());
        return ordine;
    }

    @Bean(name = "ordine3")
    public Ordine ordine3(@Qualifier("pizza-cotto-funghi") Pizza pizza,
                          @Qualifier("coca-cola-zero") Drink cocaCola,
                          @Qualifier("tavolo3") Tavolo tavolo) {
        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(3);
        ordine.setProdotti(List.of(pizza, cocaCola));
        ordine.setTavolo(tavolo);
        ordine.setNumeroCoperti(4);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setOraAcquisizione(LocalDateTime.now());
        return ordine;
    }
}
