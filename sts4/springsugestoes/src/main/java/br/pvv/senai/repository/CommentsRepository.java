package br.pvv.senai.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.pvv.senai.models.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
	
}
