package filmator.model;

public class Filme {

	private Integer id_filme;
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

	public Filme(Integer id_filme, String nome, String sinopse,
			String capaDoFilme) {
		this.id_filme = id_filme;
		this.nome = nome;
		this.sinopse = sinopse;
		this.capaDoFilme = capaDoFilme;
	}

	public Filme(String nome, Genero genero, Integer anoLancamento,
			String sinopse, String capaDoFilme) {
		this.nome = nome;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.capaDoFilme = capaDoFilme;
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

	public Integer getId_filme() {
		return id_filme;
	}

	public void setId_filme(Integer id_filme) {
		this.id_filme = id_filme;
	}

}
