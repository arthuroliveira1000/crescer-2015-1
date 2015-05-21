package mestrecuca;

public class Ingrediente {

	private String nome;
	private Double preco;
	private float quantidade;
	private UnidadeMedida unidadeIngrediente;

	public Ingrediente(String nome) {
		this.nome = nome;
	}
	public Ingrediente(String nome, Double preco, float quantidade,
			UnidadeMedida unidadeIngrediente) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.unidadeIngrediente = unidadeIngrediente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadeMedida getUnidadeIngrediente() {
		return unidadeIngrediente;
	}

	public void setUnidadeIngrediente(UnidadeMedida unidadeIngrediente) {
		this.unidadeIngrediente = unidadeIngrediente;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((unidadeIngrediente == null) ? 0 : unidadeIngrediente
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (unidadeIngrediente != other.unidadeIngrediente)
			return false;
		return true;
	}


	
}
