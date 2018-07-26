package com.projectstein.backend_sasc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.projectstein.backend_sasc.domain.enums.TipoResposta;

@Entity
public class Resposta implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private RespostaPK id = new RespostaPK();
	
	private TipoResposta tipoResposta;

	
	public Resposta() {
		super();
	}

	public Resposta(TipoResposta tipoResposta, Avaliacao avaliacao, Pergunta pergunta) {
		super();
		id.setAvaliacao(avaliacao);
		id.setPergunta(pergunta);
		this.tipoResposta = tipoResposta;
	}

	public RespostaPK getId() {
		return id;
	}

	public void setId(RespostaPK id) {
		this.id = id;
	}

	public TipoResposta getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(TipoResposta tipoResposta) {
		this.tipoResposta = tipoResposta;
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
		Resposta other = (Resposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
