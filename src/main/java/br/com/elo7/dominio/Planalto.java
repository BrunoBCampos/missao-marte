package br.com.elo7.dominio;

public class Planalto {
	
	private static int limiteX;
	private static int limiteY;

	public static int getLimiteX() {
		return limiteX;
	}

	public static int getLimiteY() {
		return limiteY;
	}
	
	private Planalto() { }
	
	public static void build(int x, int y) {
		limiteX = x;
		limiteY = y;
	}

}
