package br.com.elo7.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.elo7.regras.MovimentaDireita;
import br.com.elo7.regras.MovimentaEsquerda;
import br.com.elo7.regras.MovimentaFrente;
import br.com.elo7.regras.RegraMovimentacao;

public class MovimentosTest {
	
	private static RegraMovimentacao direita;
	private static RegraMovimentacao esquerda;
	private static RegraMovimentacao mover;
	private static Planalto planalto;

	@BeforeClass
	public static void setUp() {
		direita = new MovimentaDireita();
		esquerda = new MovimentaEsquerda();
		mover = new MovimentaFrente();
		planalto = new Planalto(5, 5);
	}
	
	@Test
	public void devePercorrerCadeiaEEncontrarSolucao() {
		RegraMovimentacao direita = new MovimentaDireita();
		direita.incluiProximaRegra(new MovimentaEsquerda());
		direita.incluiProximaRegra(new MovimentaFrente());
		Sonda sonda = new Sonda(Posicao.criar(2, 3, Direcao.NORTE), planalto);
		Posicao posicao = direita.movimenta(Comando.ANDAR, sonda);
		assertEquals(Posicao.criar(2, 4, Direcao.NORTE), posicao);
	}
	
	@Test
	public void deveVirarParaDireitaDoLesteEIrParaSul() {
		Sonda sonda = new Sonda(Posicao.criar(0, 0, Direcao.LESTE), planalto);
		Posicao posicao = direita.movimenta(Comando.DIREITA, sonda);
		assertEquals(Direcao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaDireitaDoNorteEIrParaLeste() {
		Sonda sonda = new Sonda(Posicao.criar(0, 0, Direcao.NORTE), planalto);
		Posicao posicao = direita.movimenta(Comando.DIREITA, sonda);
		assertEquals(Direcao.LESTE, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaEsquerdaDoOesteEIrParaSul() {
		Sonda sonda = new Sonda(Posicao.criar(0, 0, Direcao.OESTE), planalto);
		Posicao posicao = esquerda.movimenta(Comando.ESQUERDA, sonda);
		assertEquals(Direcao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void deveVirarParaEsquerdaDoLesteEIrParaNorte() {
		Sonda sonda = new Sonda(Posicao.criar(0, 0, Direcao.LESTE), planalto);
		Posicao posicao = esquerda.movimenta(Comando.ESQUERDA, sonda);
		assertEquals(Direcao.NORTE, posicao.getDirecao());
	}
	
	@Test
	public void deveMoverParaFrenteAoLeste() {
		Sonda sonda = new Sonda(Posicao.criar(1, 1, Direcao.LESTE), planalto);
		Posicao posicao = mover.movimenta(Comando.ANDAR, sonda);
		assertEquals(Posicao.criar(2, 1, Direcao.LESTE), posicao);
	}
	
	@Test
	public void deveMoverParaFrenteAoOeste() {
		Sonda sonda = new Sonda(Posicao.criar(3, 3, Direcao.OESTE), planalto);
		Posicao posicao = mover.movimenta(Comando.ANDAR, sonda);
		assertEquals(Posicao.criar(2, 3, Direcao.OESTE), posicao);
	}
	
	@Test
	public void deveMoverParaFrenteAoNorte() {
		Sonda sonda = new Sonda(Posicao.criar(4, 2, Direcao.NORTE), planalto);
		Posicao posicao = mover.movimenta(Comando.ANDAR, sonda);
		assertEquals(Posicao.criar(4, 3, Direcao.NORTE), posicao);
	}
	
	@Test
	public void deveMoverParaFrenteAoSul() {
		Sonda sonda = new Sonda(Posicao.criar(5, 2, Direcao.SUL), planalto);
		Posicao posicao = mover.movimenta(Comando.ANDAR, sonda);
		assertEquals(Posicao.criar(5, 1, Direcao.SUL), posicao);
	}

}
