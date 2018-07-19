package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.CriticaSugestaoElogio;
import com.projectstein.backend_sasc.repository.CriticaSugestaoElogioRepository;

@Service
	public class CriticaSugestaoElogioService {
		
		@Autowired
		private CriticaSugestaoElogioRepository repo;
		
		public CriticaSugestaoElogio buscar(Integer id) {
			CriticaSugestaoElogio obj = repo.findOne(id);
			return obj;
		}

}
