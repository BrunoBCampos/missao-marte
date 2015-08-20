package br.com.elo7.rest;

import org.springframework.hateoas.ResourceSupport;

public class Sonda extends ResourceSupport{
	
	private br.com.elo7.dominio.Sonda sonda;

	public Sonda(br.com.elo7.dominio.Sonda sonda) {
		super();
		this.sonda = sonda;
	}
	
	public br.com.elo7.dominio.Sonda getSonda() {
		return sonda;
	}

}
