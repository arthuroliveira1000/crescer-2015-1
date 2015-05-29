package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AvaliacaoDAO;
import filmator.dao.FilmeDAO;
import filmator.model.Usuario;

@Controller
public class AvaliacaoController {

	@Inject
	private FilmeDAO filmeDao;

	@Inject
	private AvaliacaoDAO avaliacaoDao;

	@RequestMapping(value = "/avaliacao", method = RequestMethod.GET)
	public String abreTelaAvaliacao(Model model, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (usuarioLogado == null) {
			return "Login"; // montar pagina de erro ou retornar para o login
		} else {
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
			return "Avaliacao";
		}
	}

	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public String curteFilme(Model model, Integer id, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (usuarioLogado == null) {
			return "Login"; // tratarrr erro com uma paginaa
		} else {
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
			avaliacaoDao.inserirLike(id);
			return "Avaliacao";
		}
	}

	@RequestMapping(value = "/dislike", method = RequestMethod.POST)
	public String naoCurteFilme(Model model, Integer id, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (usuarioLogado == null) {
			return "Login";
		} else {
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
			avaliacaoDao.inserirDislike(id);
			return "Avaliacao";
		}
	}

}
