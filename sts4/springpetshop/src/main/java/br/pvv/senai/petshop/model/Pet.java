package br.pvv.senai.petshop.model;

public class Pet extends PetShopResponseAdapter {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Tutor tutor;

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
