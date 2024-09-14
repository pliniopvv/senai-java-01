package br.pvv.senai.saude.controllers;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.dto.request.LoginRequest;
import br.pvv.senai.saude.model.Usuario;
import br.pvv.senai.saude.security.UsuariosDetails;
import br.pvv.senai.saude.services.UsuarioService;

@RestController
public class TokenController {

	@Autowired
	private JwtEncoder jwtEncoder;
	@Autowired
	private UsuarioService usuarioService;
	private static long TEMPO_EXPIRACAO = 36000L;

	@PostMapping("/login")
	public ResponseEntity<String> geraToken(@RequestBody LoginRequest loginRequest) {
		Usuario usuarioEntity = usuarioService.login(loginRequest);

		if (usuarioEntity == null) return ResponseEntity.badRequest().build();
		
		UsuariosDetails uDetails = new UsuariosDetails(usuarioEntity);
		
		Instant agora = Instant.now();
		String scope = uDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		JwtClaimsSet claims = JwtClaimsSet.builder().issuer("self").issuedAt(agora)
				.expiresAt(agora.plusSeconds(TEMPO_EXPIRACAO)).subject(usuarioEntity.getLogin())
				.claim("scope", scope).build();
		var valorJwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
		return ResponseEntity.ok(valorJwt);
	}
}
