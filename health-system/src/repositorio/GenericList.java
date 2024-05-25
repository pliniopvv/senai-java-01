package repositorio;

import java.lang.reflect.Array;
import java.util.List;

// [M2S02] Ex. 02 - Sistema de Sa�de - Lista de dados
public class GenericList<T extends IGenericListEntity> {
	private List<T> list;

	public GenericList(List<T> staticList) {
		list = staticList;
	}

	public T[] listar() {
		if (list.size() == 0) {
			return null;
		}

		T[] array = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
		array = (T[]) list.toArray(array);
		return array;
	}

//	[M2S03] Ex. 08 - Sistema de Sa�de Parte 2 - Lista de Funcion�rios e Nutricionistas
	public void adicionar(T model) {
		list.add(model);
	}

	public T buscarPorIr(int id) {
//		return list.stream().filter((e) -> e.getId() == id).findFirst().orElse(null);
		return list.get(id);
	}

	public boolean remover(T model) {
		return list.remove(model);
	}

	public T alterar(int id, T model) {
		return list.set(id, model);
	}
}
