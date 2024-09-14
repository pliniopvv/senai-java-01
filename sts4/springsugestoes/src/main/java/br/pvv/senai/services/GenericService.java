package br.pvv.senai.services;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.models.IEntity;

public class GenericService<T extends IEntity> {
	
	private JpaRepository<T, Integer> repository;

	public T find(int id) {
		return repository.findById(id).orElse(null);
	}

	public T save(T model) {
		return repository.saveAndFlush(model);
	}

	public T update(T model) {
		return repository.saveAndFlush(model);
	}

	public void delete(T model) {
		repository.delete(model);
	}

}
