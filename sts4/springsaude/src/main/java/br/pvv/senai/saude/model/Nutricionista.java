package br.pvv.senai.saude.model;

public class Nutricionista implements IEntity, ICollection {
	
	private long id;
	private String CRN;
	private String especialidade;
	
	public String getCRN() {
		return CRN;
	}

	public void setCRN(String cRN) {
		CRN = cRN;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
