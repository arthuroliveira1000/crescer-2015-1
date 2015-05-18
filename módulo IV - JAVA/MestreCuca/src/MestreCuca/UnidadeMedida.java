package MestreCuca;

public enum UnidadeMedida {

	GRAMA("Grama"), UNIDADE("Unidade"), XICARA("Xícara"), COLHER_SOPA(
			"Colher de Sopa");

	private String descricao;

	UnidadeMedida(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
