import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is a private test to check whether our ParityCorrection program is
 * correct.
 * <p>
 * Hence, this program is checking whether the checking program is correctly
 * working.
 *
 * @author Abdikhaliq Timer
 * @version 30/10/2016
 */

public class ParityCorrectionTest {
	/**
	 * The first test is to check a simple matrix that only has 0s, hence it
	 * should return a replica and nothing should change. All the other tests
	 * check various different matrixes, I have indicated the position of the
	 * wrong bit, that needs to be changed by my program ParityCorrection in
	 * order to create the correct matrix. Hence, all the tests, excluding the
	 * first one, are all used to make sure the program is running correctly.
	 */
	@Test
	public void test1() {

		// correct matrix
		int[][] test1 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		// expected incorrect rows and columns
		int expected_rows = -1;
		int expected_cols = -1;

		int actual_rows = ParityCorrection.findRow(test1);
		int actual_cols = ParityCorrection.findColumn(test1);
		assertEquals(expected_rows, actual_rows);
		assertEquals(expected_cols, actual_cols);

		int[][] expected_corrected_matrix = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		int[][] actual_corrected_matrix = ParityCorrection.correctMatrix(test1);

		assertArrayEquals(expected_corrected_matrix, actual_corrected_matrix);

	}

	@Test
	public void test2() {
		/* incorrect in row 2, column 3 */
		int[][] test2 = { { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 1 } };

		// expected incorrect rows and columns
		int expected_rows = 2;
		int expected_cols = 3;

		int actual_rows = ParityCorrection.findRow(test2);
		int actual_cols = ParityCorrection.findColumn(test2);
		assertEquals(expected_rows, actual_rows);
		assertEquals(expected_cols, actual_cols);

		int[][] expected_corrected_matrix = { { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 1, 1, 0, 0 } };

		int[][] actual_corrected_matrix = ParityCorrection.correctMatrix(test2);

		assertArrayEquals(expected_corrected_matrix, actual_corrected_matrix);

	}

	@Test
	public void test3() {
		/* incorrect in row 3, column 4 */
		int[][] test3 = { { 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1 } };

		// expected incorrect rows and columns
		int expected_rows = 3;
		int expected_cols = 4;

		int actual_rows = ParityCorrection.findRow(test3);
		int actual_cols = ParityCorrection.findColumn(test3);
		assertEquals(expected_rows, actual_rows);
		assertEquals(expected_cols, actual_cols);

		int[][] expected_corrected_matrix = { { 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 1, 0 } };

		int[][] actual_corrected_matrix = ParityCorrection.correctMatrix(test3);

		assertArrayEquals(expected_corrected_matrix, actual_corrected_matrix);

	}

	@Test
	public void test4() {
		/* incorrect in row 0, column 0 */
		int[][] test3 = { { 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 0, 0, 0 } };

		// expected incorrect rows and columns
		int expected_rows = 0;
		int expected_cols = 0;

		int actual_rows = ParityCorrection.findRow(test3);
		int actual_cols = ParityCorrection.findColumn(test3);
		assertEquals(expected_rows, actual_rows);
		assertEquals(expected_cols, actual_cols);

		int[][] expected_corrected_matrix = { { 0, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 0, 0, 0 } };

		int[][] actual_corrected_matrix = ParityCorrection.correctMatrix(test3);

		assertArrayEquals(expected_corrected_matrix, actual_corrected_matrix);

	}

}
