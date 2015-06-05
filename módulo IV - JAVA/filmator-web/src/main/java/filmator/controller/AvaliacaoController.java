package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDAO;
import filmator.dao.FilmeDAO;
import filmator.model.Usuario;

@Controller
public class AvaliacaoController {

	@Inject
	private FilmeDAO filmeDao;

	@Inject
	private AvaliacaoDAO avaliacaoDao;

	@RequestMapping(value = "/avaliacao", method = RequestMethod.GET)
	public String abreTelaAvaliacao(Model model, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (usuarioLogado == null) {
			return "Login"; 
		} else {
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesCadastrados());
			return "Avaliacao";
		}
	}

	@RequestMapping(value = "/avalia", method = RequestMethod.POST)
	public String avaliar(Model model, Integer id_filme, int nota,
			HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (usuarioLogado == null) {
			return "Login";
		} else {
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesCadastrados());
			avaliacaoDao.inserirNota(id_filme, nota); // inserir nota no filme
			return "Avaliacao";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/mediaGeral", method = RequestMethod.POST)
	public Double avaliar(Model model, Integer id_filme, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if (usuarioLogado != null) {
			model.addAttribute("filmes", filmeDao.buscaTodosFilmesCadastrados());
			return avaliacaoDao.mediaGeral(id_filme);
		} else {
			return null;
		}
	}
}
