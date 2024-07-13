package br.pvv.senai.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.model.Paciente;
import br.pvv.senai.saude.security.UsuariosDetails;
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

	@Override
	public Paciente buscar(long id) {
		UsuariosDetails principal = (UsuariosDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (principal != null && principal.getId() == id)
			return super.buscar(id);
		return null;
	}

	@Override
	public Paciente atualizar(long id, Paciente model) {
		UsuariosDetails principal = (UsuariosDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (principal != null && principal.getId() == id)
			return super.atualizar(id, model);
		return null;
	}

	@Override
	public void deletar(long id) {
		UsuariosDetails principal = (UsuariosDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (principal != null && principal.getId() == id)
			super.deletar(id);
		return;
	}

}
