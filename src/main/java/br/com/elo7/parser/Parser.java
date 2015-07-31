package br.com.elo7.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import br.com.elo7.dominio.Comando;

public class Parser {
	
	private static Pattern pattern = Pattern.compile("^[LRM]+$");
	
	public static List<Comando> parse(String input) {
		if (!isValid(input)) {
			throw new IllegalArgumentException(String.format("A entrada %s é invalida", input));
		}

		return Arrays.asList(input.split(""))
				.stream().map(value -> Comando.get(value))
				.collect(Collectors.toList());
		
	}

	private static boolean isValid(String input) {
		return input == null ? false : pattern.matcher(input).matches();
	}

}
