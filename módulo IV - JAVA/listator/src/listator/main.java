package listator;

import java.io.File;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		imprimiEbusca();
	}

	public static void imprimiEbusca() {

		String dir = JOptionPane.showInputDialog(null,
				"Digite  o caminho do diret�rio: ");

		File diretorio = new File(dir);
		File fList[] = diretorio.listFiles();

		System.out.println("Numero de arquivos no diretorio : " + fList.length);

		for (int i = 0; i < fList.length; i++) {
			
			File arquivo = fList[i];
			System.out.println(arquivo.getName());

		}
	}
}
