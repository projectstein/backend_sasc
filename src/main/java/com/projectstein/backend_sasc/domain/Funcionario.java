package com.projectstein.backend_sasc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectstein.backend_sasc.domain.enums.Funcao;
import com.projectstein.backend_sasc.domain.enums.TipoLogin;

@Entity
public class Funcionario extends Pessoa {
	private static final long serialVersionUID = 1L;

	
	private Funcao funcao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "administrador_id")
	private Administrador administrador;
	
	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<Aluno> alunos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<Avaliacao> avaliacoes = new ArrayList<>();
	
	public Funcionario() {
		}

	public Funcionario(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin,Funcao funcao, Administrador administrador) {
		super(id, cpf, nome, email, tipoLogin);
		this.funcao = funcao;
		this.setAdministrador(administrador);
	}
	
	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	

}
