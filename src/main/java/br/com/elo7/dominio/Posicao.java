package br.com.elo7.dominio;

import br.com.elo7.dominio.Bussola.Direcao;

public class Posicao {
	
	private final int x;
	private final int y;
	private final Direcao direcao;
	
	private Posicao(int x, int y, Direcao direcao) {
		this.x = x > Planalto.getLimiteX() ? 1 : x;
		this.y = y > Planalto.getLimiteY() ? 1 : y;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direcao == null) ? 0 : direcao.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Posicao outra = (Posicao) o;
		return x == outra.getX() && y == outra.getY() && direcao.equals(outra.getDirecao());
	}
	
}
