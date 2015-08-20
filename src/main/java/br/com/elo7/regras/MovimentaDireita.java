package br.com.elo7.regras;

import br.com.elo7.dominio.Bussola;
import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Direcao;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;

public class MovimentaDireita extends RegraMovimentacao {
	
	@Override
	public Posicao movimenta(Comando comando, Sonda sonda) {
		if (!Comando.DIREITA.equals(comando)) return getProximo().movimenta(comando, sonda);
		Direcao novaDirecao = Bussola.direitaDe(sonda.getPosicao().getDirecao());
		return Posicao.criar(sonda.getPosicao().getX(), sonda.getPosicao().getY(), novaDirecao);
	}

}
