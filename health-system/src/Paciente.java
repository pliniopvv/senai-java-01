import java.util.ArrayList;
import java.util.List;

//[M2S02] Ex. 01 - Sistema de Saúde - Paciente
public class Paciente extends GenericList<Paciente> implements IGenericListEntity {
	private String nome;
	private int idade;
	private double peso;
	private double altura;
	private double pressao_arterial;
	private double frequencia_cardiaca;
	private String dieta_alimentar;
	private List<String> atividadesFisicas;

	// [M2S02] Ex. 02 - Sistema de Saúde - Lista de dados
	// #######################################################
	// #
	private static List<Paciente> list = new ArrayList<Paciente>();

	Paciente() {
		super(list);
		list.add(this);
	}
	// #
	// #######################################################

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

}
