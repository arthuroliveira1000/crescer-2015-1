package mestrecuca;

public enum UnidadeMedida {

	GRAMA("Grama"), UNIDADE("Unidade"), XICARA("X�cara"), COLHER_SOPA(
			"Colher de Sopa"), KG("kg"), COLHER_CHA("Colher de ch�");

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
