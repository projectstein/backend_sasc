package com.projectstein.backend_sasc.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectstein.backend_sasc.domain.enums.Perfil;

@Entity
public class Aluno {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String cpf;
	private String nome;
	private String email;
	private Perfil perfil;
	
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
	@OneToMany(mappedBy = "aluno",cascade=CascadeType.ALL)
	private List<CriticaSugestaoElogio> criticaSugestaoElogio = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Avaliacao> avaliacoes = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(Integer id, String cpf, String nome, String email, Perfil perfil, Administrador administrador) {
		this.id= id;
		this.cpf=cpf;
		this.nome= nome;;
		this.email= email;
		this.administrador= administrador;
		this.perfil= perfil;
	
	
	}

	public Aluno(Integer id, String cpf, String nome, String email, Perfil perfil, Funcionario funcionario) {
		this.id= id;
		this.cpf=cpf;
		this.nome= nome;;
		this.email= email;
		this.funcionario= funcionario;
		this.perfil=perfil;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
