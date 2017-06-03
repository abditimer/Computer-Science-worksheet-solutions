package Ex1;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/** 4 tests to check that class SudokuRead operates correctly.
 * @author Mohd Ghazanfar
 *
 */
public class SudokuReadTest { 

	
	/** Here we check that SudokuRead ignores any extra trailing input
	 * 
	 */
	@Test
	public void test1() { 
		
		int[][] expected = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, 
		                    {4, 5, 6, 7, 8, 9, 1, 2, 3}, 
		                    {7, 8, 9, 1, 2, 3, 4, 5, 6}, 
		                    {2, 3, 4, 5, 6, 7, 8, 9, 1}, 
		                    {5, 6, 7, 8, 9, 1, 2, 3, 4}, 
		                    {8, 9, 1, 2, 3, 4, 5, 6, 7}, 
		                    {3, 4, 5, 6, 7, 8, 9, 1, 2}, 
		                    {6, 7, 8, 9, 1, 2, 3, 4, 5}, 
		                    {9, 1, 2, 3, 4, 5, 6, 7, 8}};
		
		Sudoku expect = new Sudoku(expected);
		
		Sudoku actual = null;
		
		try {
			actual = SudokuRead.readSudoku("sudoku-extra.txt");
		} catch (IllegalArgumentException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertArrayEquals("The file was not read correctly", expect.getArray(), actual.getArray());
		
	}
	
	@Rule 
	public ExpectedException exception = ExpectedException.none();
	
	/** Here we test that SudokuRead throws an illegal argument exception when it encounters an illegal argument.
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	@Test
	public void test2() throws IllegalArgumentException, IOException { 
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Values must be between 1 and 9 inclusively");
		
		SudokuRead.readSudoku("sudokuIllegal1.txt");

	}
	
	/** Here we test that SudokuRead throws an IOException when the file is not found.
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	@Test
	public void test3() throws IllegalArgumentException, IOException { 
		
		exception.expect(IOException.class);
		exception.expectMessage("(No such file or directory)");
		
		SudokuRead.readSudoku("sudokuIllegal11.txt");

	}
	

}
