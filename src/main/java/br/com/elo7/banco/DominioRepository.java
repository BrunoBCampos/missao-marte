package br.com.elo7.banco;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Repository
@Transactional
public class DominioRepository implements Repository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void cadastrar(Object o) {
		em.persist(o);
	}

	@Override
	public void atualizar(Object o) {
		em.merge(o);
	}

}
