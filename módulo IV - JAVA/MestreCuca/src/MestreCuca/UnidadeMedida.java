package MestreCuca;

public enum UnidadeMedida {

	GRAMA("Grama"), UNIDADE("Unidade"), XICARA("X�cara"), COLHER_SOPA(
			"Colher de Sopa"), KG("kg");

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
