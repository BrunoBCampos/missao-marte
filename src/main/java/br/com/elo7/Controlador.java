package br.com.elo7;

import br.com.elo7.dominio.Planalto;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;

public class Controlador {
	
	//Classe criada somente para cumprir com o que foi solicitado (receber 3 entradas e dar o resultado)
	//Tendo em vista que será criada uma API REST, esta classe não será mais utilizada
	
	public Sonda missaoMarte(String planalto, String posicao, String comandos) {
		Planalto.build(planalto);
		Sonda sonda = new Sonda(Posicao.criar(posicao));
		sonda.movimenta(comandos);
		return sonda;
	}
	
}
