package apis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {

	@Test
	public void getTest() {
		Map teste = new HashMap<String, Integer>();

		teste.put("um", 1);
		teste.put("dois", 2);

		assertEquals(2, teste.get("dois"));
	}

	@Test
	public void putTest() {
		Map teste = new HashMap<String, Integer>();

		teste.put("um", 1);
		teste.put("dois", 2);

		Map teste1 = new HashMap<String, Integer>();

		teste1.put("um", 1);
		teste1.put("dois", 2);

		assertEquals(teste1, teste);
	}

	@Test
	public void containsKeyTest() {
		Map teste = new HashMap<String, Integer>();

		teste.put("um", 1);
		teste.put("dois", 2);

		assertEquals(true, teste.containsKey("dois"));
		assertEquals(false, teste.containsKey("zero"));
	}

	@Test
	public void containsValueTest() {
		Map teste = new HashMap<String, Integer>();

		teste.put("um", 1);
		teste.put("dois", 2);

		assertEquals(false, teste.containsValue(3));
		assertEquals(true, teste.containsValue(2));
	}

}
