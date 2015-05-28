package filmator.model;

public class Avaliacao {

	private Integer id_avaliacao;
	private Integer id_filme;
	private Integer id_usuario;
	private Integer like;
	private Integer dislike;
	private Integer nota;

	public Avaliacao() {

	}

	public Avaliacao(Integer id_avaliacao, Integer id_filme,
			Integer id_usuario, Integer like, Integer dislike, Integer nota) {
		super();
		this.id_avaliacao = id_avaliacao;
		this.id_filme = id_filme;
		this.id_usuario = id_usuario;
		this.like = like;
		this.dislike = dislike;
		this.nota = nota;
	}

	public Integer getId_avaliacao() {
		return id_avaliacao;
	}

	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}

	public Integer getId_filme() {
		return id_filme;
	}

	public void setId_filme(Integer id_filme) {
		this.id_filme = id_filme;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Integer getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

}
