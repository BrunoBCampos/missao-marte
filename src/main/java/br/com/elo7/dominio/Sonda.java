package br.com.elo7.dominio;

import br.com.elo7.regras.MovimentaDireita;
import br.com.elo7.regras.MovimentaEsquerda;
import br.com.elo7.regras.MovimentaFrente;
import br.com.elo7.regras.RegraMovimentacao;

public class Sonda {
	
	private Posicao posicao;

	public Sonda(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public void movimenta(Comando comando) {
		this.posicao = getRegra().movimenta(comando, posicao);
	}
	
	private RegraMovimentacao getRegra() {
		RegraMovimentacao regras = new MovimentaFrente();
		regras.incluiProximaRegra(new MovimentaEsquerda());
		regras.incluiProximaRegra(new MovimentaDireita());
		return regras;
	}

	public String status() {
		return String.format("Posicao atual: x: %d, y: %d, direcao: %s", posicao.getX(), posicao.getY(), posicao.getDirecao());
	}
	
	@Override
	public boolean equals(Object o) {
		return posicao.equals(((Sonda)o).getPosicao());
	}

	public Posicao getPosicao() {
		return posicao;
	}
	
}
