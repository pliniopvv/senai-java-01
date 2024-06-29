package br.pvv.senai.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.model.Consulta;
import br.pvv.senai.saude.services.ConsultaService;
import br.pvv.senai.saude.services.GenericService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController extends GenericController<Consulta> {

	@Autowired
	private ConsultaService service;

	@Override
	public GenericService<Consulta> getService() {
		return service;
	}

}
