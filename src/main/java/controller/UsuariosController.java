package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Usuario;

@RequestMapping("/usuarios")
@Controller
public class UsuariosController {

		@RequestMapping("/novo")
		public String novo(Usuario usuario) {
			return "usuario/CadastroUsuario";
		}

		@PostMapping("/novo")
		public String cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes atributes) {
			if (result.hasErrors()) {
				return novo(usuario);
			}

			// salvar no banco de dados...

			atributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!");
			System.out.println("");
			return "redirect: /usuarios/novo";

		}

	}



