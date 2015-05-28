package filmator.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AvaliacaoDAO;
import filmator.dao.FilmeDAO;

@Controller
public class AvaliacaoController {

	@Inject
	private FilmeDAO filmeDao;

	@Inject
	private AvaliacaoDAO avaliacaoDao;

	@RequestMapping(value = "/avaliacao", method = RequestMethod.GET)
	public String abreTelaAvaliacao(Model model) {
		model.addAttribute("filmes", new ArrayList<>());
		model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
		return "Avaliacao";
	}

	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public String curteFilme(Model model, Integer id) {
		model.addAttribute("filmes", new ArrayList<>());
		model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
		avaliacaoDao.inserirLike(id);
		return "Avaliacao";
	}

	@RequestMapping(value = "/dislike", method = RequestMethod.POST)
	public String naoCurteFilme(Model model, Integer id) {
		model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
		avaliacaoDao.inserirDislike(id);
		return "Avaliacao";
	}

}
