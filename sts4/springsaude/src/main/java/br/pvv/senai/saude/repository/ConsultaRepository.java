package br.pvv.senai.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.saude.model.Nutricionista;

public interface ConsultaRepository extends JpaRepository<Nutricionista, Long>  {

}
