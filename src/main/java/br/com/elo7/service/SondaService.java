package br.com.elo7.service;

import br.com.elo7.dominio.Sonda;

public interface SondaService {
	
	void cadastrar(Sonda sonda);
	Sonda movimentar(Long id, String comandos);

}
