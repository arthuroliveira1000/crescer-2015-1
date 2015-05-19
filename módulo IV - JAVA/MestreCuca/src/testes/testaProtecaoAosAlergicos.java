package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import MestreCuca.Ingrediente;
import MestreCuca.LivroDeReceitas;
import MestreCuca.Receita;

public class testaProtecaoAosAlergicos {

	@Test
	public void retornaDuasReceitasQueNaoTemFarofaEFrango() {

		Ingrediente frango = new Ingrediente("Frango Desfiado");
		Ingrediente farofa = new Ingrediente("Farofa");
		Ingrediente atum = new Ingrediente("O Atum");
		Ingrediente moranga = new Ingrediente("Moranga caramelizada");
		Ingrediente salgadinho = new Ingrediente("Salgadinho");
		Ingrediente acucar = new Ingrediente("Açucar");
		
		// RECEITA 1
		List<Ingrediente> delicia = new ArrayList<Ingrediente>();
		delicia.add(salgadinho);
		delicia.add(atum);

		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		atumComSalgadinho.setListaDeIngredientes(delicia);

		// RECEITA 2
		List<Ingrediente> muitobom = new ArrayList<Ingrediente>();
		delicia.add(acucar);
		delicia.add(moranga);

		Receita morangaCaramelizada = new Receita("Moranga Caramelizada");
		morangaCaramelizada.setListaDeIngredientes(muitobom);

		// RECEITA 3
		List<Ingrediente> maisoumenos = new ArrayList<Ingrediente>();
		maisoumenos.add(frango);
		maisoumenos.add(farofa);

		Receita frangoComFarofa = new Receita("Frango com farofa");
		frangoComFarofa.setListaDeIngredientes(maisoumenos);

		// ADICIONA AS RECEITAS NO LIVRO DE RECEITA
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.inserir(frangoComFarofa);
		tudoGostoso.inserir(morangaCaramelizada);

		// LISTA DE INGREDIENTES PROIBIDOS
	

		// LISTA DE RECEITAS BACANAS
		List<Receita> bacanas = new ArrayList<Receita>();
		bacanas.add(atumComSalgadinho);
		bacanas.add(morangaCaramelizada);
		System.out.println("TESTE");

		System.out.println("ATUAL");
		for (int i = 0; i < tudoGostoso.protecaoAosAlergicos(maisoumenos).size(); i++) {

			System.out.println(tudoGostoso.protecaoAosAlergicos(maisoumenos)
					.get(i).getNome());
			// System.out.println(bacanas.get(i).getNome());
		}

		System.out.println("ESPERADO");
		for (int i = 0; i < bacanas.size(); i++) {

			// System.out.println(tudoGostoso.protecaoAosAlergicos(proibidos).get(i).getNome());
			System.out.println(bacanas.get(i).getNome());
		}

		assertEquals(bacanas, tudoGostoso.protecaoAosAlergicos(maisoumenos));
	}

}
