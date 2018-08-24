package com.projectstein.backend_sasc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectstein.backend_sasc.domain.enums.Perfil;

@Entity
public class Administrador {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String cpf;
	private String nome;
	private String email;
	private Perfil perfil;
	private String emailSistema;
	private String senhaEmail;

	@JsonIgnore
	@OneToMany(mappedBy = "administrador")
	private List<Aluno> alunos = new ArrayList<>();

	
	@JsonIgnore
	@OneToMany(mappedBy = "administrador")
	private List<Funcionario> funcionarios = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "administrador")
	private List<Pergunta> perguntas = new ArrayList<>();

	public Administrador() {
	}

	public Administrador(Integer id, String cpf, String nome, String email, 
							Perfil perfil, String emailSistema,String senhaEmail) {
		this.id= id;
		this.cpf=cpf;
		this.nome= nome;;
		this.email= email;
		this.emailSistema = emailSistema;
		this.senhaEmail = senhaEmail;
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

	public String getEmailSistema() {
		return emailSistema;
	}

	public void setEmailSistema(String emailSistema) {
		this.emailSistema = emailSistema;
	}

	public String getSenhaEmail() {
		return senhaEmail;
	}

	public void setSenhaEmail(String senhaEmail) {
		this.senhaEmail = senhaEmail;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
