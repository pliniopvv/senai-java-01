package repositorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entidades.Consulta;

//[M2S03] Ex. 07 - Sistema de Saúde Parte 2 - Lista de consultas
public class ConsultaList {

	private static List<Consulta> list = new ArrayList<>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");

	public static void listar() {
		for (Consulta item : list) {
			String data = ConsultaList.sdf.format(item.getData());
			String nNutri = item.getNome_nutricionista();
			String nPaci = item.getNome_paciente();
			System.out.print(data);
			System.out.print(" - ");
			System.out.print(nNutri);
			System.out.print(" - ");
			System.out.print(nPaci);
			System.out.print("\n");
		}
	}

	public static void adicionar(Consulta model) {
		list.add(model);
	}

	public static void remover(Consulta model) {
		list.remove(model);
	}

	public static void alterar(Consulta model, int id) {
		list.add(id, model);
	}

	public static Consulta buscarPorId(int id) {
		return list.get(id);
	}
}
