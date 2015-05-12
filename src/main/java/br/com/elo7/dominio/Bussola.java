package br.com.elo7.dominio;

import java.util.HashMap;
import java.util.Map;

public class Bussola {
	
	private static Map<Direcao, Vizinho> navegacao;
	
	static {
		navegacao = new HashMap<>();
		navegacao.put(Direcao.NORTE, new Vizinho(Direcao.LESTE, Direcao.OESTE));
		navegacao.put(Direcao.SUL, new Vizinho(Direcao.OESTE, Direcao.LESTE));
		navegacao.put(Direcao.LESTE, new Vizinho(Direcao.SUL, Direcao.NORTE));
		navegacao.put(Direcao.OESTE, new Vizinho(Direcao.NORTE, Direcao.SUL));
	}
	
	public static Direcao direitaDe(Direcao direcao) {
		return navegacao.get(direcao).getDireita();
	}
	
	public static Direcao esquerdaDe(Direcao direcao) {
		return navegacao.get(direcao).getEsquerda();
	}
	
	public enum Direcao {
		NORTE, SUL, LESTE, OESTE;
	}
	
	private static class Vizinho {
		
		private Direcao direita;
		private Direcao esquerda;
		
		public Vizinho(Direcao direita, Direcao esquerda) {
			this.direita = direita;
			this.esquerda = esquerda;
		}

		public Direcao getDireita() {
			return direita;
		}
		
		public Direcao getEsquerda() {
			return esquerda;
		}
	}
}
