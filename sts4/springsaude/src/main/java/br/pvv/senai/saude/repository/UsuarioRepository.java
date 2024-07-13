package br.pvv.senai.saude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.saude.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByLogin(String login);
	
	Optional<Usuario> findByLoginAndSenha(String login, String senha);

}
