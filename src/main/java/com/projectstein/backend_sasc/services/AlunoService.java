package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Aluno;
import com.projectstein.backend_sasc.repository.PessoaRepository;

@Service
public class AlunoService {

	@Autowired
	private PessoaRepository repo;

	public Aluno find(Integer id) {
		Aluno obj = (Aluno) repo.findOne(id);
		return obj;
	}

}