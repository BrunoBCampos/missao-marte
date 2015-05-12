package br.com.elo7.dominio;

public class Posicao {
	
	private final int x;
	private final int y;
	private final String orientacao;
	
	private Posicao(int x, int y, String orientacao) {
		this.x = x;
		this.y = y;
		this.orientacao = orientacao;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getOrientacao() {
		return orientacao;
	}
	
	public static Posicao criar(int x, int y, String orientacao) {
		return new Posicao(x, y, orientacao);
	}

}
