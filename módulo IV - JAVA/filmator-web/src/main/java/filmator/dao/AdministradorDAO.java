package filmator.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Administrador;

@Component
public class AdministradorDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserir(Administrador admin) {
		jdbcTemplate.update("INSERT INTO Administrador VALUES (?, ?, ?)",
				admin.getApelido(), admin.getLogin(), admin.getSenha());
	}

	public boolean buscaID(String login, String senha) {
		List<Integer> ids = jdbcTemplate
				.queryForList(
						"SELECT id_administrador FROM ADMINISTRADOR WHERE login = ? and senha=?",
						Integer.class, login, senha);
		if (ids.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
