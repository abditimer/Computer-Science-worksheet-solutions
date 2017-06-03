package Ex2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a private test, for the Student.java file within the same folder.
 *
 * @author Abdikhaliq Timer
 * @version 15/10/2016
 */

public class StudentTest {
	/**
	 * The code below will run before the other tests are run, as this will
	 * allow for the creation of the new Student, with the specific parameters
	 * I have chosen.
	 */
	private Student s1;
	private Student s2;
	@Before
	public void setUp() {
		s1 = new Student("Abdikhaliq Timer", "1 January 1993", "1238608", "MSc Computer Science");
		s2 = new Student("Tom Harvard", "12 May 1993", "5875625", "MSc Advanced Computer Science");
	}
	/**
	 * test1 will check to make sure the parameters of student 1, s1, are 
	 * correct. For example, It will check to make sure the correct names are included.
	 */
	@Test
	public void test1() {
		assertEquals("Abdikhaliq Timer", s1.getName());
		assertEquals("Tom Harvard", s2.getName());
	}
	/**
	 * test2 will check to make sure the date of births are correct for the two separate
	 * student objects. This is useful as it will make sure that the program has assigned
	 * the correct date of birth to the correct student.
	 */
	@Test
	public void test2() {
		assertEquals("1 January 1993", s1.getDateOfBirth());
		assertEquals("12 May 1993", s2.getDateOfBirth());
	}
    /** test3 is extremely useful as it is an assertion that examines the if 
     *  two mentioned parts are the same. So in the test below, the date of 
     *  births of the two different students are checked.
     */
	@Test
	public void test3() {
		assertNotSame(s2.getDateOfBirth(), s1.getDateOfBirth());
	}
	@Test
    public void test4() { 
		assertNotNull("should not be null", s1.getName());
		assertNotNull("should not be null", s2.getName());
	} 
	@Test
	public void test5() { 
		assertFalse("Failure: should be false", s1.getName() == s2.getName());
	} 	
}
