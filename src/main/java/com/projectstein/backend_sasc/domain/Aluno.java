package com.projectstein.backend_sasc.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectstein.backend_sasc.domain.enums.TipoLogin;

@Entity
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1L;

	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "administrador_id")
	private Administrador administrador;

	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<CriticaSugestaoElogio> criticaSugestaoElogio = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Avaliacao> avaliacoes = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin, Administrador administrador) {
		super(id, cpf, nome, email, tipoLogin);
		this.administrador = administrador;
	}

	public Aluno(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin, Funcionario funcionario) {
		super(id, cpf, nome, email, tipoLogin);
		this.funcionario = funcionario;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public List<CriticaSugestaoElogio> getCriticaSugestaoElogio() {
		return criticaSugestaoElogio;
	}

	public void setCriticaSugestaoElogio(List<CriticaSugestaoElogio> criticaSugestaoElogio) {
		this.criticaSugestaoElogio = criticaSugestaoElogio;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
