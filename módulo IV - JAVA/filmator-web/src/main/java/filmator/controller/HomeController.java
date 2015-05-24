package filmator.controller;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {

	//responsavel por persistir os dados no banco
	private FilmeDao dao = new FilmeDao();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Filme filme, Model model) {
		model.addAttribute("generos", Genero.values());
		model.addAttribute("listaFilmes", dao.buscaTodosFilmes());
		return "Home";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		
		dao.salvar(filme);
		model.addAttribute("generos", Genero.values());
		model.addAttribute("listaFilmes", dao.buscaTodosFilmes());
		return "Home";
	}
}
