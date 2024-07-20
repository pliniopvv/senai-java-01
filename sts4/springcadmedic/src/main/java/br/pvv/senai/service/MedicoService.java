package br.pvv.senai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.pvv.senai.model.Medico;
import br.pvv.senai.repository.MedicoRepository;

@Service
public class MedicoService extends GenericService<Medico> {

	@Autowired
	private MedicoRepository repository;

	@Override
	public JpaRepository getRepository() {
		return this.repository;
	}
}
