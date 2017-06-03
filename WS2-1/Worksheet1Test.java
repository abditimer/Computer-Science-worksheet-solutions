import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Abdikhaliq Timer
 * 
 *         This class contains the test cases for Worksheet1 solutions.
 */

public class Worksheet1Test extends Worksheet1 {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests Exercise 1: Power
	 */

	@Test
	public void ex1PublicTest1() {
		int actual = power(2, 2);
		int expected = 4;
		double tolerance = 1e-8;
		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest2() {
		int actual = power(2, 0);
		int expected = 1;
		double tolerance = 1e-8;
		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest3() {
		int actual = power(0, 5);
		int expected = 0;
		double tolerance = 1e-8;
		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest4() {
		int actual = power(0, 0);
		assertNotNull(actual);
	}

	@Test
	public void ex1PublicTest5() {
		int[] actual = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < 5; i++) {
			actual[i] = power(2, i);
		}
		int[] expected = { 1, 2, 4, 8, 16 };
		assertArrayEquals(actual, expected);
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests Exercise 1: Power
	 */

	@Test
	public void ex1PublicTest1FastPower() {
		int actual = fastPower(2, 2);
		int expected = 4;
		double tolerance = 1e-8;
		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest2FastPower() {
		int actual = fastPower(2, 0);
		int expected = 1;
		double tolerance = 1e-8;
		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest3FastPower() {
		int actual = fastPower(0, 5);
		int expected = 0;
		double tolerance = 1e-8;
		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest4FastPower() {
		int actual = fastPower(0, 0);
		assertNotNull(actual);
	}

	@Test
	public void ex1PublicTest5FastPower() {
		int[] actual = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < 5; i++) {
			actual[i] = fastPower(2, i);
		}
		int[] expected = { 1, 2, 4, 8, 16 };
		assertArrayEquals(actual, expected);
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests are for Exercise 2
	 */

	@Test
	public void ex2PublicTest1() {
		List actual = List.cons(1, List.cons(2, List.cons(-3, List.cons(-4, List.empty()))));
		List negated = negateAll(actual);
		List expected = List.cons(-1, List.cons(-2, List.cons(3, List.cons(4, List.empty()))));
		assertTrue(List.equals(expected, negated));
	}

	@Test
	public void ex2PublicTest2() {
		List actual = List.cons(1,
				List.cons(2, List.cons(-8, List.cons(-9, List.cons(-3, List.cons(-4, List.empty()))))));
		List negated = negateAll(actual);
		List expected = List.cons(-1,
				List.cons(-2, List.cons(8, List.cons(9, List.cons(3, List.cons(4, List.empty()))))));
		assertTrue(List.equals(expected, negated));
	}

	@Test
	public void ex2PublicTest3() {
		List actual = List.cons(1, List.empty());
		List negated = negateAll(actual);
		List expected = List.cons(-1, List.empty());
		assertTrue(List.equals(expected, negated));
	}

	@Test
	public void ex2PublicTest4() {
		List actual = List.cons(-1,
				List.cons(-2, List.cons(-3, List.cons(-4, List.cons(-5, List.cons(-6, List.empty()))))));
		List negated = negateAll(actual);
		List expected = List.cons(1,
				List.cons(2, List.cons(3, List.cons(4, List.cons(5, List.cons(6, List.empty()))))));
		assertTrue(List.equals(expected, negated));
	}

	@Test
	public void ex2PublicTest5() {
		List actual = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.cons(5, List.cons(6, List.empty()))))));
		List negated = negateAll(actual);
		List expected = List.cons(-1,
				List.cons(-2, List.cons(-3, List.cons(-4, List.cons(-5, List.cons(-6, List.empty()))))));
		assertTrue(List.equals(expected, negated));
	}

	@Test
	public void ex2PublicTest6() {
		exception.expect(IllegalStateException.class);
		negateAll(List.empty());
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests are for Exercise 3
	 */

	@Test
	public void ex3PublicTest1() {
		List actual = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.cons(5, List.cons(6, List.empty()))))));
		int found = find(1, actual);
		int expected = 0;
		assertEquals(found, expected);
	}

	@Test
	public void ex3PublicTest2() {
		List actual = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.cons(5, List.cons(6, List.empty()))))));
		int found = find(6, actual);
		int expected = 5;
		assertEquals(found, expected);
	}

	@Test
	public void ex3PublicTest3() {
		exception.expect(IllegalStateException.class);
		List actual = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.cons(5, List.cons(6, List.empty()))))));
		int found = find(100, actual);
	}
	
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests are for Exercise 4
	 */

	@Test
	public void ex4PublicTest1() {
		exception.expect(IllegalStateException.class);
		List emptyList = List.empty();
		boolean check = allPositive(emptyList);
	}

	@Test
	public void ex4PublicTest2() {
		List actual = List.cons(1, List.empty());
		boolean found = allPositive(actual);

		assertTrue(found);

	}

	@Test
	public void ex4PublicTest3() {
		List actual = List.cons(-1, List.empty());
		boolean found = allPositive(actual);

		assertFalse(found);
	}

	@Test
	public void ex4PublicTest4() {
		List actual = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.cons(5, List.cons(6, List.empty()))))));
		boolean found = allPositive(actual);

		assertTrue(found);
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests are for Exercise 5
	 */

	@Test
	public void ex5PublicTest1() {
		exception.expect(IllegalStateException.class);
		List empty = List.empty();
		List check = positives(empty);
	}

	@Test
	public void ex5PublicTest2() {
		List actual = List.cons(1, List.cons(2, List.cons(3, List.cons(-4, List.cons(-5, List.cons(-6, List.empty()))))));
		List negated = positives(actual);
		List expected = List.cons(1,
				List.cons(2, List.cons(3, List.empty())));
		assertTrue(List.equals(expected, negated));
	}

	@Test
	public void ex5PublicTest3() {
		List actual = List.cons(1, List.empty());
		List negated = positives(actual);
		List expected = List.cons(1,List.empty());
		assertTrue(List.equals(expected, negated));
	}

	@Test
	public void ex5PublicTest4() {
		List actual = List.cons(-1, List.empty());
		List negated = positives(actual);
		List expected = List.empty();
		assertTrue(List.equals(expected, negated));
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests are for Exercise 6
	 */

	@Test
	public void ex6PublicTest2() {
		exception.expect(IllegalStateException.class);
		List empty = List.empty();
		boolean check = sorted(empty);
		
	}

	@Test
	public void ex6PublicTest1() {
		List actual = List.cons(1, List.empty());
		boolean check = sorted(actual);
		assertTrue(check);

	}

	@Test
	public void ex6PublicTest3() {
		List actual = List.cons(1, List.cons(-2, List.cons(3, List.cons(-4, List.empty()))));
		boolean check = sorted(actual);
		assertFalse(check);
	}

	@Test
	public void ex6PublicTest4() {
		List actual = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.empty()))));
		boolean check = sorted(actual);
		assertTrue(check);
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests are for Exercise 7
	 */

	@Test
	public void ex7PublicTest1() {
		exception.expect(IllegalStateException.class);
		List empty1 = List.empty();
		List empty2 = List.empty();
		List check = merge(empty1, empty2);
	}

	@Test
	public void ex7PublicTest2() {
		List actual1 = List.cons(1, List.empty());
		List actual2 = List.cons(2, List.empty());
		List check = merge(actual1, actual2);
		List expected = List.cons(1, List.cons(2, List.empty()));
		assertTrue(List.equals(check, expected));
	}

	@Test
	public void ex7PublicTest3() {
		List actual1 = List.cons(-1, List.empty());
		List actual2 = List.cons(-2, List.empty());
		List check = merge(actual1, actual2);
		List expected = List.cons(-2, List.cons(-1, List.empty()));
		assertTrue(List.equals(check, expected));
	}

	@Test
	public void ex7PublicTest4() {
		List actual1 = List.cons(10, List.empty());
		List actual2 = List.empty();
		List check = merge(actual1, actual2);
		List expected = List.cons(10,  List.empty());
		assertTrue(List.equals(check, expected));
	}
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * The following tests are for Exercise 5
	 */

	@Test
	public void ex8PublicTest1() {
		exception.expect(IllegalStateException.class);
		List emptyList = List.empty();
		removeDuplicates(emptyList);
	}

	@Test
	public void ex8PublicTest2() {
		List containsDuplicates = List.cons(1, List.cons(2, List.cons(2, List.cons(3, List.empty()))));
		List noDuplicates = removeDuplicates(containsDuplicates);
		List expected = List.cons(1, List.cons(2, List.cons(3, List.empty())));
		assertTrue(List.equals(noDuplicates, expected));
	}

	@Test
	public void ex8PublicTest3() {
		List containsDuplicates = List.cons(1, List.cons(2, List.cons( 3, List.empty())));
		List noDuplicates = removeDuplicates(containsDuplicates);
		List expected = List.cons(1, List.cons(2, List.cons(3, List.empty())));
		assertTrue(List.equals(noDuplicates, expected));
	}

	@Test
	public void ex8PublicTest4() {
		List containsDuplicates = List.cons(1, List.cons(1, List.cons( 1, List.empty())));
		List noDuplicates = removeDuplicates(containsDuplicates);
		List expected = List.cons(1, List.empty());
		assertTrue(List.equals(noDuplicates, expected));
	}

}
