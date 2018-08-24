package com.projectstein.backend_sasc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectstein.backend_sasc.domain.Avaliacao;
import com.projectstein.backend_sasc.services.AvaliacaoService;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Avaliacao> find(@PathVariable Integer id) {
		Avaliacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}
