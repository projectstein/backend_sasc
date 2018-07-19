package com.projectstein.backend_sasc.domain.enums;

public enum TipoLogin {
	
	ADMINISTRADOR(1, "Administrador"),
	ALUNO(2, "Aluno"),
	FUNCIONARIO(3, "Funcionário");
	
	
	
	private int cod;
	private String descricao;
	private TipoLogin(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoLogin toEnum(Integer id) {
		if (id == null) {
			return null;
		}
			
		for (TipoLogin x : TipoLogin.values()) {
				if (id.equals(x.getCod())) {
					return x;
				}
			}
			
		throw new IllegalArgumentException("Id inválido " + id);
	}
	
}
