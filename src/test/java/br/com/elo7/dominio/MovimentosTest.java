package br.com.elo7.dominio;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.elo7.dominio.Bussola.Direcao;
import br.com.elo7.regras.MovimentaDireita;
import br.com.elo7.regras.MovimentaEsquerda;
import br.com.elo7.regras.MovimentaFrente;
import br.com.elo7.regras.RegraMovimentacao;

public class MovimentosTest {
	
	private static RegraMovimentacao direita;
	private static RegraMovimentacao esquerda;
	private static RegraMovimentacao mover;

	@BeforeClass
	public static void setUp() {
		direita = new MovimentaDireita();
		esquerda = new MovimentaEsquerda();
		mover = new MovimentaFrente();
	}
	
	@Test
	public void devePercorrerCadeiaEEncontrarSolucao() {
		RegraMovimentacao direita = new MovimentaDireita();
		direita.incluiProximaRegra(new MovimentaEsquerda());
		direita.incluiProximaRegra(new MovimentaFrente());
		Posicao posicao = direita.movimenta(Comando.ANDAR, Posicao.criar(2, 3, Direcao.NORTE));
		Assert.assertEquals(Posicao.criar(2, 4, Direcao.NORTE), posicao);
	}
	
	@Test
	public void deveVirarParaDireitaDoLesteEIrParaSul() {
		Posicao posicao = direita.movimenta(Comando.DIREITA, Posicao.criar(0, 0, Direcao.LESTE));
		Assert.assertEquals(Direcao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaDireitaDoNorteEIrParaLeste() {
		Posicao posicao = direita.movimenta(Comando.DIREITA, Posicao.criar(0, 0, Direcao.NORTE));
		Assert.assertEquals(Direcao.LESTE, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaEsquerdaDoOesteEIrParaSul() {
		Posicao posicao = esquerda.movimenta(Comando.ESQUERDA, Posicao.criar(0, 0, Direcao.OESTE));
		Assert.assertEquals(Direcao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaEsquerdaDoLesteEIrParaNorte() {
		Posicao posicao = esquerda.movimenta(Comando.ESQUERDA, Posicao.criar(0, 0, Direcao.LESTE));
		Assert.assertEquals(Direcao.NORTE, posicao.getDirecao());
	}
	
	@Test
	public void deveMoverParaFrenteAoLeste() {
		Posicao posicao = mover.movimenta(Comando.ANDAR, Posicao.criar(1, 1, Direcao.LESTE));
		Assert.assertEquals(Posicao.criar(2, 1, Direcao.LESTE), posicao);
	}
	
	@Test
	public void deveMoverParaFrenteAoOeste() {
		Posicao posicao = mover.movimenta(Comando.ANDAR, Posicao.criar(3, 3, Direcao.OESTE));
		Assert.assertEquals(Posicao.criar(2, 3, Direcao.OESTE), posicao);
	}
	
	@Test
	public void deveMoverParaFrenteAoNorte() {
		RegraMovimentacao regra = new MovimentaFrente();
		Posicao posicao = regra.movimenta(Comando.ANDAR, Posicao.criar(4, 2, Direcao.NORTE));
		Assert.assertEquals(Posicao.criar(4, 3, Direcao.NORTE), posicao);
	}
	
	@Test
	public void deveMoverParaFrenteAoSul() {
		RegraMovimentacao regra = new MovimentaFrente();
		Posicao posicao = regra.movimenta(Comando.ANDAR, Posicao.criar(5, 2, Direcao.SUL));
		Assert.assertEquals(Posicao.criar(5, 1, Direcao.SUL), posicao);
	}

}
