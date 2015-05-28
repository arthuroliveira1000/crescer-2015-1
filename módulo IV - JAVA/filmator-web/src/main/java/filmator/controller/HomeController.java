package filmator.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDAO;
import filmator.model.Filme;

@Controller
public class HomeController {

	@Inject
	private FilmeDAO filmeDao;

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String abreHome(Model model) {
		model.addAttribute("filmes", new ArrayList<>());
		model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
		return "Home"; // volta para a home, limpa o formulário
	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Filme filme) {
		filmeDao.inserir(filme);
		return "redirect:/Home";
	}

	// @ResponseBody faz transformar o retorno para JSON!
	// @RequestMapping(value = "/buscarTodos", method = RequestMethod.GET)
	// public List<Filme> buscarTodos(Model model) {
	// return filmeDao.buscaTodosFilmesJava8();
	// }
	@ResponseBody
	@RequestMapping(value = "/buscaFilme", method = RequestMethod.POST)
	public Filme buscaDetalhes(String nome, Model model) {
		return filmeDao.buscaFilme(nome);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public String excluiFilme(String nome, Model model) {
		filmeDao.excluir(nome);
		return "redirect:/Home";
	}
}
