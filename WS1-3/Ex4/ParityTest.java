import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is a private test to check if the program works correctly. The program
 * has been written so that it takes a two-dimensional array, consisting of only
 * 0s and 1s, and it then returns an array that has one extra column, and one
 * extra row. However, the program needs to adhere to the parity rules which
 * were defined within Worksheet3.
 *
 * @author Abdikhaliq Timer
 * @version 30/10/2016
 */
public class ParityTest {
	/**
	 * The tests below all check to make sure the program is doing to right
	 * thing. So I have run multiple tests of different sizes, in order to check
	 * to make sure the program can correctly handle different sized matrix.
	 */
	@Test
	public void test1() {
		int[][] test1 = { { 0, 1 }, { 0, 0 } };

		int[][] expected = { { 0, 1, 1 }, { 0, 0, 0 }, { 0, 1, 1 } };

		int[][] actual = Parity.addParity(test1);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[][] test1 = { { 1, 1 }, { 1, 1 } };
		int[][] expected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 0 } };
		int[][] actual = Parity.addParity(test1);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test3() {
		int[][] test3 = { { 0, 1, 1 }, { 0, 0, 1 } };
		int[][] expected = { { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 0, 1, 0, 1 } };

		int[][] actual = Parity.addParity(test3);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test4() {
		int[][] test4 = { { 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 1, 0, 1, 0 } };
		int[][] testN4 = { { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 1, 0, 1, 0 } };
		assertNotSame(Parity.checkParity(testN4), Parity.checkParity(test4));
	}

	@Test
	public void test5() {

		int[][] test4 = { { 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 }, { 0, 1, 0, 1, 0 } };

		assertFalse(Parity.checkParity(test4));
	}

	@Test
	public void test6() {

		int[][] test4 = { { 0, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1 } };

		assertTrue(Parity.checkParity(Parity.addParity(test4)));

	}

	@Test
	public void test7() {

		int[][] test4 = { { 0, 0 }, { 0, 0 } };

		int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		int[][] actual = Parity.addParity(test4);
		assertArrayEquals(expected, actual);

	}
}
