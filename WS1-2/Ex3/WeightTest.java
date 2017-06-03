package Ex3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a private test for the Weight.java file within this folder.
 *
 * @author Abdikhaliq Timer
 * @version 15/10/2016
 */

public class WeightTest {
	/**
	 * The code below will run before the other tests are run, as this will
	 * allow for the creation of the new Employee objects, with the specific parameters
	 * I have chosen.
	 */
	private Weight weight1, weight2;
    /**
     * I have created two new objects below, weight1 and weight2, which
     * I will be using for the different tests.
     */
	@Before
	public void setUp() {
		weight1 = new Weight(4.78);
		weight2 = new Weight(5.86);
	}
    /**
     * the first few test will make sure that the three different getters are correct.
     * It will check if the different weights given in kilograms, pounds and ounces, 
     * and will return the weights in kilograms.
     */
	@Test
	public void test1() { //checks the conversion from kilograms, into kilograms.
		double expected = 4.78;
		assertEquals(expected, weight1.getKilograms(), 0.00000001);
	}
    @Test
    public void test2() { //checks the conversion from ounces into kilograms.
		double expected = 168.609538119;
		assertEquals(expected, weight1.getOunces(), 0.00000001);
	}
	@Test
	public void test3() {
		double expected = 12.919088564; //checks the conversion from pounds into kilograms.

		assertEquals(expected, weight2.getPounds(), 0.00000001);
	}
    /**
     * The following tests will check various different things, to make sure
     * that the program works.
     * <p>
     * test4 will check if an actual value is returned. 
     */
	@Test
	public void test4() {
		assertNotNull("should not be null", weight1.getClass());
	}
	/**
	 * test5 checks to make sure that the different weights dont return the same kilograms.
	 */
	@Test
	public void test5() {
		assertNotSame("should not be the same", weight1.getKilograms(), weight2.getKilograms() );
		assertNotSame("should not be the same", weight1.getPounds(), weight2.getPounds() );
		assertNotSame("should not be the same", weight1.getOunces(), weight2.getOunces() );
	}
	/**
	 * test6 will check to make sure the two weights are not equal.
	 */
	@Test
	public void test6() {
		assertFalse("Failure test: should be false", weight1 == weight2);
		assertFalse("Failure test: should be false", weight1.getKilograms() == weight2.getKilograms());
		assertFalse("Failure test: should be false", weight1.getPounds() == weight2.getPounds());
		assertFalse("Failure test: should be false", weight1.getOunces() == weight2.getOunces());
	}
	/**
	 * test7 will check if the different weights are not the same, and if they are not, 
	 * that means there is no duplication occuring within the program.
	 */
	@Test
	public void test7() {
		assertTrue(weight1.getPounds() != weight2.getPounds());
		assertTrue(weight1.getKilograms() != weight2.getKilograms());
		assertTrue(weight1.getOunces() != weight2.getOunces());
	}
}

