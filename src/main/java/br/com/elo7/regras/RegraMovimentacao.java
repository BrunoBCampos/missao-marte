package br.com.elo7.regras;

import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;


public abstract class RegraMovimentacao {
	
	private RegraMovimentacao proximo;
	
	public void incluiProximaRegra(RegraMovimentacao regra) {
		if (proximo == null) {
			proximo = regra;
		} else {
			proximo.incluiProximaRegra(regra);
		}
	}
	
	public abstract Posicao movimenta(Comando comando, Sonda sonda);

	public RegraMovimentacao getProximo() {
		return proximo;
	}

}
