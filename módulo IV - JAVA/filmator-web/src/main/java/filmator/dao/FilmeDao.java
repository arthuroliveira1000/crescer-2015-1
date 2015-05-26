package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserir(Filme filme) {
		jdbcTemplate
				.update("INSERT INTO Filme (nome, genero, anolancamento, sinopse, capadofilme) VALUES (?, ?, ?, ?, ?)",
						filme.getNome(), filme.getGenero().toString(),
						filme.getAnoLancamento(), filme.getSinopse(),
						filme.getCapaDoFilme());
	}

	public List<Filme> buscaTodosFilmes() {

		return jdbcTemplate.query("SELECT nome FROM Filme",
				new RowMapper<Filme>() {
					@Override
					public Filme mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Filme filme = new Filme(rs.getString("nome"));
						return filme;
					}
				});
	}

	public List<Filme> buscaTodosFilmesJava8() {
		return jdbcTemplate.query("SELECT nome FROM Filme", (ResultSet rs,
				int rowNum) -> {
			Filme filme = new Filme(rs.getString("nome"));
			return filme;
		});

	}

}
