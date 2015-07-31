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
	
	public static void build(String value) {
		if (!value.matches("\\d{2}")) throw new IllegalArgumentException();
		String[] array = value.split("");
		build(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
	}

}
