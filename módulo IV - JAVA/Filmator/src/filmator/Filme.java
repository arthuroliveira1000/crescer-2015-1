package filmator;

import java.util.ArrayList;

public class Filme {

	private String nome;
	private ArrayList<Ator> elenco = new ArrayList<Ator>();

	private Genero genero;

	public static void main(String[] args) {

		/*
		 * Ator megan = new Ator("Megan Fox"); Ator olivia = new
		 * Ator("Olivia Cooke"); Ator vera = new Ator("Vera Farmiga");
		 * 
		 * Filme dopele = new Filme("Filme do Pele");
		 * dopele.adicionaAtor(megan); dopele.adicionaAtor(olivia);
		 * 
		 * dopele.listaElenco("an");
		 */

	}

	public Filme(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
	}

	public ArrayList<Ator> listaElenco(String nome) {
		ArrayList<Ator> auxiliar = new ArrayList<Ator>();

		for (int x = 0; x < elenco.size(); x++) {
			if (elenco.get(x).getNome().contains(nome)) {
				auxiliar.add(elenco.get(x));
			}
		}
		return auxiliar;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Ator> getElenco() {
		return elenco;
	}

	public void setElenco(ArrayList<Ator> elenco) {
		this.elenco = elenco;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void adicionaAtor(Ator atorinserido) {
		elenco.add(atorinserido);
	}

	public String toString() {
		return this.nome;
	}

}
