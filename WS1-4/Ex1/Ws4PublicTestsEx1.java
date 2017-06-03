package Ex1;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Public tests for Exercise 1 on Worksheet 4. They test the getMeasure()
 * methods for invoices and patients. Furthermore, the mean and standard
 * deviation for ArrayList of type Measurable.
 * <p>
 * There are a large number of tests below to check various calculations to make
 * sure that the standard deviation is working correctly, as it is a multistep
 * computation that requires more checks than the mean.
 *
 * @author Abdikhaliq Timer
 * @version 14/10/12;
 *
 */
public class Ws4PublicTestsEx1 {
	/**
	 * This is a public test that checks invoice, using getMeasure, to check if
	 * the right measure of the invoice is returned.
	 */
	@Test
	public void ex1PublicTest1() {
		Invoice invoice = new Invoice("123456789", "11-22-33", 2000);

		double expected = 2000;
		double actual = invoice.getMeasure();
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	/**
	 * This
	 */
	@Test
	public void ex1PublicTest2() {
		Patient patient = new Patient("Abdikhaliq Timer", 88, 99.9);

		double expected = 99.9;
		double actual = patient.getMeasure();
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest3() {

		ArrayList<Measurable> invoices = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			invoices.add(new Invoice("14525489", "77-95-62", i * 1));
		}

		double expected = 50;
		double actual = Statistics.mean(invoices);
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest4() {

		ArrayList<Measurable> patients = new ArrayList<>();

		for (int i = 1; i <= 3; i++) {
			patients.add(new Patient("Tom Tommas", 22, i));
		}

		double expected = 0.8164965809;
		double actual = Statistics.standardDeviation(patients);
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest5() {

		ArrayList<Measurable> patients = new ArrayList<>();

		for (int i = 2; i <= 8; i += 2) {
			patients.add(new Patient("Abraham Trump", 12, i));
		}

		double expected = 2.236067977;
		double actual = Statistics.standardDeviation(patients);
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest6() {

		ArrayList<Measurable> patients = new ArrayList<>();

		for (int i = 2; i <= 8; i += 2) {
			patients.add(new Patient("Abraham Trump", 12, i));
		}

		double expected = 5;
		double actual = Statistics.mean(patients);
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest7() {

		ArrayList<Measurable> invoices = new ArrayList<>();

		for (int i = 1; i <= 7; i++) {
			invoices.add(new Invoice("14525489", "77-95-62", i));
		}

		double expected = 4;
		double actual = Statistics.mean(invoices);
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest8() {

		ArrayList<Measurable> invoices = new ArrayList<>();

		for (int i = 2; i <= 8; i += 2) {
			invoices.add(new Invoice("14525489", "77-95-62", i));
		}

		double expected = 5;
		double actual = Statistics.mean(invoices);
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest9() {

		ArrayList<Measurable> invoices = new ArrayList<>();

		for (int i = 5; i <= 15; i++) {
			invoices.add(new Invoice("14525489", "77-95-62", i));
		}

		double expected = 3.16227766;
		double actual = Statistics.standardDeviation(invoices);
		double tolerance = 1e-8;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest10() {

		ArrayList<Measurable> invoices = new ArrayList<>();

		for (int i = 12; i <= 22; i++) {
			invoices.add(new Invoice("14525489", "77-95-62", i));
		}

		double expected = 3.16227766;
		double actual = Statistics.standardDeviation(invoices);
		double tolerance = 1e-7;

		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest11() {

		ArrayList<Measurable> invoices = new ArrayList<>();

		for (int i = 38; i <= 40; i++) {
			invoices.add(new Invoice("14525489", "77-95-62", i));
		}

		double expected = 0.81649658092773;
		double actual = Statistics.standardDeviation(invoices);
		double tolerance = 1e-7;

		assertEquals(expected, actual, tolerance);
	}
}
