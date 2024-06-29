package br.pvv.senai.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.petshop.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
