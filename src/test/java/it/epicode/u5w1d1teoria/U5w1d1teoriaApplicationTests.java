package it.epicode.u5w1d1teoria;

import it.epicode.u5w1d1teoria.bean.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class U5w1d1teoriaApplicationTests {

	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	public static void creaContesto(){
		ctx = new AnnotationConfigApplicationContext(U5w1d1teoriaApplication.class);
	}

	@Test
	public void verificaCostoCopertoTavolo1(){
		Tavolo t1 = ctx.getBean("tavolo1", Tavolo.class);

		assertEquals(4,t1.getNumeroCoperti());
	}

	@Test
	public void verificaNumeroPizzeEDrink(){

		Menu menu = ctx.getBean(Menu.class);

		long countPizze =menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Pizza).count();
		long countDrink =menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Drink).count();

		Assertions.assertAll(
				()-> assertEquals(4, countDrink),
				()-> assertEquals(4, countPizze)
		);
	}

	@Test
	public void verificaNumeroTopping(){

		Menu menu = ctx.getBean(Menu.class);


		long countTopping =menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Topping).count();

		Assertions.assertAll(
				()-> assertEquals(6, countTopping)

		);
	}

	@Test
	void menuNonContieneProdottiNulli() {
		Menu menu = ctx.getBean(Menu.class);
		assertTrue(menu.getProdotti().stream().noneMatch(Objects::isNull));
	}

	@Test
	void ordineConProdottiTotaleCorretto() {
		Ordine ordine = ctx.getBean("ordine1", Ordine.class);
		double expected = ordine.getProdotti().stream().mapToDouble(Prodotto::getPrezzo).sum() + ordine.getNumeroCoperti() * 2;
		assertEquals(expected, ordine.getTotale(), 0.01);
	}

	static Stream<Ordine> ordiniProvider() {
		return Stream.of(
				ctx.getBean("ordine1", Ordine.class),
				ctx.getBean("ordine2", Ordine.class),
				ctx.getBean("ordine3", Ordine.class)
		);
	}

	@ParameterizedTest
	@MethodSource("ordiniProvider")
	void testTotaleOrdinePositivo(Ordine ordine) {
		double totale = ordine.getTotale();
		System.out.println("Testing ordine n°" + ordine.getNumeroOrdine() + " con totale: €" + totale);
		assertTrue(totale > 0, "Il totale dell'ordine deve essere positivo");
	}
}


