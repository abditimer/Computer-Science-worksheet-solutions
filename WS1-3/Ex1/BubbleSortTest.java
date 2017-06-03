import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is a private test to check whether bubbleSort produces the correct
 * results.
 *
 * @author Abdikhaliq Timer
 * @version 30/10/2016
 */

public class BubbleSortTest {
	/**
	 * test1
	 * <p>
	 * The first test will check only two small one-digit numbers to quickly
	 * test if the program is working correctly.
	 */
	@Test
	public void test1() {

		int[] a = { 2, 5 };

		int[] expected = { 2, 5};
		int[] actual = BubbleSort.bubbleSort(a);

		assertArrayEquals(expected, actual);
	}
	/**
	 * test2
	 * <p>
	 * This test checks all single-digit numbers between 1-9 to see 
	 * how bubbleSort deals with multiple different numbers.
	 */
	@Test
	public void test2() {

		int[] a = {5, 4, 2, 7, 9, 3, 1, 6, 8};

		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] actual = BubbleSort.bubbleSort(a);

		assertArrayEquals(expected, actual);
	}
	/**
	 * test3
	 * <p>
	 * This test checks how bubbleSort deals with two-digit numbers
	 */
	@Test
	public void test3() {

		int[] a = { 15, 13, 12, 14, 11};

		int[] expected = {11, 12, 13, 14, 15};
		int[] actual = BubbleSort.bubbleSort(a);

		assertArrayEquals(expected, actual);
	}
	/**
	 * test4
	 * <p>
	 * This test checks how bubbleSort deals with a large range of two-digit numbers.
	 */
	@Test
	public void test4() {

		int[] a = { 51, 36, 92, 64, 83, 73};

		int[] expected = {36, 51, 64, 73, 83, 92 };
		int[] actual = BubbleSort.bubbleSort(a);

		assertArrayEquals(expected, actual);
	}
	/**
	 * test5
	 * <p>
	 * This test checks zero against a large number.
	 */
	@Test
	public void test5() {

		int[] a = {100000, 0};

		int[] expected = {0, 100000 };
		int[] actual = BubbleSort.bubbleSort(a);

		assertArrayEquals(expected, actual);
	}
}
