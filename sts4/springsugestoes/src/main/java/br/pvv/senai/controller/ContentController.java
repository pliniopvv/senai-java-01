package br.pvv.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.models.Content;
import br.pvv.senai.services.ContentService;
import br.pvv.senai.services.GenericService;

@Controller
@RestController
@RequestMapping("sugestoes")
public class ContentController extends GenericController<Content> {

	@Autowired
	private ContentService service; 
	
	@Override
	public GenericService<Content> getService() {
		return service;
	}
	
	@GetMapping()
	public ResponseEntity<List<Content>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
}
