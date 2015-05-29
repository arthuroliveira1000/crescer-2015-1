package filmator.model;

public class Usuario {

	private Integer id_usuario;
	private String nome;
	private String apelido;
	private Integer tipoPerfil;
	private String login;
	private String senha;

	public Usuario() {
	}

	public Usuario(Integer id_usuario, String nome, String apelido,
			Integer tipoPerfil) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.apelido = apelido;
		this.tipoPerfil = tipoPerfil;
	}

	public Usuario(Integer id_usuario, String nome, String apelido,
			Integer tipoPerfil, String login, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.apelido = apelido;
		this.tipoPerfil = tipoPerfil;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(Integer id_usuario, String nome, String apelido,
			String login, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.apelido = apelido;
		this.login = login;
		this.senha = senha;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Integer getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(Integer tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
