package Ex4;

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

	private Employee emp1;
	
	@Before
	public void setUp() {
		emp1 = new Employee("John", 20.7, 25);
	}
	
	
	@Test
	public void test1() {
	
		emp1.setName("Jim");
		emp1.setHourlySalary(30.4);
		emp1.setNumberOfHours(29);
		
		assertEquals("Jim",emp1.getName());
		assertEquals(30.4,emp1.getHourlySalary(),0.0000001);
		assertEquals(29,emp1.getNumberOfHours());
	}

	
	@Test
	public void test2() {
	
		emp1.setHourlySalary(40.4);
		emp1.setNumberOfHours(29);
		
		assertEquals(1171.6, emp1.monthlySalary(),0.000001);
	}

	@Test
	public void test3() {
	
		emp1.setHourlySalary(30.5);
		emp1.setNumberOfHours(52);
		
		assertEquals(1586, emp1.monthlySalary(),0.000001);
	
		emp1.increaseSalary(5.4);
	
		assertEquals(1671.644, emp1.monthlySalary(),0.000001);
	
	}
	@Test
	public void test4() {
	
		emp1.setHourlySalary(30.5);
		emp1.setNumberOfHours(52);
		
		emp1.increaseSalary(5.4);
		emp1.increaseSalary(10.5);
		assertEquals(1847.166619, emp1.monthlySalary(),0.000001);
	
	}

}
