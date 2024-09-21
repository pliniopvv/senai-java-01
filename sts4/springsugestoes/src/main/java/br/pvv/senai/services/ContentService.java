package br.pvv.senai.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.pvv.senai.models.Comments;
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

	public List<Content> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Content find(int id) {
		Content content = repository.findById(id).orElse(null);
		if (content == null) return null;
		var comments = content.getComments();
		comments.sort(Comparator.comparing(Comments::getDateEnvio));
		content.setComments(comments);
		return content;
	}

}
