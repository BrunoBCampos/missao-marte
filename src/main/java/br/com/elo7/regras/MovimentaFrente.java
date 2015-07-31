package br.com.elo7.regras;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Direcao;
import br.com.elo7.dominio.Posicao;

public class MovimentaFrente extends RegraMovimentacao {
	
	private static Map<Direcao, Function<Posicao, Posicao>> movimentacao;
	
	static {
		movimentacao = new HashMap<>();
		movimentacao.put(Direcao.NORTE, p -> Posicao.criar(p.getX(), p.getY() + 1, p.getDirecao()));
		movimentacao.put(Direcao.SUL, p -> Posicao.criar(p.getX(), p.getY() - 1, p.getDirecao()));
		movimentacao.put(Direcao.LESTE, p -> Posicao.criar(p.getX() + 1, p.getY(), p.getDirecao()));
		movimentacao.put(Direcao.OESTE, p -> Posicao.criar(p.getX() - 1, p.getY(), p.getDirecao()));
	}
	
	@Override
	public Posicao movimenta(Comando comando, Posicao posicao) {
		if (!Comando.ANDAR.equals(comando)) return getProximo().movimenta(comando, posicao);
		return movimentacao.get(posicao.getDirecao()).apply(posicao);
	}
	
}
