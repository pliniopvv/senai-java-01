package br.pvv.senai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.pvv.senai.models.Content;
import br.pvv.senai.repository.ContentRepository;

@Service
public class ContentService extends GenericService<Content> {

	@Autowired
	private ContentRepository repository;
	
	@Override
	public JpaRepository<Content, Integer> getRepository() {
		return repository;
	}

}
