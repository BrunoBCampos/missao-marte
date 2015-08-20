package br.com.elo7.rest;

import org.springframework.hateoas.ResourceSupport;

public class Planalto extends ResourceSupport {
	
	private br.com.elo7.dominio.Planalto planalto;

	public Planalto(br.com.elo7.dominio.Planalto planalto) {
		this.planalto = planalto;
	}
	
	public br.com.elo7.dominio.Planalto getPlanalto() {
		return planalto;
	}

}
