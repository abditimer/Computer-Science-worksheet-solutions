package Ex1;

import java.io.IOException;
import java.util.Scanner;

/**
 * The following program is an extension of Sudoku, it allows a user to
 * interactively play with Sudoku.
 * 
 * @author Abdikhaliq Timer
 * @version 29/11/16
 *
 */
public class SudokuInteractive extends Sudoku {
	/**
	 * This is a method that allows a user to play Sudoku. This is the
	 * constructor for the SudokuInteractive class, which inherits from Sudoku.
	 * 
	 * @param array
	 *            This is a 2d array which will be turned into a
	 *            sudokuInteractive object.
	 */
	public SudokuInteractive(int[][] array) {
		super(array);

	}

	/**
	 * This is the Overrided String, which will allow the interactiveSudoku to
	 * print a unique Sudoku to the users screen, which will include reference
	 * points of x and y.
	 */
	@Override
	public String toString() {
		/**
		 * Four strings have been initialised: numbers will be the header
		 * reference points for the user whilst largeBorder and smallBorder will
		 * draw the borders between the array depending on where the correct
		 * border should go. Whilst also initialising the sudoku string which
		 * this method will return.
		 */
		String numbers = "     1   2   3    4   5   6    7   8   9   ";
		String largeBorder = "  ++===+===+===++===+===+===++===+===+===++";
		String smallBorder = "  ++---+---+---++---+---+---++---+---+---++";
		String sudoku = "";
		int counter = 1;

		/**
		 * The sudoku will need a reference header above the actual sudoku.
		 */

		sudoku += numbers + "\n";

		for (int i = 0; i < getArray().length; i++) {
			/**
			 * prints the borders above each row.
			 * <p>
			 * The following code will print all the borders in the graphical
			 * Sudoku, including the larger and smaller borders.
			 */
			if (i % 3 == 0) {
				sudoku += largeBorder + "\n" + counter + " ";
			} else {
				sudoku += smallBorder + "\n" + counter + " ";
			}
			counter++;
			/**
			 * Nested for loop that loops around columns.
			 * <p>
			 * The following will now loop around the columns, whilst nested
			 * within the rows checking for loop.
			 */
			for (int j = 0; j < getArray()[0].length; j++) {
				/**
				 * Checks the numbers within the array for 0's.
				 * <p>
				 * The following now checks to see if the array has an empty
				 * slot, if there is one, it gets replaced with a space. If not,
				 * it will be left the same.
				 */
				String filled;
				if (getArray()[i][j] == 0) {
					filled = "   ";
				} else if (getArray()[i][j] > 100) {
					filled = " " + Integer.toString(getArray()[i][j] - 1000000) + " ";
				} else {
					filled = "*" + Integer.toString(getArray()[i][j]) + "*";
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
					sudoku += "||" + filled + "";
				} else {
					sudoku += "|" + filled + "";
				}
			} /**
				 * at the end of each row, it now starts the new row and ends
				 * the previous row with the border part.
				 */
			sudoku += "|| " + "\n";

		}
		sudoku += largeBorder + "\n";

		return sudoku;
	}

	/**
	 * The following method is the one which will allow the user to play a
	 * specified file.
	 * <p>
	 * The file then be read, and converted to a String, the user will then have
	 * three options:
	 * <ul>
	 * <li>To input a rowcolumn:value, this will then allow the user to put in a
	 * value into each space.</li>
	 * <li>To exit the game, by typing 'exit' the user will terminate the game.
	 * </li>
	 * <li>To restart the game, the user can type 'restart', which will restart
	 * the game.</li>
	 * </ul>
	 * 
	 * @param file
	 *            This is the file that the sudoku will allow the user to play
	 * @throws IllegalArgumentException
	 *             It catches any illegal arguments
	 * @throws IOException
	 *             Any Input and output excpetions will be caught through this
	 *             method.
	 */
	public static void play(String file) throws IllegalArgumentException, IOException {
		/**
		 * I begin by printing a line to let the user know that the game has
		 * begun.
		 */
		System.out.println(
				"Welcome to Sudoku! I have read your file, and I present you with a Sudoku. Have fun, and goodluck!");
		/**
		 * I will need two Sudokus; one which the user will change and modify
		 * whilst playing, and the other to store so when the user wants to
		 * reset his Sudoku, it will let him.
		 */
		Sudoku copiedArray = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
		Sudoku originalArray = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
		/**
		 * Once the Sudoku objects of an original and copied array have been
		 * made, I will then proceed to print the original, but the user will
		 * only
		 */
		System.out.print(originalArray);

		System.out.println("Please enter where you want to move to in the format 'rowcolumn:value'");

		Scanner in = new Scanner(System.in);
		int row, col, val;

		/**
		 * Untill the user uses the command to exit, by typing exit, the program
		 * will keep running. Hence, a game that allows the user to keep
		 * playing.
		 */

		while (true) {
			String input = in.next();
			/**
			 * The input by the user must be checked, hence I have 4 main
			 * sections:
			 * <ul>
			 * <li>If the user types in a valid command, we input the number
			 * into the sudoku.</li>
			 * <li>if the user tries to input a command where there already
			 * exists a number, we must tell the user to try again</li>
			 * <li>If the user wishes to exit, it allows the user to exit</li>
			 * <li>If the user wishes to restart, an option to restart</li>
			 * </ul>
			 * 
			 * The first if statement checks to see if the users input matches
			 * to see if its in the correct input range, for the row, column and
			 * box.
			 */

			if (input.matches("[1-9][1-9]:[1-9]")) {
				/**
				 * The following identifies each of the different rows, columns
				 * and values which have been given to the user. The following
				 * code is used in order to get the specific position of each
				 * character within the String which was inputted and hence get
				 * the positioning for each of the value which the user would
				 * like to move. the row for example, identifies the position of
				 * the first character given to the console, and then removes
				 * one as our array is from 0 to 8, in terms of the index
				 * positions, instead of the 1 - 9 indicated.
				 */
				row = ((int) input.charAt(0)) - (int) '1';
				col = ((int) input.charAt(1)) - (int) '1';
				val = ((int) input.charAt(3)) - (int) '0';
				/**
				 * The following if else statements identify exactly what the
				 * user is doing. it starts with checking whether the position
				 * which was entered by the user is empty in the array.
				 */
				if (originalArray.getArray()[row][col] == 0) {
					/**
					 * If the position the user entered is empty in the array,
					 * we then want to change the array of our template array,
					 * and change the actual value stored. Hence, this will
					 * print out the inputed value.
					 */
					copiedArray.getArray()[row][col] = val + 1000000;
					Sudoku modifiedSudoku = new SudokuInteractive(copiedArray.getArray());
					System.out.println(modifiedSudoku);
					System.out.println("Have another go, please enter another value in the same format: ");
				} else {
					System.out.println("This spot is already taken, please try again:  ");

				}

				/**
				 * If the input is equal to exit, we want to program to
				 * terminate.
				 */
			} else if (input.equals("exit")) {
				/**
				 * If the user has decided to exit, we close to reader.
				 */
				in.close();
				System.exit(0);
				/**
				 * If the user decides to reset back to the original array that
				 * was read in, we now reset back to the read in array.
				 */
			} else if (input.equals("reset")) {
				Sudoku resetSudoku = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
				System.out.println(resetSudoku);
			} else {
				System.out.println(
						"That was an invalid input, please try again.\nRemember that it needs to be in the format of:\nRowColumn:Value");
			}

		}

	}

	public static void main(String[] args) throws IllegalArgumentException {

		try {
			play("sudoku-ex1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
