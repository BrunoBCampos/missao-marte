package br.com.elo7.regras;

import br.com.elo7.dominio.Bussola;
import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Direcao;
import br.com.elo7.dominio.Posicao;

public class MovimentaEsquerda extends RegraMovimentacao {

	@Override
	public Posicao movimenta(Comando comando, Posicao posicao) {
		if (!Comando.ESQUERDA.equals(comando)) return getProximo().movimenta(comando, posicao);
		Direcao novaDirecao = Bussola.esquerdaDe(posicao.getDirecao());
		return Posicao.criar(posicao.getX(), posicao.getY(), novaDirecao);
	}

}
