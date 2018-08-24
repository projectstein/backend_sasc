package com.projectstein.backend_sasc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectstein.backend_sasc.domain.Pergunta;
import com.projectstein.backend_sasc.services.PerguntaService;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaResource {

	@Autowired
	private PerguntaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pergunta> find(@PathVariable Integer id) {
		Pergunta obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}
