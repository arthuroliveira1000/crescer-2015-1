package filmator;

public enum Genero {
	Comedia("Com�dia"), Acao("A��o"), Terror("Terror"), Suspense("Suspense"), Romance(
			"Romance"), FiccaoCientifica("Fic��o Cient�fica"), Drama("Drama");

	private String descricao;
	private int contador;
	
	
	public void incrementaContador() {
		this.contador++;
	}

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
