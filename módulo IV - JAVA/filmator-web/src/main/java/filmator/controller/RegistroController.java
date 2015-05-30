package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDAO;

@Controller
public class RegistroController {

	@Inject
	private UsuarioDAO userDao;
	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String abreTelaRegistro(Model model) {
		return "Registro";
	} 

	
	
}
