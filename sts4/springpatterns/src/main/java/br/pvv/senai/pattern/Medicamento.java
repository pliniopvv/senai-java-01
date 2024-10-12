package br.pvv.senai.pattern;

public class Medicamento {

	private String nome;
	private int dosagem;
	private String unidadeDosagem;
	private String nomeLaboratorio;
	private String bula;

	public String getBula() {
		return bula;
	}

	public void setBula(String bula) {
		this.bula = bula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDosagem() {
		return dosagem;
	}

	public void setDosagem(int dosagem) {
		this.dosagem = dosagem;
	}

	public String getUnidadeDosagem() {
		return unidadeDosagem;
	}

	public void setUnidadeDosagem(String unidadeDosagem) {
		this.unidadeDosagem = unidadeDosagem;
	}

	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}

	public static Medicamento getDipirona() {
		Medicamento dipirona = new Medicamento();
		dipirona.setNome("Dipirona Sódica 500mg");
		dipirona.setDosagem(500);
		dipirona.setUnidadeDosagem("mg");
		dipirona.setNomeLaboratorio("EMS");
		String bulaDipirona = "Para que serve Dipirona Sódica?\n"
				+ "Como a Dipirona Sódica tem ação analgésica e antipirética, ela serve para aliviar dores e também reduzir a febre no paciente. Além disso, é importante ressaltar que o remédio é bastante indicado para dor com intensidade leve e moderada.\n"
				+ "Esse remédio também serve para tratar dores de dentes, além de cólicas menstruais e outras condições. Por ser acessível, ele pode ser encontrado nas mais diferentes redes de farmácias.\n";
		dipirona.setBula(bulaDipirona);

		return dipirona;
	}
}
