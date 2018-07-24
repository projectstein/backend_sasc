package com.projectstein.backend_sasc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.projectstein.backend_sasc.domain.enums.TipoLogin;

@Entity
public class Administrador extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String emailSistema;
	private String senhaEmail;
	
	@OneToMany(mappedBy = "administrador")
	private List<Aluno>alunos = new ArrayList<>();
	
	@OneToMany(mappedBy = "administrador")
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public Administrador() {
	}

	public Administrador(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin ,String emailSistema, String senhaEmail) {
		super(id, cpf, nome, email, tipoLogin);
		
		this.emailSistema = emailSistema;
		this.senhaEmail = senhaEmail;
		
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

	
	
	

}
