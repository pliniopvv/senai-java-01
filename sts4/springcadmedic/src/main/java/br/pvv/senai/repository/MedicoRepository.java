package br.pvv.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pvv.senai.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
