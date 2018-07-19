package com.projectstein.backend_sasc.domain;

import javax.persistence.Entity;

import com.projectstein.backend_sasc.domain.enums.TipoLogin;

@Entity
public class Administrador extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String emailSistema;
	private String senhaEmail;
	
	public Administrador() {
	}

	public Administrador(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin,String emailSistema, String senhaEmail) {
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

	
	
	

}
