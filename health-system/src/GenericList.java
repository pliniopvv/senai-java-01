import java.lang.reflect.Array;
import java.util.List;

// [M2S02] Ex. 02 - Sistema de Saúde - Lista de dados
public class GenericList<T extends IGenericListEntity> {
	private List<T> list;

	GenericList(List<T> staticList) {
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

	public T buscarPorIr(int id) {
		return list.stream().filter((e) -> e.getId() == id).findFirst().orElse(null);
	}

	public boolean remover(T model) {
		return list.remove(model);
	}

	public T alterar(int id, T model) {
		return list.set(id, model);
	}
}
