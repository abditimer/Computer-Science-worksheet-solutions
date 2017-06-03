package Ex1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a private test, which will test the Employee.java file.
 *
 * @author Abdikhaliq Timer
 * @version 15/10/2016
 */

public class EmployeeTest {
	/**
	 * The code below will run before the other tests are run, as this will
	 * allow for the creation of the new Employee, with the specific parameters
	 * I have chosen.
	 */
	private Employee e1;
	private Employee e2;
	@Before
	public void setUp() {
	    /** 
		 * Here I have created a new Employee object with a full name and the joining year.
		 */
		e1 = new Employee("Abdikhaliq", "Timer", 13);
		e2 = new Employee("Barack", "Obama", 3);
	}
    /**
     * Below I have written 5 tests that will test my Employee class.
     * the first test, test1, will check the first names of the Employees
     */
	@Test
	public void test1() {

		e1.setFirstName("Nick");
		e2.setFirstName("Jones");
        /**
         * Assert equals checks the first element within the bracket against the second.
         * So in this case, we check the name Nick against the first name of Employee 1.
         */
		assertEquals("Nick", e1.getFirstName());
		assertEquals("Jones", e2.getFirstName());
	}
	/**
     * The second test, test2, will check the surnames of the Employees
     */
	@Test
	public void test2() {

		e1.setSurname("Donald");
		e2.setSurname("Alex");

		assertEquals("Donald", e1.getSurname());
		assertEquals("Alex", e2.getSurname());
	}
	/**
     * The third test, test3, will check the year the employees joined.
     */
	@Test
	public void test3() {

		e1.setYearOfJoining(10);
		e2.setYearOfJoining(5);
		
		assertEquals(10, e1.getYearOfJoining());
		assertEquals(5, e2.getYearOfJoining());
	}
	/**
     * The fourth test, test4, will check the full name of employee1.
     */
	@Test
	public void test4() { 
		
		e1.setFirstName("Nick");
		e1.setSurname("Hunter");

		assertEquals("Nick", e1.getFirstName());
		assertEquals("Hunter", e1.getSurname());
	}
	/**
     * The fifth test, test5, will check employee2 full name.
     */
	@Test
	public void test5() { 
		
		e2.setFirstName("Mark");
		e2.setSurname("Balding");

		assertEquals("Mark", e2.getFirstName());
		assertEquals("Balding", e2.getSurname());
	}
	/**
     * The sixth test, test6, will compare the first names of the two employees,
     * and the test will pass if their first names are not the same.
     */
	@Test
	public void test6() { 
		
		e1.setFirstName("Hillary");
		e2.setFirstName("Tom");

		assertFalse("Failure: should be false", e1.getFirstName() == e2.getFirstName());
	}
	/**
     * The seventh test, test7, will compare the first names of the two employees,
     * and the test will pass if their first names are the same.
     */
	@Test
	public void test7() { 
		
		e1.setFirstName("Hillary");
		e2.setFirstName("Hillary");

		assertFalse("Failure: should be false", e1.getFirstName() != e2.getFirstName());
	}
	/**
     * The eighth test, test8, will check if the employee actually have names.
     */
	@Test
	public void test8() { 
		
		e1.setYearOfJoining(10);
		e2.setYearOfJoining(10);

		assertNotNull("should not be null", e1.getFirstName());
		assertNotNull("should not be null", e1.getFirstName());
	}
	@Test
	/**
     * The ninth test, test9, will make sure there are no duplicates between the employees.
     */
	public void test9() {
		
		assertNotSame("should not be the same", e1, e2 );
	}
}
