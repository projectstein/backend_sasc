package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Pergunta;
import com.projectstein.backend_sasc.repository.PerguntaRepository;

@Service
	public class PerguntaService {
		
		@Autowired
		private PerguntaRepository repo;
		
		public Pergunta find(Integer id) {
			Pergunta obj = repo.findOne(id);
			return obj;
		}

}
