package br.com.elo7.regras;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Direcao;
import br.com.elo7.dominio.Planalto;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;

public class MovimentaFrente extends RegraMovimentacao {
	
	private static Map<Direcao, BiFunction<Posicao, Planalto, Posicao>> movimentacao;
	
	static {
		movimentacao = new HashMap<>();
		movimentacao.put(Direcao.NORTE, norte());
		movimentacao.put(Direcao.SUL, sul());
		movimentacao.put(Direcao.LESTE, leste());
		movimentacao.put(Direcao.OESTE, oeste());
	}
	
	@Override
	public Posicao movimenta(Comando comando, Sonda sonda) {
		if (!Comando.ANDAR.equals(comando)) return getProximo().movimenta(comando, sonda);
		return movimentacao.get(sonda.getPosicao().getDirecao()).apply(sonda.getPosicao(), sonda.getPlanalto());
	}
	
	
	private static BiFunction<Posicao, Planalto, Posicao> norte() {
		return (posicao, planalto) ->  posicao.getY() == planalto.getLimiteY() ? Posicao.criar(posicao.getX(), 1, posicao.getDirecao()) 
				: Posicao.criar(posicao.getX(), posicao.getY() + 1, posicao.getDirecao());
	}
	
	private static BiFunction<Posicao, Planalto, Posicao> sul() {
		return (posicao, planalto) ->  posicao.getY() == 1 ? Posicao.criar(posicao.getX(), planalto.getLimiteY(), posicao.getDirecao()) 
				: Posicao.criar(posicao.getX(), posicao.getY() - 1, posicao.getDirecao());
	}
	
	private static BiFunction<Posicao, Planalto, Posicao> leste() {
		return (posicao, planalto) ->  posicao.getX() == planalto.getLimiteX() ? Posicao.criar(1, posicao.getY(), posicao.getDirecao()) 
				: Posicao.criar(posicao.getX() + 1, posicao.getY(), posicao.getDirecao());
	}
	
	private static BiFunction<Posicao, Planalto, Posicao> oeste() {
		return (posicao, planalto) ->  posicao.getX() == 1 ? Posicao.criar(planalto.getLimiteX(), posicao.getY(), posicao.getDirecao()) 
				: Posicao.criar(posicao.getX() -1, posicao.getY(), posicao.getDirecao());
	}
	
}
