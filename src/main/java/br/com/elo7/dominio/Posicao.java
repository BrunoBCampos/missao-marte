package br.com.elo7.dominio;

import javax.persistence.Embeddable;

@Embeddable
public class Posicao {
	
	private int x;
	private int y;
	private Direcao direcao;
	
	protected Posicao() { }
	
	private Posicao(int x, int y, Direcao direcao) {
		this.x = x <= 0 ? 1 : x;
		this.y = y <= 0 ? 1 : y;
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
	
	public static Posicao criar(String value) {
		if(!value.matches("\\d{2}[NSLO]")) throw new IllegalArgumentException();
		String[] array = value.split("");
		return criar(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Direcao.get(array[2]));
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
