package br.com.elo7.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.elo7.parser.Parser;
import br.com.elo7.regras.MovimentaDireita;
import br.com.elo7.regras.MovimentaEsquerda;
import br.com.elo7.regras.MovimentaFrente;
import br.com.elo7.regras.RegraMovimentacao;

@Entity
@Table(name="SONDA")
public class Sonda implements Serializable {

	private static final long serialVersionUID = 3356875690406000800L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private Posicao posicao;
	
	@ManyToOne
	private Planalto planalto;
	
	protected Sonda() { }
	
	public Sonda(Posicao posicao, Planalto planalto) {
		this.posicao = posicao;
		this.planalto = planalto;
	}
	
	public void movimenta(Comando comando) {
		this.posicao = getRegra().movimenta(comando, this);
	}
	
	public void movimenta(List<Comando> comandos) {
		comandos.forEach(comando -> movimenta(comando));
	}
	
	public void movimenta(String input) {
		movimenta(Parser.parse(input));
	}
	
	private RegraMovimentacao getRegra() {
		RegraMovimentacao regras = new MovimentaFrente();
		regras.incluiProximaRegra(new MovimentaEsquerda());
		regras.incluiProximaRegra(new MovimentaDireita());
		return regras;
	}

	public String status() {
		return String.format("Posicao atual: x: %d, y: %d, direcao: %s", posicao.getX(), posicao.getY(), posicao.getDirecao());
	}
	
	@Override
	public boolean equals(Object o) {
		return posicao.equals(((Sonda)o).getPosicao());
	}

	public Posicao getPosicao() {
		return posicao;
	}
	
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public Long getId() {
		return id;
	}
	
	public Planalto getPlanalto() {
		return planalto;
	}
	
	public void setPlanalto(Planalto planalto) {
		this.planalto = planalto;
	}
	
}
