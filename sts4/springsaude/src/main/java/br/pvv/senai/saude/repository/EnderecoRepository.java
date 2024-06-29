package br.pvv.senai.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.saude.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
