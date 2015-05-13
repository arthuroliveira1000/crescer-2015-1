package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import filmator.Ator;
import filmator.Filme;
import filmator.Genero;

public class FilmeTest {

	@Test
	public void listaElencoFunciona() {

		Filme godzila = new Filme("Godzila", Genero.Acao);

		Ator vera = new Ator("Vera Farmiga");
		Ator megan = new Ator("Megan Fox");
		Ator angelina = new Ator("Angelina Joxlie");

		ArrayList<Ator> auxiliar = new ArrayList<Ator>();
		auxiliar.add(megan);
		auxiliar.add(angelina);
		
		godzila.adicionaAtor(vera);
		godzila.adicionaAtor(megan);
		godzila.adicionaAtor(angelina);

		assertEquals(auxiliar, godzila.listaElenco("ox"));

	}

	@Test
	public void adiciona2AtoresFunciona() {

		Filme godzila = new Filme("Godzila", Genero.Acao);
		Ator vera = new Ator("Vera Farmiga");
		Ator megan = new Ator("Megan Fox");

		ArrayList<Ator> auxiliar = new ArrayList<Ator>();
		auxiliar.add(vera);
		auxiliar.add(megan);
		godzila.adicionaAtor(vera);
		godzila.adicionaAtor(megan);

		assertEquals(auxiliar, godzila.getElenco());

	}

	@Test
	public void adiciona1AtorFunciona() {

		Filme powerrangers = new Filme("Power Rangers", Genero.Acao);
		Ator megan = new Ator("Megan Fox");
		ArrayList<Ator> auxilia = new ArrayList<Ator>();

		auxilia.add(megan);
		powerrangers.adicionaAtor(megan);

		assertEquals(auxilia, powerrangers.getElenco());
	}

	@Test
	public void toStringFunciona() {
		Filme godzila = new Filme("Godzila", Genero.Acao);

		assertEquals("Godzila", godzila.toString());

	}

}
