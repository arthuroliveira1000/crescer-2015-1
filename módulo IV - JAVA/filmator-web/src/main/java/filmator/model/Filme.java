package filmator.model;

public class Filme {

	private String nome;
	private Genero genero;
	private Integer anoLancamento;
	private String sinopse;
	private String capaDoFilme;

	public Filme() {

	}

	public Filme(String nome) {
		this.nome = nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapaDoFilme() {
		return capaDoFilme;
	}

	public void setCapaDoFilme(String capaDoFilme) {
		this.capaDoFilme = capaDoFilme;
	}

}
