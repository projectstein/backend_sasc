package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Funcionario;
import com.projectstein.backend_sasc.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;

	public Funcionario find(Integer id) {
		Funcionario obj = (Funcionario) repo.findOne(id);
		return obj;
	}

}
