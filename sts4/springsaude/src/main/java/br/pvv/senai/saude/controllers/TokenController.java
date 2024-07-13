package br.pvv.senai.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.dto.request.LoginRequest;
import br.pvv.senai.saude.services.TokenService;

@RestController
public class TokenController {

	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private TokenService service;

	@PostMapping("/login")
	public String token(@RequestBody LoginRequest login) {
		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(auth);

		// UsuariosDetails details = (UsuariosDetails) auth.getPrincipal();

		String token = service.geraToken(auth);
		return token;
	}
}
