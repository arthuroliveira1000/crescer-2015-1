package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestrecuca.Ingrediente;
import mestrecuca.LivroDeReceitas;
import mestrecuca.Receita;
import mestrecuca.UnidadeMedida;
import mestrecuca.NomeNaoEncontrado;

import org.junit.Test;

public class TestaLivroDeReceitas {

	@Test(expected = NullPointerException.class)
	public void naoInseriReceitaNula() {

		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		tudoGostoso.inserir(null);
		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(null);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void inseriDoisValores() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void atualizaUmValores() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = new Receita("Abobrinha com queijo");
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("Abobrinha", abobrinhaComQueijo);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("Abobrinha", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void naoAtualizaUmValorComNomeVazio() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = new Receita("Abobrinha com queijo");
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("", abobrinhaComQueijo);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void naoAtualizaUmValorComNomeDaNovaReceitaVazio() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = new Receita("");
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("abobrinha", abobrinhaComQueijo);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("abobrinha", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test(expected = NullPointerException.class)
	public void naoAtualizaUmValorSeANovaReceitaForNulaELancaExcecao() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = null;
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("abobrinha", abobrinhaComQueijo);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("abobrinha", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void excluiUmValor() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.excluir("Abobrinha");

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.excluir("Abobrinha");
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void naoExcluiUmValorPorQueOnomeEstaVazio() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.excluir("");

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.excluir("");
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void buscaTodasReceitas() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhacompresunto = new Receita("Abobrinha com Presunto");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.excluir("Atum com salgadinho");
		tudoGostoso.inserir(abobrinhacompresunto);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.excluir("Atum com salgadinho");
		teste.inserir(abobrinhacompresunto);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void buscaListaDeReceitasVazia() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		LivroDeReceitas teste = new LivroDeReceitas();
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void buscaUmaReceitaPeloNome() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.inserir(abobrinha);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(atumComSalgadinho);
		teste.inserir(abobrinha);
		assertEquals(teste.buscaReceitaPeloNome("Atum com salgadinho"),
				tudoGostoso.buscaReceitaPeloNome("Atum com salgadinho"));
	}

	@Test(expected = NomeNaoEncontrado.class)
	public void buscaUmaReceitaPeloNomeVazioELancaExcecao() {
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.inserir(abobrinha);

		LivroDeReceitas teste = new LivroDeReceitas();
		teste.inserir(atumComSalgadinho);
		teste.inserir(abobrinha);
		assertEquals(teste.buscaReceitaPeloNome(""),
				tudoGostoso.buscaReceitaPeloNome(""));
	}

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
		for (int i = 0; i < tudoGostoso
				.buscaReceitasQueNaoPossuemIngredientesDaLista(maisoumenos)
				.size(); i++) {

			System.out.println(tudoGostoso
					.buscaReceitasQueNaoPossuemIngredientesDaLista(maisoumenos)
					.get(i).getNome());
			// System.out.println(bacanas.get(i).getNome());
		}

		System.out.println("ESPERADO");
		for (int i = 0; i < bacanas.size(); i++) {

			// System.out.println(tudoGostoso.protecaoAosAlergicos(proibidos).get(i).getNome());
			System.out.println(bacanas.get(i).getNome());
		}

		assertEquals(
				bacanas,
				tudoGostoso
						.buscaReceitasQueNaoPossuemIngredientesDaLista(maisoumenos));
	}

	@Test
	public void somaDuasReceitas() {

		// CRIA OS INGREDIENTES
		Ingrediente atum = new Ingrediente("Atum", 2.5, 2,
				UnidadeMedida.UNIDADE);
		Ingrediente abobrinha = new Ingrediente("Abobrinha", 1.5, 2,
				UnidadeMedida.UNIDADE);

		Ingrediente pao = new Ingrediente("pao", 4.0, 2, UnidadeMedida.UNIDADE);
		Ingrediente bife = new Ingrediente("Bife de carne", 7.5, 2,
				UnidadeMedida.UNIDADE);
		Ingrediente bacon = new Ingrediente("Bacon", 5.5, 2,
				UnidadeMedida.UNIDADE);
		// CRIA A LISTA DE INGREDIENTES E ADICIONA OS INGREDIENTES NAS
		// RESPECTIVAS LISTAS
		List<Ingrediente> listaDeIngredientesHamburguer = new ArrayList<>();
		listaDeIngredientesHamburguer.add(pao);
		listaDeIngredientesHamburguer.add(bife);
		listaDeIngredientesHamburguer.add(bacon);

		List<Ingrediente> listaDeIngredientesAtumComAbobrinha = new ArrayList<>();
		listaDeIngredientesAtumComAbobrinha.add(atum);
		listaDeIngredientesAtumComAbobrinha.add(abobrinha);

		// CRIA AS DUAS RECEITAS E ADICIONA SUAS RESPECTIVAS LISTAS DE
		// INGREDIENTES
		Receita atumComAbobrinha = new Receita("Atum com Abobrinha");
		atumComAbobrinha
				.setListaDeIngredientes(listaDeIngredientesAtumComAbobrinha);

		Receita hamburguer = new Receita("Hamburguer");
		hamburguer.setListaDeIngredientes(listaDeIngredientesHamburguer);

		// CRIA UMA LISTA DE RECEITAS E ADICIONA AS DUAS CRIADAS ANTERIORMENTE
		List<Receita> listaDeReceitas = new ArrayList<Receita>();
		listaDeReceitas.add(atumComAbobrinha);
		listaDeReceitas.add(hamburguer);

		// CRIA NOVO LIVRO DE RECEITAS
		LivroDeReceitas tudoGostoso = new LivroDeReceitas();

		assertEquals(21, tudoGostoso.somaDasReceitas(listaDeReceitas), 0.0005);
	}

}
