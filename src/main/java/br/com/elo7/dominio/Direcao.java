package br.com.elo7.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Direcao {
	NORTE("N"), SUL("S"), LESTE("L"), OESTE("O");
	
	private String valor;
	
	private Direcao(String valor) {
		this.valor = valor;
	}
	
	@JsonCreator
	public static Direcao fromValue(String valor) {
		for(Direcao direcao : values()) {
			if (direcao.getValor().equals(valor)) return direcao;
		}
		return null;
	}
	
	@JsonValue
	public String getValor() {
		return valor;
	}
	
}