package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repositorio.GenericList;
import repositorio.IGenericListEntity;

//[M2S03] Ex. 06 - Sistema de Saúde Parte 2 - Consulta
public class Consulta extends GenericList<Consulta> implements IGenericListEntity {

	private String nome_nutricionista;
	private String nome_paciente;
	private Date Data;
	private boolean realizada;

	private static List<Consulta> list = new ArrayList<>();

	public Consulta() {
		super(list);
		list.add(this);
	}

	public Consulta(String nome_nutricionista, String nome_paciente, Date data, boolean realizada) {
		super(list);
		list.add(this);
		this.nome_nutricionista = nome_nutricionista;
		this.nome_paciente = nome_paciente;
		Data = data;
		this.realizada = realizada;
	}

	public String getNome_nutricionista() {
		return nome_nutricionista;
	}

	public void setNome_nutricionista(String nome_nutricionista) {
		this.nome_nutricionista = nome_nutricionista;
	}

	public String getNome_paciente() {
		return nome_paciente;
	}

	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public boolean isRealizada() {
		return realizada;
	}

	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
