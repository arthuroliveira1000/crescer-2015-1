package filmator.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserirNota(int id_filme, int nota) {
		jdbcTemplate.update(
				"INSERT INTO avaliacao (id_filme, nota) VALUES (?, ?)",
				id_filme, nota);
	}

	public Double mediaGeral(int id_filme) {
		Double media = (double) jdbcTemplate
				.update("SELECT sum(nota) /count(nota) FROM avaliacao WHERE id_filme = ?",
						id_filme);

		if(media == null) {
			media = 0.0;
		}
		
		return media;
	}
}
