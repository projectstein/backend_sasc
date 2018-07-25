package com.projectstein.backend_sasc.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.projectstein.backend_sasc.domain.enums.Funcao;

@Entity
public class Pergunta {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String enunciado;
	private Funcao assunto;
	private Date dataInicial;
	private Date dataFinal;
	

	@ManyToOne
	@JoinColumn(name = "administrador_id")
	private Administrador administrador;


	public Pergunta() {
		super();
	}


	public Pergunta(Integer id, String enunciado, Funcao assunto, Date dataInicial, Administrador administrador) {
		super();
		this.id = id;
		this.enunciado = enunciado;
		this.assunto = assunto;
		this.dataInicial = dataInicial;
		this.administrador = administrador;
	}


	public Pergunta(Integer id, String enunciado, Funcao assunto, Date dataInicial, Date dataFinal,
			Administrador administrador) {
		super();
		this.id = id;
		this.enunciado = enunciado;
		this.assunto = assunto;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.administrador = administrador;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEnunciado() {
		return enunciado;
	}


	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}


	public Funcao getAssunto() {
		return assunto;
	}


	public void setAssunto(Funcao assunto) {
		this.assunto = assunto;
	}


	public Date getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}


	public Date getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}


	public Administrador getAdministrador() {
		return administrador;
	}


	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
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
		Pergunta other = (Pergunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
