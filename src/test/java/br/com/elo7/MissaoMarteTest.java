package br.com.elo7;

import junit.framework.Assert;

import org.junit.Test;

import br.com.elo7.dominio.Planalto;
import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;
import br.com.elo7.dominio.Bussola.Direcao;

public class MissaoMarteTest {
	
	@Test
	public void deveFuncionarDeAcordoComOExemplo() {
		Planalto.build(5, 5);
		Sonda sonda = new Sonda(Posicao.criar(1, 2, Direcao.NORTE));
		sonda.movimenta(Comando.ESQUERDA);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.ESQUERDA);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.ESQUERDA);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.ESQUERDA);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.ANDAR);
		Assert.assertEquals(new Sonda(Posicao.criar(1, 3, Direcao.NORTE)), sonda);
	}
	
	@Test
	public void deveFuncionarDeAcordoComOOutroExemplo() {
		Planalto.build(5, 5);
		Sonda sonda = new Sonda(Posicao.criar(3, 3, Direcao.LESTE));
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.DIREITA);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.DIREITA);
		sonda.movimenta(Comando.ANDAR);
		sonda.movimenta(Comando.DIREITA);
		sonda.movimenta(Comando.DIREITA);
		sonda.movimenta(Comando.ANDAR);
		Assert.assertEquals(new Sonda(Posicao.criar(5, 1, Direcao.LESTE)), sonda);
	}


}
