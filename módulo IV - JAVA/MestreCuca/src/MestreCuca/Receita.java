package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	private String nome;

	private List<Ingrediente> listaDeIngredientes = new ArrayList<Ingrediente>();

	private List<Instrucao> listaDeInstrucoes = new ArrayList<Instrucao>();

	public Receita(String nome) {
		this.nome = nome;
	}

	public Receita(String nome, List<Ingrediente> listaDeIngredientes,
			List<Instrucao> listaDeInstrucoes) {
		this.nome = nome;
		this.listaDeIngredientes = listaDeIngredientes;
		this.listaDeInstrucoes = listaDeInstrucoes;
	}

	public float CalculaCusto() {
		float custoDaReceita = 0;
		for (int x = 0; x < listaDeIngredientes.size(); x++) {
			custoDaReceita += listaDeIngredientes.get(x).getPreco();
		}
		return custoDaReceita;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente> getListaDeIngredientes() {
		return listaDeIngredientes;
	}

	public void setListaDeIngredientes(List<Ingrediente> listaDeIngredientes) {
		this.listaDeIngredientes = listaDeIngredientes;
	}

	public List<Instrucao> getListaDeInstrucoes() {
		return listaDeInstrucoes;
	}

	public void setListaDeInstrucoes(List<Instrucao> listaDeInstrucoes) {
		this.listaDeInstrucoes = listaDeInstrucoes;
	}

}
