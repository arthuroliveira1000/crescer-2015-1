package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestrecuca.Ingrediente;
import mestrecuca.Receita;
import mestrecuca.UnidadeMedida;

import org.junit.Test;

public class TestaReceita {

	@Test
	public void testaCalculaCustoDaReceitaComDoisIngredientes() {

		Receita atumComAbobrinha = new Receita("Atum com Abobrinha");
		Ingrediente atum = new Ingrediente("Atum", UnidadeMedida.UNIDADE, 2.0,
				2.5);
		Ingrediente abobrinha = new Ingrediente("Abobrinha",
				UnidadeMedida.UNIDADE, 2.0, 1.5);

		List<Ingrediente> listaDeIngredientes = new ArrayList<>();
		listaDeIngredientes.add(atum);
		listaDeIngredientes.add(abobrinha);
		atumComAbobrinha.setListaDeIngredientes(listaDeIngredientes);

		assertEquals(4, atumComAbobrinha.CalculaCusto(), 0.0005);

	}

	@Test
	public void garanteQueUmaReceitaTenhaSoOQuePrecisa() {

		Receita atumComAbobrinha = new Receita("Atum com Abobrinha");
		Ingrediente atum = new Ingrediente("Atum", UnidadeMedida.UNIDADE, 2.0,
				2.5);
		Ingrediente abobrinha = new Ingrediente("Abobrinha", UnidadeMedida.KG,
				2.0, 1.5);
		Ingrediente oregano = new Ingrediente("Oregano", UnidadeMedida.UNIDADE,
				2.0, 1.0);

		List<Ingrediente> listaDeIngredientes = new ArrayList<>();
		listaDeIngredientes.add(atum);
		listaDeIngredientes.add(abobrinha);
		listaDeIngredientes.add(oregano);

		listaDeIngredientes.remove(abobrinha);

		atumComAbobrinha.setListaDeIngredientes(listaDeIngredientes);

		assertEquals(3.5, atumComAbobrinha.CalculaCusto(), 0.0005);

	}
}
