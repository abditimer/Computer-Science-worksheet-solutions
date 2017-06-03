package Ex1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The following program is a Sudoke Checker.
 * <p>
 * The program was written for a 9 x 9 Sudoku. It analysis three key elements:
 * <b> Rows, Columns and subsquares. </b>
 * 
 * @author Abdikhaliq Timer
 * @version 29/11/16
 *
 */
public class SudokuCheck {
	/**
	 * This method checks whether a given sudoku of size 9 x 9 satisfies the
	 * conditions.
	 * <p>
	 * The method is split into three main checking components, a method that
	 * checks to see if valid inputs have been inserted into each row, then the
	 * same check again however for the columns, which is then followed by a
	 * check that checks the individual sub sqaures, of size 3 x 3.
	 * <p>
	 * The check method will return a 2d array of boolean values that looks like
	 * this:
	 * <p>
	 * [[true, true, true, true, true, true, true, true, true],
	 * <p>
	 * [true, true, true, true, true, true, true, true, true],
	 * <p>
	 * [true, true, true, true, true, true, true, true, true]]
	 * <p>
	 * <p>
	 * 
	 * @param sudoku
	 *            The sudoku which you want to check is passed through as a
	 *            parameter, which is in type of Sudoku.
	 * @return This method returns an array of size 3 x 9, which the rows
	 *         representing the correctness of the rows, columns or the sub
	 *         squares.
	 */
	public static boolean[][] check(Sudoku sudoku) {
		/**
		 * the gets the array of the sudoku object
		 */
		int[][] newSudoku = sudoku.getArray();
		/**
		 * finalBoolean is a 2d array that contains all true. If the program
		 * finds the check to be false, it will change the specific locations
		 * within the finalBoolean to false.
		 */
		boolean[][] finalBoolean = { { true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true } };
		/**
		 * I have created an empty single array of numbers which I can compare
		 * my checks.
		 */
		int[] correctNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] toCheck = new int[9];
		int counterRow = 0;
		int counterCol = 0;
		int counterBox = 0;
		/**
		 * The following will check the individual rows within the array
		 */

		for (int i = 0; i < 9; i++) { // Loop around the rows
			for (int j = 0; j < 9; j++) { // Loop around the columns
				/**
				 * For the rows, we want to check each value within the rows
				 * against the row of numbers we created. We begin by storing
				 * the row of numbers for each individual row within an array
				 * caled toCheck
				 */
				toCheck[j] = newSudoku[i][j];
			}
			/**
			 * Before using the array, below we sort the list in order to get
			 * the numbers sorted
			 */
			Arrays.sort(toCheck);
			/**
			 * The following does the final stage of needed for this program, it
			 * stores whether each individual array of values, and checks them
			 * against the correct numbers which I have. If they are not the
			 * same, this creates a 'false', which later in the program will be
			 * returned with in a matrix.
			 */
			finalBoolean[0][counterRow] = Arrays.equals(toCheck, correctNumbers);
			counterRow++;
		}
		/**
		 * The following checks the columns for the sudoku.
		 */
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				toCheck[i] = newSudoku[i][j];
			}
			Arrays.sort(toCheck);
			finalBoolean[1][counterCol] = Arrays.equals(toCheck, correctNumbers);
			counterCol++;
		}
		/**
		 * The following checks the 3x3 sudoku, this method is similar to the
		 * row and column check, however when I created the program, I had to
		 * write out by hand how I imagined the rows and columns interacting
		 * when we wanted to check each of the 3x3 squares.
		 */
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				for (int k = 0; k < 9; k++) {
					/**
					 * Again, like before, we are not storing the values into
					 * the array toCheck. Hence, the equal sign this time
					 * represents that the array toCheck will change depending
					 * on input.
					 * <p>
					 * The maths behind this is that it is not transfering the
					 * values, of the individuals squares first value, and hence
					 * it will iterate through the small box, getting all the
					 * values within each subsquare, and storing it within
					 * toCheck.
					 */
					toCheck[k] = newSudoku[i + (k % 3)][j + (k / 3)];
				}
				/**
				 * Now that we have the array with all the stored values, we now
				 * want to find the numbers which are repeating and seperate
				 * them. This help the program to identify the numbers which are
				 * missing from the Sudoku object.
				 */
				int[] check = IntStream.of(toCheck).distinct().toArray();
				/**
				 * Once we have found all the numbers which are within each
				 * subsquare, and the distinct allowed us to remove any
				 * duplicates, we now need to make sure that the numbers are in
				 * the correct order. This will hence leave an array of numbers
				 * that are in order, for example, if the numbers within the
				 * subsquare was 1 to 8, with an extra 8, the distinct method
				 * removes that double 8, and the sort will sort the remaining 8
				 * numbers from smallest to largest.
				 */
				Arrays.sort(check);
				/**
				 * Now that we have all the correct numbers in order, we can now
				 * compare the array of numbers from each of the subsquare, and
				 * see if they are the same as the numbers in our
				 * correctNumbers, in which we know the numbers are in order
				 * from 1 to 9. Hence, this will provide us with one array that
				 * will be stored within the finalBoolean array, and it will
				 * allow us to compare and get a boolean true or false whether
				 * all the correct 1 to 9 values are in the subsquare.
				 */
				finalBoolean[2][counterBox] = Arrays.equals(check, correctNumbers);
				/*
				 * The check has now been completed, this will now end the loop,
				 * but before we do, we need to make sure that the counterBox is
				 * incremeneted, as our loop is looping through the small
				 * subsquares, which I have called a counterBox.
				 */
				counterBox++;
			}
		}
		/**
		 * Hence, for each subsquare, a boolean value is returned, which will be
		 * returned.
		 */
		return finalBoolean;
	}

	public static void main(String[] args) {

		int[][] e1 = { { 0, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
				{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
				{ 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

		Sudoku checkThisSudoku = new Sudoku(e1);
		System.out.println(Arrays.deepToString(check(checkThisSudoku)));

	}
}