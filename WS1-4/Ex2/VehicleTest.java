import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is jUnit tests that tests the solutions to Ex2, including Vehicle and
 * Car.
 * <p>
 * There are a number of different tests within this JUnit test, I test for
 * different car types; different maximum speeds and occupants.
 * 
 * @author Abdikhaliq Timer
 * @version 14/10/12;
 *
 */
public class VehicleTest {

	private Vehicle vehicle;

	/**
	 * The following tests the vehicle class, to make sure the correct string is
	 * printed.
	 */
	@Test
	public void ex2PublicTest1() {
		vehicle = new Vehicle(60.0, 3);

		String expected = "The vehicle has a maximal speed of 60.0 km/h. " + "It carries 3 passengers.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest2() {
		vehicle = new Vehicle(99.0, 7);

		String expected = "The vehicle has a maximal speed of 99.0 km/h. " + "It carries 7 passengers.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest13() {
		vehicle = new Vehicle(45.0, 8);

		String expected = "The vehicle has a maximal speed of 45.0 km/h. " + "It carries 8 passengers.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest4() {
		vehicle = new Vehicle(12345.0, 9876);

		String expected = "The vehicle has a maximal speed of 12345.0 km/h. " + "It carries 9876 passengers.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	/**
	 * These tests make sure the Car class correctly inherit from the superclass
	 * vehicle, hence printing the correct string.
	 */
	@Test
	public void ex2PublicTest5() {
		vehicle = new Car(60.0, 3, 1.1);

		String expected = "The vehicle has a maximal speed of 60.0 km/h. " + "It carries 3 passengers. "
				+ "Its fuel consumption is 1.1 l/100km.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest6() {
		vehicle = new Car(43.0, 9, 27.5);

		String expected = "The vehicle has a maximal speed of 43.0 km/h. " + "It carries 9 passengers. "
				+ "Its fuel consumption is 27.5 l/100km.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest7() {
		vehicle = new Car(34.7, 1, 9.9);

		String expected = "The vehicle has a maximal speed of 34.7 km/h. " + "It carries 1 passenger. "
				+ "Its fuel consumption is 9.9 l/100km.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest8() {
		vehicle = new Car(8.0, 5, 7.5);

		String expected = "The vehicle has a maximal speed of 8.0 km/h. " + "It carries 5 passengers. "
				+ "Its fuel consumption is 7.5 l/100km.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}
}
