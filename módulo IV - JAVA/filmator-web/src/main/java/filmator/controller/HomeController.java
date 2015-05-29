package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDAO;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class HomeController {

	@Inject
	private FilmeDAO filmeDao;

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String abreHome(Model model, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado == null) {
			return "Login"; // colocar tela de erro - faça seu login para
							// continuar
		} else {
			model.addAttribute("generos", Genero.values());
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
			return "Home"; // volta para a home, limpa o formulário
		}

	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Filme filme, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado == null) {
			return "Login"; // colocar tela de erro - faça seu login para
							// continuar
		} else {
			filmeDao.inserir(filme);
			return "redirect:/Home";
		}
	}

	// @ResponseBody faz transformar o retorno para JSON!
	// @RequestMapping(value = "/buscarTodos", method = RequestMethod.GET)
	// public List<Filme> buscarTodos(Model model) {
	// return filmeDao.buscaTodosFilmesJava8();
	// }
	@ResponseBody
	@RequestMapping(value = "/buscaFilme", method = RequestMethod.POST)
	public Filme buscaDetalhes(String nome, Model model, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado == null) {
			return null; // colocar tela de erro - faça seu login para
			// continuar
		} else {
			return filmeDao.buscaFilme(nome);
		}
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public String excluiFilme(String nome, Model model, HttpSession session) {
		Usuario userLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (userLogado == null) {
			return null;
		} else {
			filmeDao.excluir(nome);
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
			return "listaDeFilmesCadastrados";
		}
	}
}
