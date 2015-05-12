package br.com.elo7.dominio;

public enum Comando {
	
	DIREITA("R"),
	ESQUERDA("L"),
	ANDAR("M");
	
	private String valor;
	
	private Comando(String valor) {
		this.valor = valor;
	}
	
	public static Comando get(String valor) {
		for(Comando entrada : values()) {
			if (entrada.getValor().equals(valor)) return entrada;
		}
		return null;
	}
	
	public String getValor() {
		return valor;
	}

}
