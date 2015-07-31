package br.com.elo7.dominio;

import junit.framework.Assert;

import org.junit.Test;

public class BussolaTest {
	
	@Test
	public void deveRetornarDirecaoCorretaParaDireita() {
		Assert.assertEquals(Direcao.LESTE, Bussola.direitaDe(Direcao.NORTE));
		Assert.assertEquals(Direcao.OESTE, Bussola.direitaDe(Direcao.SUL));
		Assert.assertEquals(Direcao.SUL, Bussola.direitaDe(Direcao.LESTE));
		Assert.assertEquals(Direcao.NORTE, Bussola.direitaDe(Direcao.OESTE));
	}
	
	@Test
	public void deveRetornarDirecaoCorretaParaEsquerda() {
		Assert.assertEquals(Direcao.OESTE, Bussola.esquerdaDe(Direcao.NORTE));
		Assert.assertEquals(Direcao.LESTE, Bussola.esquerdaDe(Direcao.SUL));
		Assert.assertEquals(Direcao.NORTE, Bussola.esquerdaDe(Direcao.LESTE));
		Assert.assertEquals(Direcao.SUL, Bussola.esquerdaDe(Direcao.OESTE));
	}

}
