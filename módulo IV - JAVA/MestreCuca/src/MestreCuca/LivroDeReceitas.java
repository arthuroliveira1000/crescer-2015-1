package MestreCuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroDeReceitas implements LivroReceitas {

	private List<Receita> listaDeReceitas = new ArrayList<Receita>();

	@Override
	public void inserir(Receita receita) {
		if (!(receita.getNome().trim().equals("")) || !(receita == null)) {
			listaDeReceitas.add(receita);
		}
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		boolean argumentovalido = !receitaAtualizada.getNome().trim()
				.equals("")
				|| !(receitaAtualizada == null) || !nome.trim().equals("");

		if (argumentovalido) {
			for (int x = 0; x < listaDeReceitas.size(); x++) {
				if (listaDeReceitas.get(x).getNome().equals(nome)) {
					listaDeReceitas.set(x, receitaAtualizada);
				}
			}
		}

	}

	@Override
	public void excluir(String nome) {
		if (!nome.trim().equals("")) {
			for (int x = 0; x < listaDeReceitas.size(); x++) {
				if (listaDeReceitas.get(x).getNome().equals(nome)) {
					listaDeReceitas.remove(x);
				}
			}
		}

	}

	@Override
	public List<Receita> getTodasReceitas() {
		return listaDeReceitas;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {

		Receita receitaAchada = null;

		if (!nome.equals("")) {
			for (int x = 0; x < listaDeReceitas.size(); x++) {
				if (listaDeReceitas.get(x).getNome().equals(nome)) {
					receitaAchada = listaDeReceitas.get(x);
				}
			}
		}

		if (receitaAchada != null) {
			return receitaAchada;
		} else {
			throw new nomeNaoEncontrado("Nome da Receita n�o encontrado!");
		}
	}

	public float somaDasReceitas(List<Receita> lista) {
		float soma = 0;
		for (int x = 0; x < lista.size(); x++) {
			soma += lista.get(x).CalculaCusto();
		}
		return soma;
	}

	public List<Receita> protecaoAosAlergicos(
			List<Ingrediente> listaDeIngredientesProibidos) {

		List<Receita> listaDeProtecaoAosAlergicos = new ArrayList<Receita>();
		int cont = 0;

		for (int x = 0; x < listaDeReceitas.size(); x++) {
			cont = 0;
			for (int z = 0; z < listaDeReceitas.get(x).getListaDeIngredientes()
					.size(); z++) {

				for (int y = 0; y < listaDeIngredientesProibidos.size(); y++) {

					if (listaDeIngredientesProibidos.get(y).equals(
							listaDeReceitas.get(x).getListaDeIngredientes()
									.get(z))) {
						cont++;
					}
				}
			}
			if (cont == 0) {
				listaDeProtecaoAosAlergicos.add(listaDeReceitas.get(x));
			}

		}
		return listaDeProtecaoAosAlergicos;
	}

	public Map<Ingrediente, Integer> listaDeCompras(List<Receita> listaDeReceita) {
		Map<Ingrediente, Integer> listaDeCompras = new HashMap<Ingrediente, Integer>();
		
		for(Receita umaReceita: listaDeReceita) {
			for(Ingrediente umIngrediente: umaReceita.getListaDeIngredientes()) {
				
				listaDeCompras.getOrDefault(umIngrediente, 0); 
				//verificar a quantidade, se o item j� existir, pegar o item anterior
				// se n�o quantidade = 0;
				listaDeCompras.put(umIngrediente, (int) umIngrediente.getQuantidade());
			}
		}
		
		
		

		return listaDeCompras;
	}
}

// percorrer a lista de receita
// ver os que tem mesmo nome
// ver os que tem mesma unidade de medida
// comparar com o proximo valor
// somar as quantidades desses produtos
// mostrar as strings O.o o.O O.o O.o o.O O.o

