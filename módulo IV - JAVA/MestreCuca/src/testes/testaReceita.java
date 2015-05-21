package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import MestreCuca.Ingrediente;
import MestreCuca.Receita;
import MestreCuca.UnidadeMedida;

public class testaReceita {

	@Test
	public void testaCalculaCustoDaReceitaComDoisIngredientes() {
		
		Receita atumComAbobrinha = new Receita("Atum com Abobrinha");
		Ingrediente atum = new Ingrediente("Atum", (float) 2.5 ,2,
				UnidadeMedida.UNIDADE);
		Ingrediente abobrinha = new Ingrediente("Abobrinha", (float) 1.5 ,2,
				UnidadeMedida.UNIDADE);
		
		List<Ingrediente> listaDeIngredientes = new ArrayList<>();
		listaDeIngredientes.add(atum);
		listaDeIngredientes.add(abobrinha);
		atumComAbobrinha.setListaDeIngredientes(listaDeIngredientes);
		
		assertEquals(4, atumComAbobrinha.CalculaCusto(), 0.0005);
		
	}
	
	
	
	@Test
	public void garanteQueUmaReceitaTenhaSoOQuePrecisa() {
		
		Receita atumComAbobrinha = new Receita("Atum com Abobrinha");
		Ingrediente atum = new Ingrediente("Atum", (float) 2.5 ,2,
				UnidadeMedida.UNIDADE);
		Ingrediente abobrinha = new Ingrediente("Abobrinha", (float) 1.5 ,2,
				UnidadeMedida.KG);
		Ingrediente oregano = new Ingrediente("Oregano", (float) 1.0 ,2,
				UnidadeMedida.UNIDADE);
		
		List<Ingrediente> listaDeIngredientes = new ArrayList<>();
		listaDeIngredientes.add(atum);
		listaDeIngredientes.add(abobrinha);
		listaDeIngredientes.add(oregano);
		
		listaDeIngredientes.remove(abobrinha);

		atumComAbobrinha.setListaDeIngredientes(listaDeIngredientes);
		
		assertEquals(3.5, atumComAbobrinha.CalculaCusto(), 0.0005);
		
	}
}
