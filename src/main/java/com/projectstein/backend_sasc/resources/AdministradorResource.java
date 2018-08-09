package com.projectstein.backend_sasc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectstein.backend_sasc.domain.Administrador;
import com.projectstein.backend_sasc.services.AdministradorService;

@RestController
@RequestMapping(value = "/admin")
public class AdministradorResource {

	@Autowired
	private AdministradorService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Administrador> find(@PathVariable Integer id) {

		Administrador obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}
