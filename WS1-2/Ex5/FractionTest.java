package Ex5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * private test written for the Fraction.java file.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/2016
 * 
 */

public class FractionTest {
	/**
	 * The code below will run before the other tests are run, as this will
	 * allow for the creation of the new Fractions.
	 */
	private Fraction fraction1, fraction2;

	/**
	 * I have created two new objects below, fractions 1 and 2, which I will be
	 * using for the different tests.
	 */
	@Before
	public void setUp() {
		fraction1 = new Fraction(1, 3);
		fraction2 = new Fraction(3, 8);
	}

	/**
	 * test1 will check to make sure that the fraction is outputting the correct
	 * values for both the numerator and denominator. We do that by checking the
	 * values produced by the getters, and checking them with the actual values.
	 */
	@Test
	public void test1() {

		assertEquals(1, fraction1.getNumerator());
		assertEquals(3, fraction1.getDenominator());
		assertEquals("1/3", fraction1.toString());
		assertEquals(3, fraction2.getNumerator());
		assertEquals(8, fraction2.getDenominator());
		assertEquals("3/8", fraction2.toString());
	}

	/**
	 * test2 checks the method written for the addition of the two fractions.
	 * The expected value is the fraction we expect the program to output, via
	 * the actual fraction.
	 */
	@Test
	public void test2() {

		Fraction expected = new Fraction(17, 24);
		Fraction actual = fraction1.add(fraction2);

		assertEquals(expected.getNumerator(), actual.getNumerator());
		assertEquals(expected.getDenominator(), actual.getDenominator());
		assertEquals(expected.toString(), actual.toString());
	}

	/**
	 * test3 tests will add them in reverse.
	 */
	@Test
	public void test3() {

		Fraction expected = new Fraction(17, 24);
		Fraction actual = fraction2.add(fraction1);

		assertEquals(expected.getNumerator(), actual.getNumerator());
		assertEquals(expected.getDenominator(), actual.getDenominator());
		assertEquals(expected.toString(), actual.toString());
	}

	/**
	 * test4 tests will show how, no matter how you add the fractions, they will
	 * always have the same answer. This is another way to check if the program
	 * is adding the fractions together correctly.
	 */
	@Test
	public void test4() {
		Fraction expected = fraction1.add(fraction2);
		Fraction actual = fraction2.add(fraction1);
		assertEquals(expected.getNumerator(), actual.getNumerator());
		assertEquals(expected.getDenominator(), actual.getDenominator());
		assertEquals(expected.toString(), actual.toString());
	}

	/**
	 * test5 test shows the multiplication of two fractions, and checks it
	 * compared to the actual value it is supposed to be.
	 */
	@Test
	public void test5() {

		Fraction expected = new Fraction(3, 24);
		Fraction actual = fraction1.multiply(fraction2);

		assertEquals(expected.getNumerator(), actual.getNumerator());
		assertEquals(expected.getDenominator(), actual.getDenominator());
		assertEquals(expected.toString(), actual.toString());
	}

	/**
	 * test6 test shows the same multiplication as test5, but it allows us to
	 * check that the program still outputs the same value, no matter the order
	 * of multiplication for the fraction.
	 */
	@Test
	public void test6() {

		Fraction expected = new Fraction(3, 24);
		Fraction actual = fraction2.multiply(fraction1);

		assertEquals(expected.getNumerator(), actual.getNumerator());
		assertEquals(expected.getDenominator(), actual.getDenominator());
		assertEquals(expected.toString(), actual.toString());
	}

	/**
	 * test7 compares the sizes of the fractions. <p. As our fraction, f1, is
	 * smaller than f2, f1 < f2 will be true. This will hence test to make sure
	 * that the program outputs correct values.
	 */
	@Test
	public void test7() {

		assertTrue(fraction1.less(fraction2));
		assertFalse(fraction2.less(fraction1));

		assertTrue(fraction1.multiply(fraction2).less(fraction1.add(fraction2)));
	}

	/**
	 * test8 we make sure that fractions are being returned, instead of nothin
	 * (null).
	 */
	@Test
	public void test8() {
		assertNotNull("should not be null!", fraction1.getNumerator());
		assertNotNull("should not be null!", fraction1.getDenominator());
		assertNotNull("should not be null!", fraction1.toString());
		assertNotNull("should not be null!", fraction2.getNumerator());
		assertNotNull("should not be null!", fraction2.getDenominator());
		assertNotNull("should not be null!", fraction2.toString());
	}

	/**
	 * test9 checks to make sure that the fractions are not the same in any way.
	 */
	@Test
	public void test9() {

		assertNotSame(fraction1.getNumerator(), fraction2.getNumerator());
		assertNotSame(fraction1.getDenominator(), fraction2.getDenominator());
		assertNotSame(fraction1.toString(), fraction2.toString());
	}
}
