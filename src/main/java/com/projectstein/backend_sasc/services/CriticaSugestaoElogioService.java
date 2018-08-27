package com.projectstein.backend_sasc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Aluno;
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
		obj.setMes();
		obj.setAno();
		return repo.save(obj);
	}

	public Page<CriticaSugestaoElogio> findPage(Integer page, Integer linesPerPage, String orderBy, String direction,
			Integer mes, Integer ano) {

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByMesAndAno(mes, ano, pageRequest);
	}

}
