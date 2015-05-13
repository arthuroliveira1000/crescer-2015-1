package filmator;

public enum Genero {
	Comedia("Comédia"), Acao("Ação"), TERROR("Terror"), SUSPENSE("Suspense"), ROMANCE(
			"Romance");

	private String descricao;
	private int contador;

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	Genero(String descricao) {
		this.descricao = descricao;
	}

}
