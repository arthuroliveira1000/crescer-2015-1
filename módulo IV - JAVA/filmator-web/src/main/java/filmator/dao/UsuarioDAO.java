package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Component
public class UsuarioDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserirUsuario(Usuario pessoaComum) {
		jdbcTemplate.update("INSERT INTO Usuario VALUES (?, ?, ?, ?)",
				pessoaComum.getNome(), pessoaComum.getApelido(),
				pessoaComum.getLogin(), pessoaComum.getSenha());
	}

	// para futura tela de cadastro de usuário admin
	public void inserirUsuarioAdmin(Usuario administrador) {
		jdbcTemplate.update("INSERT INTO Usuario VALUES (?, ?, ?, ?, ?)",
				administrador.getNome(), administrador.getApelido(),
				administrador.getTipoPerfil(), administrador.getLogin(),
				administrador.getSenha());
	}

	public Usuario buscaUsuario(Integer id_usuario) {
		List<Usuario> usuario = jdbcTemplate.query(
				"SELECT * FROM usuario WHERE id_usuario = ?",
				new RowMapper<Usuario>() {
					@Override
					public Usuario mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Usuario usuarioRetornado = new Usuario(id_usuario, rs
								.getString("nome"), rs.getString("apelido"), rs
								.getInt("tipoPerfil"));
						return usuarioRetornado;
					}
				}, id_usuario);
		if (usuario.isEmpty()) {
			return null;
		} else {
			return usuario.get(0);
		}
	}

	public Integer isAdmin(String login, String senha) {
		List<Integer> ids = jdbcTemplate
				.queryForList(
						"SELECT id_usuario FROM Usuario WHERE login = ? and senha=? and tipoPerfil = 1",
						Integer.class, login, senha);
		if (ids.isEmpty()) {
			return null;
		} else {
			return ids.get(0);
		}
	}
}
