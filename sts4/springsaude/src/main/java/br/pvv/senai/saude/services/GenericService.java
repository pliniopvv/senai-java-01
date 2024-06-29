package br.pvv.senai.saude.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.saude.model.IEntity;

public class GenericService<T extends IEntity> {

	@Autowired
	protected JpaRepository<T, Long> repository;

	public T criar(T model) {
		return repository.save(model);
	}

	public T atualizar(long id, T model) {
		model.setId(id);
		return repository.save(model);
	}

	public void deletar(long id) {
		Optional<T> omodel = repository.findById(id);
		if (omodel.isPresent()) {
			repository.delete(omodel.get());
		}
	}

	public T buscar(long id) {
		Optional<T> resp = repository.findById(id);
		if (resp.isEmpty())
			return null;
		else
			return resp.get();
	}

}
