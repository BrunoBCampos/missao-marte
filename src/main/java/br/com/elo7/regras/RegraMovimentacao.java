package br.com.elo7.regras;

import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Posicao;


public abstract class RegraMovimentacao {
	
	private RegraMovimentacao proximo;
	
	public void incluiProximaRegra(RegraMovimentacao regra) {
		if (proximo == null) {
			proximo = regra;
		} else {
			proximo.incluiProximaRegra(regra);
		}
	}
	
	public abstract Posicao movimenta(Comando comando, Posicao posicao);

	public RegraMovimentacao getProximo() {
		return proximo;
	}

}
