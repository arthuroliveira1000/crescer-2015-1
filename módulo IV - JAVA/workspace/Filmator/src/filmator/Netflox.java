package filmator;

import java.util.ArrayList;

public class Netflox extends Empresa {

	public static void main(String[] args) {

		Filme boyhood = new Filme("BoyHood - Da Infância a Juventude",
				Genero.Drama);
		Filme interestelar = new Filme("Interestelar", Genero.FiccaoCientifica);

		Netflox teste = new Netflox();
		teste.adicionaFilme(interestelar);
		teste.adicionaFilme(boyhood);
		System.out.println(teste.getListaDeFilmes());

		teste.reproduzirFilme(interestelar);
		teste.reproduzirFilme(boyhood);
		teste.reproduzirFilme(boyhood);
		teste.reproduzirFilme(boyhood);
		teste.geraRelatorio();

		System.out.println("--------------------------------------");
		Iltube tube = new Iltube();
		
		Filme boyhood1 = new Filme("BoyHood1 - Da Infância a Juventude",
				Genero.Drama);
		Filme interestelar1 = new Filme("Interestelar1",
				Genero.FiccaoCientifica);
		tube.adicionaFilme(interestelar1);
		tube.adicionaFilme(boyhood1);
		System.out.println(tube.getListaDeFilmes());

		tube.reproduzirFilme(interestelar1);
		tube.reproduzirFilme(boyhood1);
		tube.reproduzirFilme(boyhood1);
		tube.geraRelatorio();

	}

}
