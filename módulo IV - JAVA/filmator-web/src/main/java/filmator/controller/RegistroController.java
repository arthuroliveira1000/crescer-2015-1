package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDAO;
import filmator.model.Usuario;

@Controller
public class RegistroController {

	@Inject
	private UsuarioDAO userDao;

	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String abreTelaRegistro(Model model) {
		return "Registro";
	}

	@RequestMapping(value = "/cadastroRealizado", method = RequestMethod.POST)
	public String cadastraUser(Usuario user, Model model, HttpSession session) {
		userDao.inserirUsuario(user);
		session.setAttribute("usuarioLogado", user);
		return "avaliacao";
	}

}
