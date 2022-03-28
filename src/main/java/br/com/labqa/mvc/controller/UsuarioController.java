package br.com.labqa.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.com.labqa.mvc.dto.RequisicaoNovoUsuario;
import br.com.labqa.mvc.dto.ResponseSucess;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoUsuario requisicao) {
		return "usuario/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "usuario/formulario";
		}

		String url = "https://laboratorio-qa-usuarios.herokuapp.com/usuarios";
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.postForObject(url, requisicao, ResponseSucess.class);

		return "redirect:/home";
	}

}
