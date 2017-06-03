import java.util.Arrays;

/**
 * This is a program that checks the parity of a matrix, for example, by
 * comparing the sum of the row before the final index position of the row, and
 * comparing it to that digit in that location.
 * <p>
 * This program is similar to the work provided in the previous Exercise, on
 * Exercise 4 of Worksheet 3, which you can find by refering to the file named
 * Parity(.java).
 * 
 * @author Abdikhaliq Timer
 * @version 30/10/16
 */
public class ParityCorrection {
	/**
	 * This initial method is for looking at the values within each row, but
	 * importantly excluding the final position of the individual rows. This
	 * allows us to check wether the parity is correct for each row, and then
	 * finally compare our sum of the row, to that final index position.
	 * 
	 * @param a
	 *            This parameter is the array that we will be checking.
	 * @return This method checks to make sure the rows within the matrix adhere
	 *         to the parity laws we have defined, and if they are correct it
	 *         returns -1, however, if it is not correct, it will return the
	 *         location of the incorrect column.
	 */
	public static int findRow(int[][] a) {
		int incorrectRows = -1;
		for (int i = 0; i < a.length; i++) {
			int sumOfRows = 0;
			for (int j = 0; j < a[0].length - 1; j++) {
				sumOfRows += a[i][j];
			}
			if (!(sumOfRows % 2 == a[i][a[0].length - 1])) { // This does the
																// parity check.
				incorrectRows = i;
				return incorrectRows;
			}
		}
		return incorrectRows;
	}

	/**
	 * This method is similar to the findRow method, however, it returns the
	 * incorrect column
	 * 
	 * @param a
	 *            The parameter 'a' is the matrix for which we want to check the
	 *            columns.
	 * @return This method will return -1 if all rows meet the parity laws, if
	 *         not, it will return the position of the incorrect Column.
	 */
	public static int findColumn(int[][] a) { // finds wrongfully formed column
		int wrongColumn = -1;
		for (int j = 0; j < a[0].length; j++) {
			int sumOfColumn = 0;
			for (int i = 0; i < a.length - 1; i++) {
				sumOfColumn += a[i][j];
			}
			if (!(sumOfColumn % 2 == a[a.length - 1][j])) {
				wrongColumn = j;
				return wrongColumn;
			}

		}
		return wrongColumn;
	}

	/**
	 * This method is the one that will tell us whether our entire matrix is
	 * correct or not. So it uses the other two methods to determine whether the
	 * matrix follows all the parity laws, and if not, it will tell us the exact
	 * location of the incorrect row and column.
	 * 
	 * @param a
	 *            This is the array we want to check, hence we check if 'a' is a
	 *            'correctMatrix'.
	 * @return We return a matrix, unchanged if it already follows all the
	 *         parity laws, if it does not, we return the corrected matrix.
	 */
	public static int[][] correctMatrix(int[][] a) {
		if (findRow(a) != -1 || findColumn(a) != -1) {
			int row = findRow(a);
			int column = findColumn(a);
			if (a[row][column] == 0) {
				a[row][column] = 1;
			} else {
				a[row][column] = 0;
			}
		}
		return a;

	}

}
