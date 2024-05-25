package repositorio;

import java.util.ArrayList;
import java.util.List;

import entidades.Nutricionista;

//[M2S03] Ex. 08 - Sistema de Saúde Parte 2 - Lista de Funcionários e Nutricionistas
public class NutricionistaList extends GenericList<Nutricionista> {

	public static List<Nutricionista> list = new ArrayList<>();

	public NutricionistaList() {
		super(list);
	}

}
