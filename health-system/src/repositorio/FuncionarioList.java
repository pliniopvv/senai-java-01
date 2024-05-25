package repositorio;

import java.util.ArrayList;
import java.util.List;

import entidades.Funcionario;

//[M2S03] Ex. 08 - Sistema de Saúde Parte 2 - Lista de Funcionários e Nutricionistas
public class FuncionarioList extends GenericList<Funcionario> {
	
	private static List<Funcionario> list = new ArrayList<>();

	public FuncionarioList() {
		super(list);
	}

}
