package br.pvv.senai.pattern;

public class MedicamentoBuilder {
	private String nome;
	private int dosagem;
	private String unidadeDosagem;
	private String nomeLaboratorio;
	private String bula;

	public MedicamentoBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}

	public MedicamentoBuilder withDosagem(int dosagem) {
		this.dosagem = dosagem;
		return this;
	}

	public MedicamentoBuilder withUnidadeDosagem(String unidadeDosagem) {
		this.unidadeDosagem = unidadeDosagem;
		return this;
	}

	public MedicamentoBuilder withNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		return this;
	}

	public MedicamentoBuilder withBula(String bula) {
		this.bula = bula;
		return this;
	}

	public Medicamento build() {
		Medicamento medicamento = new Medicamento();
		medicamento.setNome(nome);
		medicamento.setDosagem(dosagem);
		medicamento.setUnidadeDosagem(unidadeDosagem);
		medicamento.setNomeLaboratorio(nomeLaboratorio);
		medicamento.setBula(bula);
		return medicamento;
	}

}
