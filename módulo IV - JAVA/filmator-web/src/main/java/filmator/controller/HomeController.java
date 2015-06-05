package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDAO;
import filmator.dao.UsuarioDAO;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class HomeController {

	@Inject
	private FilmeDAO filmeDao;

	@Inject
	private UsuarioDAO usuarioDao;

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String abreHomeAdmin(Model model, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		Integer isAdmin = usuarioDao.isAdmin(userLogado.getLogin(),
				userLogado.getSenha());
		if (userLogado == null) {
			return "Login";
		} else if (isAdmin != null) {
			model.addAttribute("generos", Genero.values());
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesCadastrados());
			return "Home";
		}
		return "Login";

	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Filme filme, HttpSession session, Model model) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado == null) {
			return "Login";
		} else {
			model.addAttribute("generos", Genero.values());
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesCadastrados());
			filmeDao.inserir(filme);
			return "Home";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/buscaFilme", method = RequestMethod.POST)
	public Filme buscaDetalhes(String nome, Model model, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado == null) {
			return null;
		} else {
			return filmeDao.buscaFilme(nome);
		}
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public String excluiFilme(Integer id_filme, Model model, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado == null) {
			return null;
		} else {
			filmeDao.excluir(id_filme);
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesCadastrados());
			return "listaDeFilmesCadastrados";
		}
	}
}
