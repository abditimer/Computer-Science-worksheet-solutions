package Ex1;

/**
 * This is a program that solves Exercise 1 on Worksheet 5 given by Manfred.
 * <p>
 * This program has been built to check whether there are gaps in the sukoku.
 * 
 * @author Abdikhaliq Timer
 * @version 22/11/16
 *
 */
public class Sudoku {
	/**
	 * An empty array is needed in order to build the graphical sudoku around.
	 */
	private int[][] array;

	/**
	 * This is a constructor that creates Sudoku objects.
	 * 
	 * @param array
	 *            A 2d Array which will be turned into a sudoku object.
	 */
	public Sudoku(int[][] array) {
		this.array = array;
	}

	/**
	 * A getter that will get the sudoku objects array
	 * 
	 * @return the array of the sudoku object
	 */
	public int[][] getArray() { // getter
		return array;
	}

	/**
	 * This is a setter, that has been included as it will be needed in later
	 * sections within the exercises
	 * 
	 * @param array
	 *            this will set a new array as the objects array.
	 */
	public void setArray(int[][] array) {
		this.array = array;
	}

	/**
	 * The toString method will print the Sudoku as an array, but including the
	 * detail shown in worksheet 5.
	 */
	public String toString() {
		/**
		 * The largeBorder and smallBorder will be needed within the loops,
		 * hence initialising them as strings at this stage will keep the code
		 * simple.
		 */
		String largeBorder = "++===+===+===++===+===+===++===+===+===++";
		String smallBorder = "++---+---+---++---+---+---++---+---+---++";
		String sudoku = ""; // This is the final string sudoku where the array
							// points will be added to the graphical aspects
		/**
		 * Loops around rows for the array.
		 * <p>
		 * This will now loop over the individual rows, allowing us to build
		 * around this array
		 */
		for (int i = 0; i < array.length; i++) {
			/**
			 * prints the borders above each row.
			 * <p>
			 * The following code will print all the borders in the graphical
			 * Sudoku, including the larger and smaller borders.
			 */
			if (i % 3 == 0) {
				sudoku += largeBorder + "\n";
			} else {
				sudoku += smallBorder + "\n";
			}
			/**
			 * Nested for loop that loops around columns.
			 * <p>
			 * The following will now loop around the columns, whilst nested
			 * within the rows checking for loop.
			 */
			for (int j = 0; j < array[0].length; j++) {
				/**
				 * Checks the numbers within the array for 0's.
				 * <p>
				 * The following now checks to see if the array has an empty
				 * slot, if there is one, it gets replaced with a space. If not,
				 * it will be left the same.
				 */
				String filled;
				if (array[i][j] == 0) {
					filled = " ";
				} else {
					filled = Integer.toString(array[i][j]);
				}
				/**
				 * this creates the individual rows, filling the spaces with the
				 * correct numbers.
				 * <p>
				 * This method is mainly used to print each individual row, as
				 * it considers for both the case where there is a number, and
				 * if there is a 0. Also, there is a different in the rows, some
				 * have || whereas others have |.
				 */
				if (j % 3 == 0) {
					sudoku += "|| " + filled + " ";
				} else {
					sudoku += "| " + filled + " ";
				}
			}
			/**
			 * at the end of each row, it now starts the new row and ends the
			 * previous row with the border part.
			 */
			sudoku += "||" + "\n";
		}
		sudoku += largeBorder + "\n";

		return sudoku;
	}

	/**
	 * The method isFilled, checks whether all fields are filled within the
	 * array.
	 * 
	 * @param array
	 *            This is the array which needs to be checked, whether all of
	 *            its values are between 1-9.
	 * @return It will return a boolean; true or false. Either all elements are
	 *         filled in the Sudoku, or they are not.
	 */
	public static boolean isFilled(int[][] array) {
		
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				/**
				 * Now I check wether the value at each position of the array is
				 * more than 9, and less than 1.
				 */
				if (array[i][j] < 1 || array[i][j] > 9) {

					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] e1 = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
				{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
				{ 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
		Sudoku sudoku = new Sudoku(e1);
		System.out.print(sudoku.toString());
		System.out.println(isFilled(e1));
	}

}
