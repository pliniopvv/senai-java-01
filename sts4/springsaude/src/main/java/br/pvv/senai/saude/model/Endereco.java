package br.pvv.senai.saude.model;

public class Endereco implements IEntity, ICollection {

	private long id;
	private String logradouro;
	private String estado;
	private String cidade;
	private String numero;
	private String CEP;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public long getIdGroup() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getId() {
		return id;
	}

}
