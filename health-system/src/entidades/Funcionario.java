package entidades;

import java.util.ArrayList;
import java.util.List;

import repositorio.GenericList;
import repositorio.IGenericListEntity;

//[M2S03] Ex. 03 - Sistema de Saúde Parte 2 - Funcionário
public class Funcionario extends GenericList<Funcionario> implements IGenericListEntity {
	
	private String nome;
	private int idade;
	private Endereco endereco;
	private double salario;
	
	private static List<Funcionario> list = new ArrayList<>();
	
	public Funcionario() {
		super(list);
		list.add(this);
	}

	public Funcionario(String nome, int idade, Endereco endereco, double salario) {
		super(list);
		list.add(this);
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
