package br.com.elo7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.banco.Repository;
import br.com.elo7.dominio.Planalto;

@Service
public class PlanaltoServiceImpl implements PlanaltoService {

	@Autowired
	private Repository repository;
	
	@Override
	public void cadastrar(Planalto planalto) {
		repository.cadastrar(planalto);
	}

}
