package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Empresa {

	private String nome;
	private ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
	private HashMap<String, Integer> listaDeVisualizacao = new HashMap<String, Integer>();

	public void adicionaFilme(Filme filmeinserido) {
		listaDeFilmes.add(filmeinserido);
	}

	public void geraRelatorio() {
		System.out.println("Filmes visualizados - por gênero:");

		for (Entry<String, Integer> entry : listaDeVisualizacao.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	public void reproduzirFilme(Filme filme) {

		Filme filmeParaReproduzir = null;

		// procura o filme na lista

		for (int x = 0; x < listaDeFilmes.size(); x++) {
			if (listaDeFilmes.get(x) == filme) {
				filmeParaReproduzir = listaDeFilmes.get(x);
			}
		}
		int contadorAtual = listaDeVisualizacao.getOrDefault(
				filmeParaReproduzir.getGenero().getDescricao(), 0);
		contadorAtual++;
		listaDeVisualizacao.put(filmeParaReproduzir.getGenero().getDescricao(),
				contadorAtual);
		listaDeVisualizacao.put(filmeParaReproduzir.getGenero().getDescricao(),
				contadorAtual);

		System.out.println("Reproduzindo: " + filme.getNome());

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Filme> getListaDeFilmes() {
		return listaDeFilmes;
	}

	public void setListaDeFilmes(ArrayList<Filme> listaDeFilmes) {
		this.listaDeFilmes = listaDeFilmes;
	}

	public HashMap<String, Integer> getListaDeVisualizacao() {
		return listaDeVisualizacao;
	}

	public void setListaDeVisualizacao(
			HashMap<String, Integer> listaDeVisualizacao) {
		this.listaDeVisualizacao = listaDeVisualizacao;
	}

}
