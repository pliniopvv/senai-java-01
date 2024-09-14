package br.pvv.senai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.pvv.senai.models.Comments;
import br.pvv.senai.repository.CommentsRepository;

@Service
public class CommentsService extends GenericCService<Comments, Comments> {

	@Autowired
	private CommentsRepository repository;

	@Override
	public Class<Comments> GetType() {
		return Comments.class;
	}

	@Override
	public JpaRepository<Comments, Integer> getCRepository() {
		return repository;
	}

	@Override
	public JpaRepository<Comments, Integer> getRepository() {
		return repository;
	}

}
