package entidades;

import java.util.ArrayList;
import java.util.List;

import repositorio.GenericList;
import repositorio.IGenericListEntity;

//[M2S03] Ex. 02 - Sistema de Saúde Parte 2 - Endereço
public class Endereco extends GenericList<Endereco> implements IGenericListEntity {
	
	private String logradouro;
	private String Estado;
	private String Cidade;
	private int Numero;
	private int cep;
	
	private static List<Endereco> list = new ArrayList<>();
	
	public Endereco() {
		super(list);
		list.add(this);
	}
	
	public Endereco(String logradouro, String estado, String cidade, int numero, int cep) {
		super(list);
		list.add(this);
		this.logradouro = logradouro;
		Estado = estado;
		Cidade = cidade;
		Numero = numero;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
