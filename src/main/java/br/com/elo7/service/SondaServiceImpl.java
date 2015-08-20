package br.com.elo7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.banco.Repository;
import br.com.elo7.dominio.Planalto;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;

@Service
public class SondaServiceImpl implements SondaService {

	@Autowired
	private Repository repository;
	
	@Override
	public void cadastrar(Sonda sonda) {
		Planalto planalto = repository.buscar(Planalto.class, sonda.getPlanalto().getId());
		if (planalto == null) throw new IllegalArgumentException("Id do planalto inexistente");
		sonda.setPlanalto(planalto);
		ajustarCoordenadasPosicao(sonda);
		repository.cadastrar(sonda);
	}
	
	private void ajustarCoordenadasPosicao(Sonda sonda) {
		int x = sonda.getPosicao().getX();
		int y = sonda.getPosicao().getY();
		if (sonda.getPosicao().getX() > sonda.getPlanalto().getLimiteX()) x = sonda.getPlanalto().getLimiteX();
		if (sonda.getPosicao().getY() > sonda.getPlanalto().getLimiteY()) y = sonda.getPlanalto().getLimiteY();
		sonda.setPosicao(Posicao.criar(x, y, sonda.getPosicao().getDirecao()));
	}

	@Override
	public Sonda movimentar(Long id, String comandos) {
		Sonda sonda = repository.buscar(Sonda.class, id);
		if (sonda == null) throw new IllegalArgumentException("Id da sonda inexistente");
		sonda.movimenta(comandos);
		repository.atualizar(sonda);
		return sonda;
	}

}
