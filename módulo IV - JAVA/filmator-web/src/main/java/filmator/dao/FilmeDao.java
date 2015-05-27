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

@Component
public class FilmeDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserir(Filme filme) {
		jdbcTemplate
				.update("INSERT INTO Filme (nome, genero, anolancamento, sinopse, capadofilme) VALUES (?, ?, ?, ?, ?)",
						filme.getNome(), filme.getGenero().toString(),
						filme.getAnoLancamento(), filme.getSinopse(),
						filme.getCapaDoFilme());
	}

	public List<Filme> buscaTodosFilmesJava8() {
		return jdbcTemplate
				.query("SELECT nome, sinopse, capadofilme FROM Filme",
						(ResultSet rs, int rowNum) -> {
							Filme filme = new Filme(rs.getString("nome"), rs
									.getString("sinopse"), rs
									.getString("capaDoFilme"));
							return filme;
						});
	}

	public Filme buscaFilme(String nome) {
		List<Filme> filmes = jdbcTemplate.query(
				"SELECT * FROM FILME WHERE nome = '" + nome + "'",
				new RowMapper<Filme>() {
					@Override
					public Filme mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Filme filmeretornado = new Filme(rs.getString("nome"),
								Enum.valueOf(Genero.class,
										rs.getString("genero")), rs
										.getInt("anolancamento"), rs
										.getString("sinopse"), rs
										.getString("capadofilme"));
						return filmeretornado;
					}
				});
		if (filmes.isEmpty()) {
			return null;
		} else {
			return filmes.get(0);

		}
	}

	public void excluir(String nome) {
		jdbcTemplate.update("DELETE FROM FILME where nome = ?", nome);
	}

}
