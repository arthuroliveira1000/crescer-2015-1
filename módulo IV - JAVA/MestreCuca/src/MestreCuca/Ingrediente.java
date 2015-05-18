package MestreCuca;

public class Ingrediente {

	private String nome;

	private double quantidade;

	private UnidadeMedida unidadeIngrediente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadeMedida getUnidadeIngrediente() {
		return unidadeIngrediente;
	}

	public void setUnidadeIngrediente(UnidadeMedida unidadeIngrediente) {
		this.unidadeIngrediente = unidadeIngrediente;
	}

}
