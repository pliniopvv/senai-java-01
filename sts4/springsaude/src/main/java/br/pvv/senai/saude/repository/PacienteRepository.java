package br.pvv.senai.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.saude.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
