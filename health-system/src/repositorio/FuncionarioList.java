package repositorio;

import java.util.ArrayList;
import java.util.List;

import entidades.Funcionario;

//[M2S03] Ex. 08 - Sistema de Sa�de Parte 2 - Lista de Funcion�rios e Nutricionistas
public class FuncionarioList extends GenericList<Funcionario> {
	
	private static List<Funcionario> list = new ArrayList<>();

	public FuncionarioList() {
		super(list);
	}

}
