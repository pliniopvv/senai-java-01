package br.pvv.senai.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.model.Nutricionista;
import br.pvv.senai.saude.services.GenericService;
import br.pvv.senai.saude.services.NutricionistaService;

@RestController
@RequestMapping("/nutricionista")
public class NutricionistaController extends GenericController<Nutricionista> {

	@Autowired
	private NutricionistaService service;

	@Override
	public GenericService<Nutricionista> getService() {
		return service;
	}

}
