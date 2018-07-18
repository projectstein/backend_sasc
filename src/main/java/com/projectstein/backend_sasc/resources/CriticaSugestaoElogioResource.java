package com.projectstein.backend_sasc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.services.CriticaSugestaoElogioService;

@RestController
@RequestMapping(value = "/cses")
public class CriticaSugestaoElogioResource {
	

	
	@Autowired
	private CriticaSugestaoElogioService service;
	
		
		@RequestMapping(value= "/{id}" , method= RequestMethod.GET)
		public ResponseEntity<?> find(@PathVariable Integer id) {
			
				CriticaSugestaoElogio obj = service.buscar(id); 
			return ResponseEntity.ok().body(obj);
	
	
	
	}

	
	
	
	
}
