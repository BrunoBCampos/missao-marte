package br.com.elo7.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo7.dominio.Sonda;
import br.com.elo7.service.SondaService;

@RestController
@RequestMapping(value = "/sonda", consumes ="application/json" )
public class SondaRest {
	
	@Autowired
	private SondaService sondaService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<br.com.elo7.rest.Sonda> cadastrar(@RequestBody Sonda sonda) {
		sondaService.cadastrar(sonda);
		br.com.elo7.rest.Sonda recurso = new br.com.elo7.rest.Sonda(sonda);
		Link relation = linkTo(methodOn(SondaRest.class).movimentar(sonda.getId(), "M")).withRel("movimentarSonda");
		recurso.add(relation);
		return new ResponseEntity<br.com.elo7.rest.Sonda>(recurso, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}/comando/{comando}", method=RequestMethod.POST)
	public Sonda movimentar(@PathVariable("id") Long id, @PathVariable("comando") String comandos) {
		return sondaService.movimentar(id, comandos);
	}

}
