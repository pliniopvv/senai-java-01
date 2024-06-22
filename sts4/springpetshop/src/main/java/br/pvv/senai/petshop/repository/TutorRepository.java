package br.pvv.senai.petshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pvv.senai.petshop.model.Tutor;

@Repository
public class TutorRepository {
	public List<Tutor> list = new ArrayList<Tutor>();
}
