package br.pvv.senai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.model.IEntity;

public abstract class GenericService<T extends IEntity> {

	public abstract JpaRepository<T, Long> getRepository();
	
	public List<T> all() {
		return getRepository().findAll();
	}

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
	
	public Page<T> paged(Example<T> example, Pageable pageable) {
		return getRepository().findAll(example, pageable);
	}
	
	public Page<T> paged(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

}
