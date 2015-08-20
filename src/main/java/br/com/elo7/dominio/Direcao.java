package br.com.elo7.dominio;

public enum Direcao {
	NORTE("N"), SUL("S"), LESTE("L"), OESTE("O");
	
	private String valor;
	
	private Direcao(String valor) {
		this.valor = valor;
	}
	
	public static Direcao fromValue(String valor) {
		for(Direcao direcao : values()) {
			if (direcao.getValor().equals(valor)) return direcao;
		}
		return null;
	}
	
	public String getValor() {
		return valor;
	}
}