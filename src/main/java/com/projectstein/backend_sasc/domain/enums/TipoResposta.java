package com.projectstein.backend_sasc.domain.enums;

public enum TipoResposta {
	
	OTIMO(1, "Otimo"),
	BOM(2, "Bom"),
	MEDIO(3, "Medio"),
	RUIM(4, "Ruim");
	
	
	
	private int cod;
	private String descricao;
	private TipoResposta(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoResposta toEnum(Integer id) {
		if (id == null) {
			return null;
		}
			
		for (TipoResposta x : TipoResposta.values()) {
				if (id.equals(x.getCod())) {
					return x;
				}
			}
			
		throw new IllegalArgumentException("Id inválido " + id);
	}
	
}
