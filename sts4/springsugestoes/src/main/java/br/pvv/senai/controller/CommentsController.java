package br.pvv.senai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pvv.senai.models.Comments;
import br.pvv.senai.services.CommentsService;
import br.pvv.senai.services.GenericCService;
import br.pvv.senai.services.GenericService;

@Controller
@RestController
@RequestMapping("comments")
public class CommentsController extends GenericCController<Comments, Comments> {

	@Autowired
	private CommentsService service;
	
	@Override
	public GenericCService<Comments, Comments> getCService() {
		return service;
	}

	@Override
	public GenericService<Comments> getService() {
		return service;
	}

}
