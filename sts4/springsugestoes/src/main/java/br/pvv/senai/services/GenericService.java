package br.pvv.senai.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.pvv.senai.models.IEntity;

@Service
public abstract class GenericService<T extends IEntity> {

	protected final Log logger = LogFactory.getLog(getClass());

	public abstract JpaRepository<T, Integer> getRepository();

	public T find(int id) {
		logger.info("Consultando ID: " + id);
		return getRepository().findById(id).orElse(null);
	}

	public T save(T model) {
		logger.info("Consultando ID: " + model.getId());
		return getRepository().saveAndFlush(model);
	}

	public T update(T model) {
		logger.info("Consultando ID: " + model.getId());
		return getRepository().saveAndFlush(model);
	}

	public void delete(T model) {
		logger.info("Deletando Entidade ID: " + model.getId());
		getRepository().delete(model);
	}

}
