package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDAO;
import filmator.dao.UsuarioDAO;
import filmator.model.Genero;

@Controller
public class LoginController {

	@Inject
	private UsuarioDAO userDao;

	@Inject
	private FilmeDAO filmeDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String abreTelaLogin(Model model) {
		return "Login";
	}

	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public String abreTelaAdministrador(String login, String senha,
			Model model, HttpSession session) {
		Integer isAdmin = userDao.isAdmin(login, senha);
		if (isAdmin != null) {
			model.addAttribute("generos", Genero.values());
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
			session.setAttribute("usuarioLogado", userDao.buscaUsuario(isAdmin));
			return "Home";
		} else {
			return "Login";
		}
	}

	// fazer um requestmapping para a home geral para os usuarios que não são
	// administradores
}
