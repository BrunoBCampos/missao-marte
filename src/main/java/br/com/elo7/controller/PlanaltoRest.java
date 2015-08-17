package br.com.elo7.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/planalto")
public class PlanaltoRest {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<>();
		map.put("Teste", "Ok");
		return map;
	}
	
}
