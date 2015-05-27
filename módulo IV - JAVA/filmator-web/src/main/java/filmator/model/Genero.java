package filmator.model;

public enum Genero {

	TERROR("Terror"), ACAO("Ação"), ROMANCE("Romance"), COMEDIA("Comédia"), COMEDIA_ROMANTICA(
			"Comédia Romantica"), ANIMACAO("Animação"), SUSPENSE("Suspense"), OUTRO(
			"Outro"), DOCUMENTARIO("Documentário"), FICCAO("Ficção"), FICCAO_CIENTIFICA(
			"Ficção Científica"), DRAMA("Drama"), BIOGRAFIA("Biografia");

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
