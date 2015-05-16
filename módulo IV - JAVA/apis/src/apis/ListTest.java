package apis;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void getTest() {

		List teste = new ArrayList<String>();
		String item1 = "um";
		String item2 = "dois";
		teste.add(item1);
		teste.add(item2);

		assertEquals("dois", teste.get(1));
		assertEquals("um", teste.get(0));
	}

	@Test
	public void setTest() {

		List teste = new ArrayList<String>();
		String item1 = "um";
		String item2 = "tres";
		teste.add(item1);
		teste.add(item2);
		teste.set(1, "dois");

		assertEquals("dois", teste.get(1));
	}

	@Test
	public void indexOfTest() {

		List teste = new ArrayList<String>();
		String item1 = "um";
		String item2 = "dois";
		teste.add(item1);
		teste.add(item2);

		assertEquals(1, teste.indexOf(item2));
	}

}
