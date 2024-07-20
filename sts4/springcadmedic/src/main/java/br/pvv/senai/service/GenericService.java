package br.pvv.senai.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.model.IEntity;

public abstract class GenericService<T extends IEntity> {

	public abstract JpaRepository<T, Long> getRepository();

	public Optional<T> load(long id) {
		return getRepository().findById(id);
	}

	public T save(T model) {
		return getRepository().save(model);
	}

	public T alter(T model) {
		return this.save(model);
	}

	public void delete(T model) {
		getRepository().delete(model);
	}

}
