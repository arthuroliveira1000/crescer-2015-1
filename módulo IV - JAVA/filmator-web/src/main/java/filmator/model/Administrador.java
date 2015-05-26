package filmator.model;

public class Administrador {
	private int id_administrador;
	private String apelido;
	private String login;
	private String senha;

	public Administrador() {

	}

	public Administrador(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Administrador(int id_administrador, String apelido, String login,
			String senha) {
		super();
		this.id_administrador = id_administrador;
		this.apelido = apelido;
		this.login = login;
		this.senha = senha;
	}

	public int getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(int id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
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
}
