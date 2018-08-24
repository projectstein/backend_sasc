package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Administrador;
import com.projectstein.backend_sasc.repository.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repo;

	public Administrador find(Integer id) {
		Administrador obj = (Administrador) repo.findOne(id);
		return obj;
	}

}
