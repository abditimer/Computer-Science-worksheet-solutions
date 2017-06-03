package Ex1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a program that will solve only simple sudoku.
 * <p>
 * The program has identified that in order to solve a simple sudoku, it has to
 * analyse the inputed the sudoku, and its algoritm checks each row, then each
 * column, and then each square. This then checks to find where in the Sudoku
 * one possible entry is possible. Once this is found, the Sudoku places that
 * number and loops back around. In essence, solving the Sudoku one input at a
 * time.
 * 
 * @author Abdikhaliq Timer
 * @version 01/12/16
 *
 */
public class SudokuSolve {
	/**
	 * The method solve is what solves the Sudoku
	 * 
	 * @param enteredSudoku
	 *            This is the Sudoku which will be solved.
	 */
	public static void solve(Sudoku sudokuPassedIn) {
		/**
		 * The Sudoku object which we have passed in, we now save again.
		 */
		/**
		 * We begin by getting the array of the actual Sudoku object, and hence
		 * we save it as passedInArray. We will also need a transposed array,
		 * this will be needed for checking each of the columns at a later
		 * stage.
		 */
		int[][] passedInArray = sudokuPassedIn.getArray();
		int[][] transposedArray = transpos(passedInArray);
		/**
		 * The program needs an array list due to the program checking the rows,
		 * columns and box values, and once it has found all the numbers
		 * contained within the Sudoku, it will check them and eliminate any
		 * values which are correct.
		 */
		ArrayList<Integer> correctNumbersArrayList = new ArrayList<Integer>();
		/**
		 * This is the correct numbers which we will check against.
		 */
		int[] correctNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		/**
		 * The enhanced for loop will allow us to add each of the correct
		 * numbers into the arrayList.
		 */
		for (int i : correctNumbers) {
			correctNumbersArrayList.add(i);
		}

		boolean finished = true;
		/**
		 * This loop is now used to loop over all the values within the entire
		 * array.
		 */
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				/**
				 * Now, if the cell is empty, the array will now check to see if
				 * there is a single possible solution.
				 */
				if (passedInArray[j][i] == 0) {
					finished = false;
					/**
					 * We now copy into the another arrayList all the numbers of
					 * within the row of j. Hence this is a row check for each
					 * cell.
					 */
					ArrayList<Integer> rowCheck = new ArrayList<Integer>();
					for (int q : passedInArray[j]) { // q is used as i and j
														// have already been
														// used.
						rowCheck.add(q);
					}

					/**
					 * We now use a set that will allow us to find the
					 * intersect, the numbers which are identical between the
					 * numbers currently within the row, and the possible
					 * solutions.
					 */
					Set<Integer> s1 = new HashSet<Integer>();
					s1.addAll(correctNumbersArrayList);

					Set<Integer> s2 = new HashSet<Integer>();
					s2.addAll(rowCheck);
					/**
					 * We now have two sets, one containing all the numbers
					 * which are in the row, the other containing 1 to 9, which
					 * a row should contain in Sudoku. Hence, we now remove all
					 * numbers which are the same between them all,
					 * theoretically finding the possible numbers which can go
					 * into the slot.
					 */
					s1.removeAll(s2);

					/**
					 * We know do the same for the columns, the same process.
					 * However, this time it will need to save from the
					 * transposed array, as we want to add in the numbers from
					 * the columns.
					 */
					ArrayList<Integer> colCheck = new ArrayList<Integer>();
					for (int p : transposedArray[i]) {
						colCheck.add(p);
					}
					/**
					 * Again, now we identify the different sets, which will
					 * allow us to find the unique number
					 */
					Set<Integer> s3 = new HashSet<Integer>();
					s3.addAll(correctNumbersArrayList);
					Set<Integer> s4 = new HashSet<Integer>();
					s4.addAll(colCheck);

					s3.removeAll(s4);
					/**
					 * The following now finds the correct first position of the
					 * subsquare which the number position belongs to.
					 * <p>
					 * the division allows the rows and columns to be split into
					 * three sections, and the multiplication hence allows us to
					 * find the first value within the subsquare.
					 */
					int a = i / 3 * 3;
					int b = j / 3 * 3;
					/**
					 * An empty array of 9 slots, just like the rows and
					 * columns, will let us compare against.
					 */
					int[] subSquare = new int[9];
					/**
					 * We now loop over all the numbers within the subsquare in
					 * the Sudoku, copying each umber into the square array we
					 * created.
					 */
					for (int k = 0; k < 9; k++) {
						subSquare[k] = passedInArray[b + (k % 3)][a + (k / 3)];
					}
					/**
					 * The same process now is done, similar to the rows and
					 * columns.
					 */
					ArrayList<Integer> checkSubSquare = new ArrayList<Integer>();
					for (int z : subSquare) {
						checkSubSquare.add(z);
					}

					Set<Integer> s5 = new HashSet<Integer>();
					s5.addAll(correctNumbersArrayList);
					Set<Integer> s6 = new HashSet<Integer>();
					s6.addAll(checkSubSquare);
					/**
					 * Similar to the code above, removing identical numbers for
					 * each of the subsquare.
					 */
					s5.removeAll(s6);

					/**
					 * The following now proves why we use sets, as it now
					 * allows us to first check what posibilies exist between
					 * the rows and columns, and then comparing it to the
					 * possibilies that exists between those and the sub
					 * squares.
					 * <p>
					 * The following lines is what tells the program how many
					 * solutions there are possible for that specific empty
					 * cell.
					 */
					s1.retainAll(s3);
					s1.retainAll(s5);
					/**
					 * However, now as we cant add a set to an array, we want to
					 * now add the number given by the set to the ArrayList,
					 * which is then given to the sudoku.
					 */
					ArrayList<Integer> possibleSolutions = new ArrayList<Integer>();
					/**
					 * Hence, the algorithm of this program depended on one
					 * thing: If there is one solution for that cell, place it
					 * in, if not, carry on to the next cell.
					 */
					if (s1.size() == 1) {
						/**
						 * Add the number from the set to the ArrayList.
						 */
						possibleSolutions.addAll(s1);
						/**
						 * Get the only first number within the arrayList.
						 */
						passedInArray[j][i] = possibleSolutions.get(0);
						Sudoku solvingSudoku = new Sudoku(passedInArray);
						solve(solvingSudoku);
					}
				}
			}
		}
		if (finished) {
			System.out.println(sudokuPassedIn.toString());
		}
	}

	/**
	 * This is a method I added in order to transpose the array, and allow the
	 * program to add the numbers within the columns.
	 * 
	 * @param untransposed
	 *            The array which you want to find the columns for
	 * @return transposed array.
	 */
	public static int[][] transpos(int[][] untransposed) {

		int[][] transposedArray = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				transposedArray[i][j] = untransposed[j][i];
			}
		}
		return transposedArray;
	}

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		Sudoku sudokuPassedIn = SudokuRead.readSudoku("sudoku-ex4.txt");
		solve(sudokuPassedIn);
	}
}
