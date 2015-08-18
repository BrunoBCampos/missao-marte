package br.com.elo7;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo7.dominio.Direcao;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;
import br.com.elo7.parser.Parser;

public class MissaoMarteTest {
	
	@Test
	public void deveFuncionarDeAcordoComOExemplo() {
//		Planalto.build(5, 5);
		Sonda sonda = new Sonda(Posicao.criar(1, 2, Direcao.NORTE));
		sonda.movimenta(Parser.parse("LMLMLMLMM"));
		Assert.assertEquals(new Sonda(Posicao.criar(1, 3, Direcao.NORTE)), sonda);
	}
	
	@Test
	public void deveFuncionarDeAcordoComOOutroExemplo() {
//		Planalto.build(5, 5);
		Sonda sonda = new Sonda(Posicao.criar(3, 3, Direcao.LESTE));
		sonda.movimenta(Parser.parse("MMRMMRMRRM"));
		Assert.assertEquals(new Sonda(Posicao.criar(5, 1, Direcao.LESTE)), sonda);
	}


}
