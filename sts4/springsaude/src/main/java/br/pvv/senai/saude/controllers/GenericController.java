package br.pvv.senai.saude.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.saude.model.IEntity;
import br.pvv.senai.saude.services.GenericService;

@RestController
public abstract class GenericController<T extends IEntity> {

	public abstract GenericService<T> getService();

	@PostMapping
	public T criar(@RequestBody T model) {
		return getService().criar(model);
	}

	@PutMapping("/{id}")
	public T atualizar(@PathVariable long id, @RequestBody T model) {
		return getService().atualizar(id, model);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable long id) {
		getService().deletar(id);
	}

	@GetMapping("/{id}")
	public T buscar(@PathVariable long id) {
		return getService().buscar(id);
	}

}
