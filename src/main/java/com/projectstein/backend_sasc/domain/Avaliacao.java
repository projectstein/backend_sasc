package com.projectstein.backend_sasc.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.projectstein.backend_sasc.domain.enums.Funcao;

@Entity
public class Avaliacao {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataAvaliacao;
	private Funcao tipoAvaliacao;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@OneToMany(mappedBy = "id.avaliacao")
	private Set<Resposta> resposta = new HashSet<>();

	public Avaliacao() {
		super();
	}

	public Avaliacao(Integer id, Date dataAvaliacao, Funcao tipoAvaliacao, Funcionario funcionario, Aluno aluno) {
		super();
		this.id = id;
		this.dataAvaliacao = dataAvaliacao;
		this.tipoAvaliacao = tipoAvaliacao;
		this.funcionario = funcionario;
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Funcao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(Funcao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
