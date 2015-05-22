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

	private FilmeDao dao = new FilmeDao();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Filme filme, Model model) {
		FilmeDao dao = new FilmeDao();
		model.addAttribute("mensagem", "fulano de tal");
		model.addAttribute("millisegundos", System.currentTimeMillis());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		model.addAttribute("generos", Genero.values());
		
		return "Home";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		System.out.println(filme.getNome());
		model.addAttribute("mensagem", filme.getNome() + " salvo com sucesso ");
		return "Home";
	}
}
