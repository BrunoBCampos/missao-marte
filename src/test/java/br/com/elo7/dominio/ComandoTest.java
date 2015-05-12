package br.com.elo7.dominio;

import junit.framework.Assert;

import org.junit.Test;

public class ComandoTest {
	
	@Test
	public void deveRetornarEnumComEntradaValida() {
		Assert.assertEquals(Comando.ESQUERDA, Comando.get("L"));
	}
	
	@Test
	public void deveRetornarNullComEntradaInvalida() {
		Assert.assertNull(Comando.get("J"));
	}

}
