package MestreCuca;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NameNotFoundException;

public class LivroDeReceitas implements LivroReceitas {

	private List<Receita> listaDeReceitas = new ArrayList<Receita>();

	@Override
	public void inserir(Receita receita) {
		boolean argumentovalido = !receita.getNome().equals("")
				|| !(receita == null);
		if (argumentovalido) {
			listaDeReceitas.add(receita);
		}
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		boolean argumentovalido = !receitaAtualizada.getNome().equals("")
				|| !(receitaAtualizada == null) || !nome.equals("");

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
		if (!nome.equals("")) {
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
			throw new nomeNaoEncontrado("Nome da Receita não encontrado!"); 
		}
	}

	public List<Receita> getListaDeReceitas() {
		return listaDeReceitas;
	}

}
