package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDAO;
import filmator.model.Usuario;

@Controller
public class PaginaInicialController {

	@Inject
	private FilmeDAO filmeDao;

	@RequestMapping(value = "/PaginaInicial", method = RequestMethod.GET)
	public String abrePaginaInicial(Model model, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado != null) {
			model.addAttribute("usuarioLogado", userLogado);
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesCadastrados());
			return "PaginaInicial";
		}
		return "Login";

	}

}
