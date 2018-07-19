package com.projectstein.backend_sasc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.projectstein.backend_sasc.domain.enums.TipoLogin;

@Entity
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	
	@ElementCollection
	@CollectionTable(name ="TELEFONE")
	private Set<String> telefones = new HashSet<>();


	public Aluno() {
		
	}

	
	public Aluno(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin) {
		super(id, cpf, nome, email, tipoLogin);
		
	}


	public Set<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}


	
	
	
	
	
	
	

}
