import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * This is a private test to check if the returned numbers within Omit.java are
 * the correct ones.
 *
 * @author Abdikhaliq Timer
 * @version 30/10/2016
 */
public class OmitTest {
	/**
	 * Test 1 will check very simple numbers, to check how the program deals
	 * with integers
	 */
	@Test
	public void test1() {

		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5));
		ArrayList<Integer> actual = Omit.allIntegersWithout(1, 5, 2);

		assertEquals(expected, actual);

	}

	/**
	 * Test 2 now will
	 */
	@Test
	public void test2() {

		ArrayList<Integer> expected = new ArrayList<Integer>(
				Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20));
		ArrayList<Integer> actual = Omit.allIntegersWithout(1, 20, 5);

		assertEquals(expected, actual);

	}

	@Test
	public void test3() {

		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(100, 101, 103));
		ArrayList<Integer> actual = Omit.allIntegersWithout(100, 103, 2);

		assertEquals(expected, actual);

	}

	@Test
	public void test4() {

		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005));
		ArrayList<Integer> actual = Omit.allIntegersWithout(900, 1005, 9);

		assertEquals(expected, actual);

	}

	@Test
	public void test5() {

		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
		ArrayList<Integer> actual = Omit.allIntegersWithout(1, 7, 7);

		assertEquals(expected, actual);

	}
}
