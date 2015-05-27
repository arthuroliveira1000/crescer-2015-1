package filmator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDAO;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {

	@Inject
	private FilmeDAO filmeDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("generos", Genero.values());
		model.addAttribute("filmes", new ArrayList<>());
		model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
		return "Home";
	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Filme filme) {
		filmeDao.inserir(filme);
		return "redirect:/"; // volta para a home, limpa o formulário
	}

	// @ResponseBody
	// @ResponseBody faz transformar o retorno para JSON!
	// @RequestMapping(value = "/buscarTodos", method = RequestMethod.GET)
	// public List<Filme> buscarTodos(Model model) {
	// return filmeDao.buscaTodosFilmesJava8();
	// }
	@RequestMapping(value ="/buscaFilme", method = RequestMethod.POST)
	public String buscaDetalhes(String nome, Model model) {
		model.addAttribute("filmeSelecionado", filmeDao.buscaFilme(nome));
		return "redirect:/";

	}
	
	@RequestMapping(value ="/excluir", method = RequestMethod.POST)
	public String excluiFilme(String nome, Model model) {
		filmeDao.excluir(nome);
		return "redirect:/";

	}

}
