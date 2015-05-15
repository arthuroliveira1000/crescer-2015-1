package filmator;

public enum Genero {
	Comedia("Comédia"), Acao("Ação"), Terror("Terror"), Suspense("Suspense"), Romance(
			"Romance"), FiccaoCientifica("Ficção Científica"), Drama("Drama");

	private String descricao;

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
