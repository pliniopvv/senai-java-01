package br.pvv.senai.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.pvv.senai.models.ICollection;
import br.pvv.senai.models.IEntity;

@Service
public abstract class GenericCService<C extends ICollection, T extends IEntity> extends GenericService<T> {

	public abstract Class<C> GetType();

	public abstract JpaRepository<C, Integer> getCRepository();

	public List<C> findByParent(int id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		var instance = GetType().getDeclaredConstructor().newInstance();
		instance.setIdParent(id);
		Example<C> example = Example.of(instance);
		return getCRepository().findAll(example);
	}

}
