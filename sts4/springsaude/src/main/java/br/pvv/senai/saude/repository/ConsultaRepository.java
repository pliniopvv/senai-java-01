package br.pvv.senai.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.saude.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>  {

}
