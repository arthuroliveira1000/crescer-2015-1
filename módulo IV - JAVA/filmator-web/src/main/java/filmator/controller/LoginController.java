package filmator.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AdministradorDAO;
import filmator.dao.FilmeDAO;
import filmator.model.Genero;

@Controller
public class LoginController {

	@Inject
	private AdministradorDAO adminDao;

	@Inject
	private FilmeDAO filmeDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String abreTelaLogin(Model model) {
		return "Login";
	}

	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public String abreTelaLogin(String login, String senha, Model model) {
		boolean adminExiste = adminDao.buscaID(login, senha);
		if (adminExiste) {
			model.addAttribute("generos", Genero.values());
			model.addAttribute("filmes", new ArrayList<>());
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
			return "Home";
		} else {
			return "Login";
		}
	}

}
