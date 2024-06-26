package entidades;

import java.util.ArrayList;
import java.util.List;

import repositorio.GenericList;
import repositorio.IGenericListEntity;
import repositorio.Mutable;

//[M2S02] Ex. 01 - Sistema de Sa�de - Paciente
public class Paciente extends GenericList<Paciente> implements IGenericListEntity {
	private String nome;
	private int idade;
	@Mutable
	private double peso;
	@Mutable
	private double altura;
	@Mutable
	private double pressao_arterial;
	@Mutable
	private double frequencia_cardiaca;
	@Mutable
	private String dieta_alimentar;
	private List<String> atividadesFisicas = new ArrayList();

	// [M2S02] Ex. 02 - Sistema de Sa�de - Lista de dados
	// #######################################################
	// #
	private static List<Paciente> list = new ArrayList<Paciente>();

	public Paciente() {
		super(list);
		list.add(this);
	}
	
//	[M2S03] Ex. 01 - Sistema de Sa�de Parte 2 - Pr� Requisitos
	public Paciente(String nome, int idade, double peso, double altura, double pressao_arterial,
			double frequencia_cardiaca, String dieta_alimentar, List<String> atividadesFisicas) {
		super(list);
		list.add(this);
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
		this.pressao_arterial = pressao_arterial;
		this.frequencia_cardiaca = frequencia_cardiaca;
		this.dieta_alimentar = dieta_alimentar;
		this.atividadesFisicas = atividadesFisicas;
	}

	// #
	// #######################################################

	public static Paciente[] getList() {
		Paciente[] array = list.toArray(new Paciente[list.size()]);
		return array;
	}

	public static void remove(int id) {
		list.remove(id);
	}

	public static void addPaciente(Paciente model) {
		list.add(model);
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPressao_arterial() {
		return pressao_arterial;
	}

	public void setPressao_arterial(double pressao_arterial) {
		this.pressao_arterial = pressao_arterial;
	}

	public double getFrequencia_cardiaca() {
		return frequencia_cardiaca;
	}

	public void setFrequencia_cardiaca(double frequencia_cardiaca) {
		this.frequencia_cardiaca = frequencia_cardiaca;
	}

	public String getDieta_alimentar() {
		return dieta_alimentar;
	}

	public void setDieta_alimentar(String dieta_alimentar) {
		this.dieta_alimentar = dieta_alimentar;
	}

	public List<String> getAtividadesFisicas() {
		return atividadesFisicas;
	}

	public void setAtividadesFisicas(List<String> atividadesFisicas) {
		this.atividadesFisicas = atividadesFisicas;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	// [M2S02] Ex. 03 - Sistema de Sa�de - M�todos de Paciente
	// #######################################################
	// #
	public double IMC() {
		double imc = this.peso / Math.pow(this.altura, 2);
		return imc;
	}

	public void monitorar() {
		System.out.println("Paciente \t\t\t" + this.nome);
		System.out.println("Idade \t\t\t" + this.idade);
		System.out.println("Pressao Arterial \t\t\t" + this.pressao_arterial);
		System.out.println("Frequencia Cardiaca \t\t\t" + this.frequencia_cardiaca);
		System.out.println("Dieta Alimentar \t\t\t" + this.dieta_alimentar);

		System.out.println("Peso \t\t\t" + this.peso);
		System.out.println("Altura \t\t\t" + this.altura);
		System.out.println("IMC \t\t\t" + this.IMC());

		System.out.println("Atividades \t\t\t");
		for (String atividade : this.atividadesFisicas)
			System.out.println("\t \t\t\t" + atividade);
	}

	public void registrarAtividade(String atividade) {
		this.atividadesFisicas.add(atividade);
	}
	// #
	// #######################################################
}
