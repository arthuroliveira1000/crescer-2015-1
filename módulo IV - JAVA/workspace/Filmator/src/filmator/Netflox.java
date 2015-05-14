package filmator;

import java.util.ArrayList;

public class Netflox {

	private ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();

	public static void main(String[] args) {

		Filme boyhood = new Filme("BoyHood - Da Inf�ncia a Juventude",
				Genero.Drama);
		Filme interestelar = new Filme("Interestelar", Genero.FiccaoCientifica);

		Netflox teste = new Netflox();
		teste.adicionaFilme(interestelar);
		teste.adicionaFilme(boyhood);
		System.out.println(teste.listaDeFilmes);

		teste.reproduzirFilme(interestelar);
		teste.reproduzirFilme(boyhood);
		teste.reproduzirFilme(boyhood);
		teste.reproduzirFilme(boyhood);
		teste.geraRelatorio();
	}

	public void adicionaFilme(Filme filmeinserido) {
		listaDeFilmes.add(filmeinserido);
	}

	public Filme reproduzirFilme(Filme filme) {

		Filme filmeParaReproduzir = null;

		for (int x = 0; x < listaDeFilmes.size(); x++) {
			if (listaDeFilmes.get(x) == filme) {
				filmeParaReproduzir = listaDeFilmes.get(x);
			}
		}
		filmeParaReproduzir.getGenero().incrementaContador();
		return filmeParaReproduzir;
	}

	public void geraRelatorio() {
		Genero[] percorreEnum = Genero.values(); // cria um array do Enum e pega
													// os valores (objetos
													// Enum);
		System.out.println("Filmes visualizados - por g�nero:");
		// for (Genero e : percorreEnum) {
		// System.out.println(e.getDescricao() + ": " + e.getContador());
		// }

		for (int x = 0; x < percorreEnum.length; x++) {
			System.out.println(percorreEnum[x].getDescricao() + ": "
					+ percorreEnum[x].getContador());
		}
	}

}
