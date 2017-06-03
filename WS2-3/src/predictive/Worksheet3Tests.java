package predictive;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import predictive.PredictivePrototype;

/**
 * This is the main test file containing a range of tests
 * @author theti
 *
 */
public class Worksheet3Tests {
	//ListDictionary d = new ListDictionary();
	/*
	 * The first few tests check the wordToSignature method. 
	 */
	@Test
	public void ex1Test1() {
		String check = "";
		String expected = "";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test2() {
		String check = " ";
		String expected = " ";
		assertEquals(expected, PredictivePrototype.wordToSignature(check)); 
	}
	@Test
	public void ex1Test3() {
		String check = "a";
		String expected = "2";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test4() {
		String check = "abdi";
		String expected = "2234";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test5() {
		String check = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String expected = "22233344455566677778889999";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test6() {
		String check = "abcdefghijklmnopqrstuvwxyz";
		String expected = "22233344455566677778889999";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test7() {
		String check = "aaaaabbbbbccccdde";
		String expected = "22222222222222333";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test8() {
		String check = "a";
		String expected = "9";
		assertNotEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test9() {
		String check = "a$b£c";
		String expected = "2 2 2";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	@Test
	public void ex1Test10() {
		String check = "ABC";
		String expected = "222";
		assertEquals(expected, PredictivePrototype.wordToSignature(check));
	}
	
	//===================================================================================
	//***********************************************************************************
	//===================================================================================
	
	@Test
	public void isValidWordtest() {
		String word = "Abdikhaliq";
		assertTrue(PredictivePrototype.isValidWord(word));
	}
	@Test
	public void isValidWordtest1(){
		String word = "abcdefghijklmnopqrstuvwxyz";
		assertTrue(PredictivePrototype.isValidWord(word));
	}
	@Test
	public void isValidWordtest3(){
		String word = "";
		assertTrue(PredictivePrototype.isValidWord(word));
	}
	
	//===================================================================================
	//***********************************************************************************
	//===================================================================================

	@Test
	public void ex2test1() {
		String sig = "";
		HashSet<String> expected = new HashSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	
	@Test
	public void ex2test2() {
		String sig = "1";
		HashSet<String> expected = new HashSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords(sig);
		assertEquals(expected, result);
	}
	@Test
	public void ex2test3() {
		String signature = "3";
		HashSet<String> expected = new HashSet<>();
		expected.add("d");
		expected.add("e");
		expected.add("f");
		Set<String> result = PredictivePrototype.signatureToWords(signature);
		assertEquals(expected, result);
	}
	@Test
	public void ex2test4() {
		String signature = "9";
		HashSet<String> expected = new HashSet<>();
		expected.add("w");
		expected.add("x");
		expected.add("y");
		expected.add("z");
		Set<String> result = PredictivePrototype.signatureToWords(signature);
		assertEquals(expected, result);
	}
	

	
}
