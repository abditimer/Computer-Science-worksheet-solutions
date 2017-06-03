package Ex1;

import java.io.*;

/**
 * This program is a file reader, which has been specifically been written to 
 * read in some numbers, that will fill a Sudoku.

 * @author Abdikhaliq Timer
 * @version 29/11/16
 *
 */
public class SudokuRead {
	/**
	 * This method reads in a Sudoku from a file.
	 * <p>
	 * The following method readSudoku throws exceptions, if the file is not
	 * accessible and if the input is not a number between 1 and 9. The program
	 * contains only one method which reads in the file, and hence produces a
	 * printed version of the Sudoku, using the Sudoku toString method to print
	 * the sudoke with the different borders for better visualisation.
	 * 
	 * 
	 * @param fileName
	 *            This is the filename which will be read in, and turned into a
	 *            Sudoku to play with!
	 * @return It will return a Sudoku object, which can be viewed, and with a
	 *         later program, be interacted with.
	 * @throws IllegalArgumentException
	 *             It throws two exception; when a file cant be read, and an
	 *             input exception.
	 * @throws IOException
	 *             This is the second type of exception that is thrown.
	 */
	public static Sudoku readSudoku(String fileName) throws IllegalArgumentException, IOException {
		/**
		 * An empty 2d array which we will copy the read in file into, whilst
		 * also creating a String which will be used to store the entire string
		 * of numbers, of each line into.
		 */
		String readString;
		int[][] newSudoku = new int[9][9];
		/**
		 * The following is where I will <b>try<\b> and read in a file, by using
		 * both File reader and buffer reader. This method was obtained via Java
		 * 7 code using try-with-resource patterns.
		 */
		try (Reader reader = new FileReader(fileName); 
				BufferedReader inputSudoku = new BufferedReader(reader)) {
			/**
			 * We will need a counter that will tell us which row we are working
			 * on, so the program will know when to stop reading in lines, which
			 * is after 9 lines have been read in. hence, within the while loop,
			 * the rows will be incremented untill it rows reaches our needed 9
			 * lines (for the 9 rows within an array).
			 */
			int rows = 0;
			/**
			 * The while loops checks two things; if the readin line contains
			 * anything, and to make sure the counter stays below 9. What this
			 * will tell us is two things:
			 * <ul>
			 * <li><i> do the following code only if the line contains something
			 * </i> <i> only take 9 lines from the file, 9 lines from the sudoku
			 * </i></li>
			 * </ul>
			 */
			while ((readString = inputSudoku.readLine()) != null && rows < 9) {
				/**
				 * The program at this stage will check to make sure that there
				 * are 8 or more spaces filled within the array
				 */
				if (readString.length() < 9) {

				} else {
					for (int j = 0; j < 9; j++) {
						/**
						 * This will now allow me to take each individual
						 * character within the file, and convert each character
						 * within each of those positions and convert it into an
						 * int. Hence, its a conversion.
						 */
						int conversion = ((int) readString.charAt(j)) - (int) '0';
						/**
						 * The following is the check to find whether the string
						 * which has been read contains a space, and if it does,
						 * to set its array position to 0.
						 */
						if (readString.charAt(j) == ' ') {
							newSudoku[rows][j] = 0;
							/**
							 * The following checks if there instead is a number
							 * between 1 and 9, and if there is, it sets the
							 * correct column position and row position within
							 * the array. meaning that the actual array will now
							 * take in only the values that are between 1 and 9.
							 */
						} else if (conversion < 10 || conversion > 0) {
							newSudoku[rows][j] = conversion;
							/**
							 * Hence, if its not a space, or a number between 1
							 * and 9, we throw an exception
							 */
						} else {
							throw new IllegalArgumentException(
									"The file must containt 9 lines of numbers, please check the file.");
						}

					}
				}
				/**
				 * This makes sure only 9 lines are read.
				 */
				rows++;
			}
			/**
			 * this lets the sudoku stop reading in new files, needed or else an
			 * exception would be thrown.
			 */
			inputSudoku.close();
			/**
			 * Now I have created a new Sudoku object using the final Sudoku
			 * which gets changed when the file has been read, hence printing
			 * the Sudoku.
			 */
			Sudoku readInSudoku = new Sudoku(newSudoku);
			return readInSudoku;
			/**
			 * As we are reading in a file, we must make sure we catch any
			 * exceptions.
			 */
		} catch (IllegalArgumentException | IOException e) {
			return null;
		}

	}

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		System.out.println(readSudoku("Sudoku-ex1.txt"));
	}
}
