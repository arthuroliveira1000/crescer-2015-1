package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import mestrecuca.Ingrediente;
import mestrecuca.LivroDaVovo;
import mestrecuca.Receita;
import mestrecuca.ReceitaNaoEncontradaException;
import mestrecuca.UnidadeMedida;

import org.junit.Test;

public class TestaLivroDaVovo {

	@Test(expected = NullPointerException.class)
	public void naoInseriReceitaNula() {

		LivroDaVovo tudoGostoso = new LivroDaVovo();
		tudoGostoso.inserir(null);
		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(null);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void inseriDoisValores() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void atualizaUmValor() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = new Receita("Abobrinha com queijo");
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("Abobrinha", abobrinhaComQueijo);

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("Abobrinha", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test(expected = ReceitaNaoEncontradaException.class)
	public void naoAtualizaUmValorComNomeVazio() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = new Receita("Abobrinha com queijo");
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("", abobrinhaComQueijo);

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoAtualizaUmValorComNomeDaNovaReceitaVazio() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = new Receita("");
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("abobrinha", abobrinhaComQueijo);

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("abobrinha", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test(expected = NullPointerException.class)
	public void naoAtualizaUmValorSeANovaReceitaForNulaELancaExcecao() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhaComQueijo = null;
		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.atualizar("abobrinha", abobrinhaComQueijo);

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.atualizar("abobrinha", abobrinhaComQueijo);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void excluiUmValor() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.excluir("Abobrinha");

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.excluir("Abobrinha");
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void naoExcluiUmValorPorQueOnomeEstaVazio() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.excluir("");

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.excluir("");
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void buscaTodasReceitas() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");
		Receita abobrinhacompresunto = new Receita("Abobrinha com Presunto");

		tudoGostoso.inserir(abobrinha);
		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.excluir("Atum com salgadinho");
		tudoGostoso.inserir(abobrinhacompresunto);

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(abobrinha);
		teste.inserir(atumComSalgadinho);
		teste.excluir("Atum com salgadinho");
		teste.inserir(abobrinhacompresunto);
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void buscaListaDeReceitasVazia() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		LivroDaVovo teste = new LivroDaVovo();
		assertEquals(teste.getTodasReceitas(), tudoGostoso.getTodasReceitas());
	}

	@Test
	public void buscaUmaReceitaPeloNome() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.inserir(abobrinha);

		LivroDaVovo teste = new LivroDaVovo();
		teste.inserir(atumComSalgadinho);
		teste.inserir(abobrinha);
		assertEquals(teste.buscaReceitaPeloNome("Atum com salgadinho"),
				tudoGostoso.buscaReceitaPeloNome("Atum com salgadinho"));
	}

	@Test(expected = ReceitaNaoEncontradaException.class)
	public void buscaUmaReceitaPeloNomeVazioELancaExcecao() {
		LivroDaVovo tudoGostoso = new LivroDaVovo();
		Receita atumComSalgadinho = new Receita("Atum com salgadinho");
		Receita abobrinha = new Receita("Abobrinha");

		tudoGostoso.inserir(atumComSalgadinho);
		tudoGostoso.inserir(abobrinha);

		LivroDaVovo teste = new LivroDaVovo();
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
		LivroDaVovo tudoGostoso = new LivroDaVovo();
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
		Ingrediente atum = new Ingrediente("Atum", UnidadeMedida.UNIDADE, 2.0,
				2.5);
		Ingrediente abobrinha = new Ingrediente("Abobrinha",
				UnidadeMedida.UNIDADE, 2.0, 1.5);

		Ingrediente pao = new Ingrediente("pao", 4.0, 2.0,
				UnidadeMedida.UNIDADE);
		Ingrediente bife = new Ingrediente("Bife de carne", 7.5, 2.0,
				UnidadeMedida.UNIDADE);
		Ingrediente bacon = new Ingrediente("Bacon", 5.5, 2.0,
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
		LivroDaVovo tudoGostoso = new LivroDaVovo();

		assertEquals(21, tudoGostoso.somaDasReceitas(listaDeReceitas), 0.0005);
	}

	@Test
	public void geraListaDeComprasAgrupandoProdutosComMesmaUnidade()
			throws Exception {
		// Arrange
		LivroDaVovo livro = new LivroDaVovo();
		Receita feijoada = new Receita("Feijoada com Queijo e Mel");
		feijoada.adicionarIngrediente(new Ingrediente("Mel",
				UnidadeMedida.COLHER_SOPA, 1.0, 10.0));
		feijoada.adicionarIngrediente(new Ingrediente("Queijo",
				UnidadeMedida.KG, 1.0, 5.0));
		livro.inserir(feijoada);

		Receita arroz = new Receita("Arroz com Queijo");
		arroz.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.KG,
				2.0, 10.0));
		livro.inserir(arroz);

		// Act
		Map<Ingrediente, Double> listaDeCompras = livro.listaDeCompras(Arrays
				.asList(feijoada, arroz));

		// Assert
		assertEquals(2, listaDeCompras.size());
		assertTrue("Deve conter queijo na lista de compras",
				listaDeCompras.containsKey(new Ingrediente("Queijo",
						UnidadeMedida.KG)));
		assertTrue("Deve conter mel na lista de compras",
				listaDeCompras.containsKey(new Ingrediente("Mel",
						UnidadeMedida.COLHER_SOPA)));
	}

	@Test
	public void geraListaDeComprasAgrupandoProdutosComUnidadesDiferentes()
			throws Exception {
		// Arrange
		LivroDaVovo livro = new LivroDaVovo();
		Receita feijoada = new Receita("Feijoada com Queijo e Mel");
		feijoada.adicionarIngrediente(new Ingrediente("Mel",
				UnidadeMedida.COLHER_SOPA, 1.0, 10.0));
		feijoada.adicionarIngrediente(new Ingrediente("Queijo",
				UnidadeMedida.KG, 1.0, 5.0));
		livro.inserir(feijoada);

		Receita arroz = new Receita("Arroz com Queijo");
		arroz.adicionarIngrediente(new Ingrediente("Queijo", UnidadeMedida.KG,
				2.0, 10.0));
		arroz.adicionarIngrediente(new Ingrediente("Mel",
				UnidadeMedida.COLHER_CHA, 1.0, 10.0));
		livro.inserir(arroz);

		// Act
		Map<Ingrediente, Double> listaDeCompras = livro.listaDeCompras(Arrays
				.asList(feijoada, arroz));

		// Assert
		assertEquals(3, listaDeCompras.size());
		assertTrue("Deve conter queijo na lista de compras",
				listaDeCompras.containsKey(new Ingrediente("Queijo",
						UnidadeMedida.KG)));
		assertTrue("Deve conter colhe de sopa de mel na lista de compras",
				listaDeCompras.containsKey(new Ingrediente("Mel",
						UnidadeMedida.COLHER_SOPA)));
		assertTrue("Deve conter colhe de chá de mel na lista de compras",
				listaDeCompras.containsKey(new Ingrediente("Mel",
						UnidadeMedida.COLHER_CHA)));
	}
}
