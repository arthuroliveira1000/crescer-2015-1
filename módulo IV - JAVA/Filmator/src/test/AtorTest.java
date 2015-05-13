package test;

import static org.junit.Assert.*;

import org.junit.Test;

import filmator.Ator;

public class AtorTest {

	@Test
	public void toStringFunciona() {

		Ator vera = new Ator("Vera Farmiga");
		
		
		
		assertEquals("Vera Farmiga", vera.toString());

	}

}
