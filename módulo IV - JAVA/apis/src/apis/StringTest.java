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
		String teste = "foco,for�a,f�";
		String[] split = teste.split(",");
		assertEquals("foco", split[0]);
		assertEquals("for�a", split[1]);
		assertEquals("f�", split[2]);
	}
	
}
