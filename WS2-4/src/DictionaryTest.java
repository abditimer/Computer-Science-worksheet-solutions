import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
/**
 * The following will test various components of my predictive text model
 * @author Abdikhaliq Timer
 *
 */
public class DictionaryTest {

		String a = "a";
		String b = "b";
		String c = "c";
	
	@Test
	public void test() throws IOException {
		DictionaryModel test = new DictionaryModel();
		ArrayList<String> empty = new ArrayList<>();
		empty.add(a);
		empty.add(b);
		empty.add(c);
		test.addCharacter('2');
		assertEquals(test, empty);
	}

}