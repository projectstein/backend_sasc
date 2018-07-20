package com.projectstein.backend_sasc.domain;

import javax.persistence.Entity;

import com.projectstein.backend_sasc.domain.enums.Funcao;
import com.projectstein.backend_sasc.domain.enums.TipoLogin;

@Entity
public class Funcionario extends Pessoa {
	private static final long serialVersionUID = 1L;

	
	private Funcao funcao;

	public Funcionario() {
		}

	public Funcionario(Integer id, String cpf, String nome, String email, TipoLogin tipoLogin, Login login,Funcao funcao) {
		super(id, cpf, nome, email, tipoLogin, login);
		this.funcao = funcao;
	}
	
	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
}
