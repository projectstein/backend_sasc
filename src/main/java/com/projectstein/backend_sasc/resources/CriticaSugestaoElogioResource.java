package com.projectstein.backend_sasc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.services.CriticaSugestaoElogioService;

@RestController
@RequestMapping(value = "/cses")
public class CriticaSugestaoElogioResource {

	@Autowired
	private CriticaSugestaoElogioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CriticaSugestaoElogio> find(@PathVariable Integer id) {
		CriticaSugestaoElogio obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CriticaSugestaoElogio obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
