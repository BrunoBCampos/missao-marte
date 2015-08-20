package br.com.elo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<Planalto> cadastrar(@RequestBody Planalto planalto) {
		repository.cadastrar(planalto);
		return new ResponseEntity<Planalto>(planalto, HttpStatus.CREATED);		
	}
	
}
