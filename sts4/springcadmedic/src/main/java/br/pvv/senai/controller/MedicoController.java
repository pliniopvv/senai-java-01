package br.pvv.senai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.model.Medico;
import br.pvv.senai.service.GenericService;
import br.pvv.senai.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController extends GenericController<Medico> {

	private MedicoService service;

	@Override
	public GenericService<Medico> getService() {
		return service;
	}

}
