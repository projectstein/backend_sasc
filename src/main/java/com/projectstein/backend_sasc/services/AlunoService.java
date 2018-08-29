package com.projectstein.backend_sasc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Aluno;
import com.projectstein.backend_sasc.dto.AlunoNewDTO;
import com.projectstein.backend_sasc.repository.AdministradorRepository;
import com.projectstein.backend_sasc.repository.AlunoRepository;
import com.projectstein.backend_sasc.services.exception.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;

	@Autowired
	private AdministradorRepository adminRepo;

	public Aluno find(Integer id) {
		Aluno obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName());
		}

		return obj;
	}

	public Aluno insert(Aluno obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;

	}

	public Aluno fromDTO(AlunoNewDTO objDto) {
		Aluno aln = new Aluno(null, objDto.getCpf(), objDto.getNome(), objDto.getEmail(), adminRepo.findOne(1));
		aln.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			aln.getTelefones().add(objDto.getTelefone2());
		}
		return aln;
	}
}
