package MestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	private String nome;

	private List<Ingrediente> listaDeIngredientes = new ArrayList<Ingrediente>();

	private List<Instrucao> listaDeInstrucoes = new ArrayList<Instrucao>();

	public Receita() {
		
	}
	
	public Receita(String nome, List<Ingrediente> listaDeIngredientes,
			List<Instrucao> listaDeInstrucoes) {
		this.nome = nome;
		this.listaDeIngredientes = listaDeIngredientes;
		this.listaDeInstrucoes = listaDeInstrucoes;
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
