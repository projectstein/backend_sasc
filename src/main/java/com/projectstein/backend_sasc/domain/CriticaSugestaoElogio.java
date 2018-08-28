package com.projectstein.backend_sasc.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CriticaSugestaoElogio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String comentario;
	private Date dataComentario;
	private Integer mes;
	private Integer ano;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public CriticaSugestaoElogio() {

	}

	public CriticaSugestaoElogio(Integer id, String comentario, Date dataComentario, Aluno aluno) {
		this.id = id;
		this.comentario = comentario;
		this.dataComentario = dataComentario;
		this.aluno = aluno;
		setMes();
		setAno();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Integer getMes() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(this.dataComentario);
		return calendario.get(Calendar.MONTH)+1;
		
	}

	public Integer getAno() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(this.dataComentario);
		return calendario.get(Calendar.YEAR);
	}

	public void setMes() {
		this.mes = getMes();
	}

	public void setAno() {
		this.ano = getAno();
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
		CriticaSugestaoElogio other = (CriticaSugestaoElogio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
