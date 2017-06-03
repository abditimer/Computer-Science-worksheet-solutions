import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is a private test to check whether the rating provides the correct
 * results.
 *
 * @author Abdikhaliq Timer
 * @version 30/10/2016
 */

public class StarRatingTest {
	/**
	 * test 1 through to test will check to make sure our ranges are correct.
	 */
	@Test
	public void test1() {

		double rating = 5.0;

		String expected = "[HAS ONLY ONE REVIEW]";
		String actual = StarRating.interpret(rating);

		assertEquals(expected, actual);
	}

	@Test
	public void test2() {

		double rating = 4.8;

		String expected = "EXCELLENT";
		String actual = StarRating.interpret(rating);

		assertEquals(expected, actual);
	}

	@Test
	public void test3() {

		double rating = 4.1;

		String expected = "OK";
		String actual = StarRating.interpret(rating);

		assertEquals(expected, actual);
	}

	@Test
	public void test4() {

		double rating = 2.5;

		String expected = "CRAP";
		String actual = StarRating.interpret(rating);

		assertEquals(expected, actual);
	}

	@Test
	public void test5() {

		double rating = -10.5;

		String expected = "not rated";
		String actual = StarRating.interpret(rating);

		assertEquals(expected, actual);
	}

	/**
	 * test 6 will check what happens when a large rating is given
	 */
	@Test
	public void test6() {

		double rating = 234;

		String expected = "[HAS ONLY ONE REVIEW]";
		String actual = StarRating.interpret(rating);

		assertEquals(expected, actual);
	}

	/**
	 * test 7 will check to make sure the rating has been filled, and that it is
	 * not empty.
	 */
	@Test
	public void test7() {

		double rating = 2;

		assertNotNull("This should not be empty", StarRating.interpret(rating));
	}

	/**
	 * Tests 8, 9 and 10 check to make sure the wrong rating is not given.
	 */
	@Test
	public void test8() {

		double rating = -5.5;

		String expected = "OK";
		String actual = StarRating.interpret(rating);

		assertFalse(expected == actual);
	}

	@Test
	public void test9() {

		double rating = 5;

		String expected = "CRAP";
		String actual = StarRating.interpret(rating);

		assertFalse(expected == actual);
	}

	@Test
	public void test10() {

		double rating = 1;

		String expected = "EXCELLENT";
		String actual = StarRating.interpret(rating);

		assertFalse(expected == actual);
	}
}
