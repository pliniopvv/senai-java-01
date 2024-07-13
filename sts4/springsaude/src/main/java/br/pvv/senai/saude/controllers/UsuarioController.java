package br.pvv.senai.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.dto.request.CadastroRequest;
import br.pvv.senai.saude.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/cadastro")
	public Long criaUsuario(@RequestBody CadastroRequest cadastroRequest) {
		return service.criarByRequest(cadastroRequest);
	}
}
