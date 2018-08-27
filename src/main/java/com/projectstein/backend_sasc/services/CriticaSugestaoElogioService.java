package com.projectstein.backend_sasc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.repository.AlunoRepository;
import com.projectstein.backend_sasc.repository.CriticaSugestaoElogioRepository;
import com.projectstein.backend_sasc.services.exception.ObjectNotFoundException;

@Service
public class CriticaSugestaoElogioService {

	@Autowired
	private CriticaSugestaoElogioRepository repo;
	
	@Autowired
	private AlunoRepository alunoRepository;

	public CriticaSugestaoElogio find(Integer id) {
		CriticaSugestaoElogio obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + CriticaSugestaoElogio.class.getName());
		}
		return obj;
	}

	public CriticaSugestaoElogio insert(CriticaSugestaoElogio obj) {
		obj.setId(null);
		obj.setAluno(alunoRepository.findOne(obj.getAluno().getId()));
		obj.setDataComentario(new Date(System.currentTimeMillis()));
		return repo.save(obj);
	}

}
