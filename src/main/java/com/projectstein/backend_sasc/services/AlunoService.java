package com.projectstein.backend_sasc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projectstein.backend_sasc.domain.Aluno;
import com.projectstein.backend_sasc.dto.AlunoDTO;
import com.projectstein.backend_sasc.dto.AlunoNewDTO;
import com.projectstein.backend_sasc.repository.AdministradorRepository;
import com.projectstein.backend_sasc.repository.AlunoRepository;
import com.projectstein.backend_sasc.services.exception.DataIntegrityException;
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

	

	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Aluno> findAll() {
		return repo.findAll();
	}


	public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Aluno fromDTO(AlunoDTO objDto) {
		return new Aluno(objDto.getId(), null, objDto.getNome(), objDto.getEmail(), adminRepo.findOne(1));
	}

	public Aluno fromDTO(AlunoNewDTO objDto) {
		Aluno aln = new Aluno(null, objDto.getCpf(), objDto.getNome(), objDto.getEmail(), adminRepo.findOne(1));
		aln.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			aln.getTelefones().add(objDto.getTelefone2());
		}
		return aln;
	}
	
	private void updateData(Aluno newObj,Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
