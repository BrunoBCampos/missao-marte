package br.com.elo7.dominio;

import br.com.elo7.dominio.Bussola.Direcao;

public class Posicao {
	
	private final int x;
	private final int y;
	private final Direcao direcao;
	
	private Posicao(int x, int y, Direcao direcao) {
		this.x = x;
		this.y = y;
		this.direcao = direcao;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Direcao getDirecao() {
		return direcao;
	}

	public static Posicao criar(int x, int y, Direcao direcao) {
		return new Posicao(x, y, direcao);
	}

}
