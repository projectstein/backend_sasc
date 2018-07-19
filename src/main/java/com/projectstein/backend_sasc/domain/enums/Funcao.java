package com.projectstein.backend_sasc.domain.enums;

public enum Funcao {
	
	PROFESSOR(1, "Administrador"),
	RECEPCIONISTA(2, "Aluno");
	
	
	
	private int cod;
	private String descricao;
	private Funcao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static Funcao toEnum(Integer id) {
		if (id == null) {
			return null;
		}
			
		for (Funcao x : Funcao.values()) {
				if (id.equals(x.getCod())) {
					return x;
				}
			}
			
		throw new IllegalArgumentException("Id inválido " + id);
	}
	
}
