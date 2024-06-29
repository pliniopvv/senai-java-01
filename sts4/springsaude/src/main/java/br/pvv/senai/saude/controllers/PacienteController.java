package br.pvv.senai.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.model.Paciente;
import br.pvv.senai.saude.services.GenericService;
import br.pvv.senai.saude.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController extends GenericController<Paciente> {

	@Autowired
	protected PacienteService service;

	@Override
	public GenericService<Paciente> getService() {
		return service;
	}

}
