package br.com.elo7.banco;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.elo7.config.Application;
import br.com.elo7.dominio.Comando;
import br.com.elo7.dominio.Direcao;
import br.com.elo7.dominio.Planalto;
import br.com.elo7.dominio.Posicao;
import br.com.elo7.dominio.Sonda;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)

public class RepositoryTest {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private Repository repository;
	
	@Test
	public void deveCriarEntitdadeNoBancoDeDados() {
		Planalto planalto = new Planalto(3,4);
		repository.cadastrar(planalto);
		assertThat(planalto.getId(), is(notNullValue()));
	}
	
	@Test
	public void deveAtualizarEntidadeNoBancoDeDados() {
		Sonda sonda = new Sonda(Posicao.criar(1, 1, Direcao.NORTE));
		repository.cadastrar(sonda);
		
		sonda.movimenta(Comando.ANDAR);
		repository.atualizar(sonda);
		em.detach(sonda);
		
		Sonda entidade = em.find(Sonda.class, sonda.getId());
		assertThat(entidade.getPosicao(), is(equalTo(Posicao.criar(1, 2, Direcao.NORTE))));
	}

}
