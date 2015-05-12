package br.com.elo7.dominio;

import junit.framework.Assert;

import org.junit.Test;

import br.com.elo7.dominio.Bussola.Direcao;
import br.com.elo7.regras.MovimentaDireita;
import br.com.elo7.regras.MovimentaEsquerda;
import br.com.elo7.regras.RegraMovimentacao;

public class MovimentosTest {
	
	@Test
	public void deveVirarParaDireitaDoLesteEIrParaSul() {
		RegraMovimentacao regra = new MovimentaDireita();
		Posicao posicao = regra.movimenta(Comando.DIREITA, Posicao.criar(0, 0, Direcao.LESTE));
		Assert.assertEquals(Direcao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaDireitaDoNorteEIrParaLeste() {
		RegraMovimentacao regra = new MovimentaDireita();
		Posicao posicao = regra.movimenta(Comando.DIREITA, Posicao.criar(0, 0, Direcao.NORTE));
		Assert.assertEquals(Direcao.LESTE, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaEsquerdaDoOesteEIrParaSul() {
		RegraMovimentacao regra = new MovimentaEsquerda();
		Posicao posicao = regra.movimenta(Comando.ESQUERDA, Posicao.criar(0, 0, Direcao.OESTE));
		Assert.assertEquals(Direcao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaEsquerdaDoLesteEIrParaNorte() {
		RegraMovimentacao regra = new MovimentaEsquerda();
		Posicao posicao = regra.movimenta(Comando.ESQUERDA, Posicao.criar(0, 0, Direcao.LESTE));
		Assert.assertEquals(Direcao.NORTE, posicao.getDirecao());
	}

}
