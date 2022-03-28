package br.com.labqa.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.labqa.mvc.model.Usuario;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping()
	public String home(Model model) {

		String url = "https://laboratorio-qa-usuarios.herokuapp.com/usuarios";
		RestTemplate restTemplate = new RestTemplate();

		Usuario[] listUsuario = restTemplate.getForObject(url, Usuario[].class);

		model.addAttribute("usuarios", listUsuario);

		return "home";
	}

	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {

		String url = "https://laboratorio-qa-usuarios.herokuapp.com/usuarios/" + status;
		RestTemplate restTemplate = new RestTemplate();

		Usuario[] listUsuario = restTemplate.getForObject(url, Usuario[].class);

		model.addAttribute("usuarios", listUsuario);
		model.addAttribute("status", status);
		return "home";
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public String onError() {
		return "redirect:/home";
	}

}
