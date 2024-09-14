package br.pvv.senai.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class MedicoDAO {

	@Autowired
	EntityManager em;
	
	public void Test() {
		em.getCriteriaBuilder();
		System.out.println("ALÔ");
	}
	
}
