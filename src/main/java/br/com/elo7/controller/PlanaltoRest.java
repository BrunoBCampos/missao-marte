package br.com.elo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo7.banco.Repository;
import br.com.elo7.dominio.Planalto;

@RestController
@RequestMapping(value = "/planalto", consumes ="application/json" )
public class PlanaltoRest {

	@Autowired
	private Repository repository;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<br.com.elo7.rest.Planalto> cadastrar(@RequestBody Planalto planalto) {
		repository.cadastrar(planalto);
		br.com.elo7.rest.Planalto recurso = new br.com.elo7.rest.Planalto(planalto);
		Link relation = linkTo(methodOn(SondaRest.class).cadastrar(null)).withRel("cadastrarSonda");
		recurso.add(relation);
		return new ResponseEntity<br.com.elo7.rest.Planalto>(recurso, HttpStatus.CREATED);
	}
	
}
