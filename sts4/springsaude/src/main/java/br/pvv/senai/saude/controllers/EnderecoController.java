package br.pvv.senai.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.model.Endereco;
import br.pvv.senai.saude.services.EnderecoService;
import br.pvv.senai.saude.services.GenericService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends GenericController<Endereco> {

	@Autowired
	private EnderecoService service;

	@Override
	public GenericService<Endereco> getService() {
		return service;
	}

}
