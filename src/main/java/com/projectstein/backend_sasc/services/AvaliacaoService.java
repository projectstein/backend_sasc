package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Avaliacao;
import com.projectstein.backend_sasc.repository.AvaliacaoRepository;

@Service
	public class AvaliacaoService {
		
		@Autowired
		private AvaliacaoRepository repo;
		
		public Avaliacao find(Integer id) {
			Avaliacao obj = repo.findOne(id);
			return obj;
		}

}
