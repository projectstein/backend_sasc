package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.repository.CriticaSugestaoElogioRepository;
import com.projectstein.backend_sasc.services.exception.ObjectNotFoundException;

@Service
public class CriticaSugestaoElogioService {

	@Autowired
	private CriticaSugestaoElogioRepository repo;

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
		return repo.save(obj);
	}

}
