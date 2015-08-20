package br.com.elo7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.banco.Repository;
import br.com.elo7.dominio.Planalto;
import br.com.elo7.dominio.Sonda;

@Service
public class SondaServiceImpl implements SondaService {

	@Autowired
	private Repository repository;
	
	@Override
	public void cadastrar(Sonda sonda) {
		Planalto planalto = repository.buscar(Planalto.class, sonda.getPlanalto().getId());
		sonda.setPlanalto(planalto);
		repository.cadastrar(sonda);
	}

	@Override
	public Sonda movimentar(Long id, String comandos) {
		Sonda sonda = repository.buscar(Sonda.class, id);
		sonda.movimenta(comandos);
		repository.atualizar(sonda);
		return sonda;
	}

}
