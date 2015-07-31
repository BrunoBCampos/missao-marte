package br.com.elo7.parser;

import org.junit.Test;

public class ParserTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarStringVazia() {
		Parser.parse("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarStringInvalida() {
		Parser.parse("LM.LL");
	}
	
	@Test
	public void deveAceitarStringValida() {
		Parser.parse("RMLRMLMRLMRRRLMM");
	}
	
}
