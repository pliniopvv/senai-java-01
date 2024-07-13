package br.pvv.senai.saude.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.pvv.senai.saude.repository.UsuarioRepository;
import br.pvv.senai.saude.security.UsuariosDetails;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuariosDetails usuario = repository.findByLogin(username)
				.map(u -> new UsuariosDetails(u))
				.orElseThrow(() -> new UsernameNotFoundException("Nome de usuário não encontrado : " + username));
		
		return usuario;
	}

}
