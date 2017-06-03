import java.util.Arrays;

/**
 * This program takes a 2D array of size (n x m) and returns (n+1) x (m+1) with
 * parity bits added.
 * <p>
 * This program helps in detecting data mistakes when transferring data. Parity
 * bits are used in order to be able to detect and correct mistakes. This means
 * that the original matrix gets an increase of one row and one column, whilst
 * adhering to the parity law.
 * 
 * @author Abdikhaliq Timer
 * @version 30/10/16
 */
public class Parity {
	/**
	 * addParity has three main parts; constructing a template array, filling it
	 * with the content of the original array, and then correctly filling in the
	 * parity bits.
	 * 
	 * @param a
	 *            The array a will be increased by adding an extra row and
	 *            column, whilst abiding by the parity rules mentioned below.
	 * @return The new matrix with the added parity bits.
	 */
	public static int[][] addParity(int[][] a) {
		/**
		 * I have begun by declaring my Array, this allows the program to look
		 * at the original size of the old matrix, and create a new template
		 * based of that size. It takes the number of rows and columns, and adds
		 * 1 to each one. Creating a matrix with one extra row and one extra
		 * column.
		 */
		int[][] extended = new int[a.length + 1][a[0].length + 1];
		/**
		 * This first for loop transfers the data from the old matrix, and
		 * copies it over to the new matrix. This will make it easier to
		 * determine the parity bits.
		 */
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				extended[i][j] = a[i][j];
			}
		}
		/**
		 * The first loop is used to correctly add on the new row, as its
		 * important to do the row before the column. The loop will sum the
		 * rows, by taking the looping over the entirety of i before returning
		 * to the next j.
		 */
		for (int j = 0; j < extended[0].length; j++) { // deals with x
			int sumOfColumns = 0;
			for (int i = 0; i < extended.length; i++) {
				sumOfColumns += extended[i][j];
			}
			/**
			 * If the sum of the row, not including the final index position, is
			 * even, the even number modulo 2 will return a 0 in all even
			 * numbers. This allows me to check if the sum is even, if it is
			 * indeed 0.
			 */
			if (sumOfColumns % 2 == 0) { // if the sumOfRow is even, then it
											// should
											// be 0, this checks if it is.
				extended[extended.length - 1][j] = 0; // if sumOfRow is even
			} else
				extended[extended.length - 1][j] = 1; // if sumOfRow is odd
		}
		/**
		 * This does the exact same as the previous loop, but only for columns
		 * instead of rows
		 */
		for (int i = 0; i < extended.length; i++) {
			int sumOfRows = 0;
			for (int j = 0; j < extended[0].length; j++) {
				sumOfRows += extended[i][j];
			}
			if (sumOfRows % 2 == 0) {
				extended[i][extended[0].length - 1] = 0; // if sumOfColumns is
															// even
			} else
				extended[i][extended[0].length - 1] = 1; // if sumOfColumns is
															// odd
		}
		return extended;
	}

	/**
	 * checkParity will be used to check if a 2d array has the correct parity
	 * bits within its array. The way it is checked is by summing the values
	 * excluding the parity bits, and then checking the sum against the parity
	 * bits. If they match up, than this will return true, if not it will return
	 * false.
	 * 
	 * @param a
	 *            The 2D array that needs to be checked, whether the parity bits
	 *            are correct or not.
	 * @return If the Parity bits are correct or not.
	 */
	public static boolean checkParity(int[][] a) {

		boolean rowsCheck = false;
		boolean columnsCheck = false;

		for (int i = 0; i < a.length; i++) {
			int sumOfRows = 0;
			for (int j = 0; j < a[0].length - 2; j++) {
				sumOfRows += a[i][j];
			}
			if (sumOfRows % 2 == 0 && a[i][a[0].length - 1] == 0) {
				rowsCheck = true;
			}
		}

		for (int j = 0; j < a[0].length; j++) {
			int sumOfColumns = 0;
			for (int i = 0; i < a.length; i++) {
				sumOfColumns += a[i][j];
			}
			if (sumOfColumns % 2 == 0 && a[a.length - 1][j] == 0) {
				columnsCheck = true;
			}
		}
		/**
		 * A final if loop to return a final true or false depending whether the
		 * entire matrix has all the correct rows and columns.
		 */
		if (rowsCheck == true && columnsCheck == true) {
			return true;
		} else
			return false;
	}

}
