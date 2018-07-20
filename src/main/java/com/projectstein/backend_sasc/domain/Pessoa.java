package com.projectstein.backend_sasc.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.projectstein.backend_sasc.domain.enums.TipoLogin;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String cpf;
	private String nome;
	private String email;
	private TipoLogin tipoLogin;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pessoa")
	private Login login;
	
	public Pessoa() {
		super();
	}



	public Pessoa(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin, Login login) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.tipoLogin = tipoLogin;
		this.login = login;
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

	public TipoLogin getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(TipoLogin tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	
	public Login getLogin() {
		return login;
	}



	public void setLogin(Login login) {
		this.login = login;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
