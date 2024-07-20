package br.pvv.senai.model.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import br.pvv.senai.model.IEntity;

public class GenericDTO<T extends IEntity> {

	public T makeEntity(Class<T> type) throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		T entity = type.getDeclaredConstructor().newInstance();
		Field[] fields = type.getDeclaredFields();

		for (Field field : fields) {
			boolean modifiable = field.canAccess(entity);
			field.setAccessible(true);
			field.set(entity, field.get(this));
			field.setAccessible(modifiable);
		}

		return entity;
	}

}
