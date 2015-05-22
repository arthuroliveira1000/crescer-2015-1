package filmator.model;

public enum Genero {

	TERROR("Terror"), ACAO("Ação"), ROMANCE("Romance"), COMEDIA("Comédia"), COMEDIA_ROMANTICA(
			"Comédia Romantica"), ANIMACAO("Animação"), SUSPENSE("Suspense");

	private String descricao;

	Genero(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
