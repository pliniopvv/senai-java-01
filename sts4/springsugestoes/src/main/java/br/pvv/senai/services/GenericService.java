package br.pvv.senai.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.pvv.senai.models.IEntity;

@Service
public abstract class GenericService<T extends IEntity> {
	
	public abstract JpaRepository<T, Integer> getRepository();

	public T find(int id) {
		return getRepository().findById(id).orElse(null);
	}

	public T save(T model) {
		return getRepository().saveAndFlush(model);
	}

	public T update(T model) {
		return getRepository().saveAndFlush(model);
	}

	public void delete(T model) {
		getRepository().delete(model);
	}

}
