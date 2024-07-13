package br.pvv.senai.saude.services;

import br.pvv.senai.saude.dto.request.CadastroRequest;
import br.pvv.senai.saude.model.Usuario;
import br.pvv.senai.saude.repository.UsuarioRepository;

public class UsuarioService extends GenericService<Usuario> {

	public Long criarByRequest(CadastroRequest cadastro) {
		if (((UsuarioRepository) repository).findByLogin(cadastro.getUsername()).isPresent())
			throw new RuntimeException("Usuário " + cadastro.getUsername() + " já existe");

		Usuario entity = new Usuario();
		entity.setLogin(cadastro.getUsername());
		entity.setSenha(cadastro.getPassword());
		return repository.save(entity).getId();
	}

}
