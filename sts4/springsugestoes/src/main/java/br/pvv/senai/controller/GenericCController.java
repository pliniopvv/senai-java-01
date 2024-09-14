package br.pvv.senai.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.pvv.senai.models.ICollection;
import br.pvv.senai.models.IEntity;
import br.pvv.senai.services.GenericCService;

@Controller
public abstract class GenericCController<C extends ICollection, T extends IEntity> extends GenericController<T> {

	public abstract GenericCService<C, T> getCService();

	private final Log logger = LogFactory.getLog(getClass());

	@GetMapping("{id}/list")
	public ResponseEntity<List<C>> list(int id) throws Exception {
		logger.info(id + "/list -> Rota acessada");
		return ResponseEntity.ok(getCService().findByParent(id));
	}

}
