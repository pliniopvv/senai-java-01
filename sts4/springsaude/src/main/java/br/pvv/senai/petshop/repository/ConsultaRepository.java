package br.pvv.senai.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.petshop.model.Nutricionista;

public interface ConsultaRepository extends JpaRepository<Nutricionista, Long>  {

}
