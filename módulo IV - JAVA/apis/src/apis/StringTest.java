package apis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTest {
	@Test
	public void indexOfTest() {
		String teste = "abc";
		assertEquals(1, teste.indexOf("b"));

	}

	@Test
	public void replaceTest() {
		String teste = "quase la";
		assertEquals("mentira", teste.replace(teste, "mentira"));
	}

	@Test
	public void splitTest() { //tem um array, o split separa uma variavel por algum caracter para colocar no array
		String teste = "foco,força,fé";
		String[] split = teste.split(",");
		assertEquals("foco", split[0]);
		assertEquals("força", split[1]);
		assertEquals("fé", split[2]);
	}
	
}
