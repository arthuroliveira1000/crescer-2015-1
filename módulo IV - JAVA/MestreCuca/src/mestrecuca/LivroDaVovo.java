package mestrecuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroDaVovo implements LivroReceitas {

	private List<Receita> listaDeReceitas = new ArrayList<Receita>();

	private void validaReceita(Receita receita) {
		String nome = receita.getNome();
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException(
					"Nome de receita nulo ou inválido");
		}
	}

	@Override
	public void inserir(Receita novaReceita) {
		validaReceita(novaReceita);
		listaDeReceitas.add(novaReceita);
	}

	@Override
	public void atualizar(String nome, Receita novaReceita) {
		validaReceita(novaReceita);
		Receita receitaAux = buscaReceitaPeloNome(nome);
		int indice = listaDeReceitas.indexOf(receitaAux);
		listaDeReceitas.set(indice, novaReceita);
	}

	@Override
	public void excluir(String nome) {
		if (!nome.trim().equals("")) {
			Receita receitaAux = buscaReceitaPeloNome(nome);
			int indice = listaDeReceitas.indexOf(receitaAux);
			listaDeReceitas.remove(indice);
		}

	}

	@Override
	public List<Receita> getTodasReceitas() {
		return listaDeReceitas;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		Receita receitaAchada;
		if (!nome.equals("")) {
			for (int x = 0; x < listaDeReceitas.size(); x++) {
				if (listaDeReceitas.get(x).getNome().equals(nome)) {
					return receitaAchada = listaDeReceitas.get(x);
				}
			}
		}
		throw new ReceitaNaoEncontradaException(nome);
	}

	public float somaDasReceitas(List<Receita> lista) {
		float soma = 0;
		for (int x = 0; x < lista.size(); x++) {
			soma += lista.get(x).CalculaCusto();
		}
		return soma;
	}

	public List<Receita> buscaReceitasQueNaoPossuemIngredientesDaLista(
			List<Ingrediente> ingredientesProibidos) {

		List<Receita> receitas = new ArrayList<Receita>();
		int cont = 0;

		for (int x = 0; x < listaDeReceitas.size(); x++) {
			cont = 0;
			for (int z = 0; z < listaDeReceitas.get(x).getListaDeIngredientes()
					.size(); z++) {

				for (int y = 0; y < ingredientesProibidos.size(); y++) {

					if (ingredientesProibidos.get(y).equals(
							listaDeReceitas.get(x).getListaDeIngredientes()
									.get(z))) {
						cont++;
					}
				}
			}
			if (cont == 0) {
				receitas.add(listaDeReceitas.get(x));
			}

		}
		return receitas;
	}

	public Map<Ingrediente, Double> listaDeCompras(List<Receita> listaDeReceita) {
		Map<Ingrediente, Double> listaDeCompras = new HashMap<Ingrediente, Double>();

		for (Receita umaReceita : listaDeReceita) {
			for (Ingrediente umIngrediente : umaReceita
					.getListaDeIngredientes()) {
				double quantidadeAcumulada = listaDeCompras.getOrDefault(
						umIngrediente, 0.0);
				double quantidadeDoIngrediente = umIngrediente.getQuantidade();
				listaDeCompras.put(umIngrediente, quantidadeAcumulada
						+ quantidadeDoIngrediente);
			}
		}
		return listaDeCompras;
	}
}