package br.pvv.senai.saude.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.pvv.senai.saude.model.Usuario;

public class UsuariosDetails extends Usuario implements UserDetails {
	
	public UsuariosDetails() {
		}

	public UsuariosDetails(Usuario u) {
		this.setLogin(u.getLogin());
		this.setSenha(u.getSenha());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.getSenha();
	}

	@Override
	public String getUsername() {
		return this.getLogin();
	}

}
