package br.pvv.senai.saude.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nutricionista implements IEntity, ICollection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String CRN;
	@Column
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
