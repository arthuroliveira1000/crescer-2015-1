package filmator.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Administrador;

@Component
public class AdministradorDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserir(Administrador admin) {
		jdbcTemplate.update("INSERT INTO Administrador VALUES (?, ?, ?, ?)",
				admin.getApelido(), admin.getLogin(), admin.getSenha());
	}

}
