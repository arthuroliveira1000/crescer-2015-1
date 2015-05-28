package filmator.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserirLike(int id_filme) {
		jdbcTemplate
				.update("INSERT INTO avaliacao (id_filme, likes) VALUES (?, ?)",
						id_filme, 1);
	}
	public void inserirDislike(int id_filme) {
		jdbcTemplate
				.update("INSERT INTO avaliacao (id_filme, dislike) VALUES (?, ?)",
						id_filme, 1);
	}

}
