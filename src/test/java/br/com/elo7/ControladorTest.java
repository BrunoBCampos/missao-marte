package br.com.elo7;

import org.junit.Assert;
import org.junit.Test;

import br.com.elo7.dominio.Direcao;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;

public class ControladorTest {
	
	@Test
	public void deveFuncionarDeAcordoComOExemplo() {
		Controlador controlador = new Controlador();
		Sonda sonda = controlador.missaoMarte("55", "12N", "LMLMLMLMM");
		Assert.assertEquals(new Sonda(Posicao.criar(1, 3, Direcao.NORTE)), sonda);
	}

}
