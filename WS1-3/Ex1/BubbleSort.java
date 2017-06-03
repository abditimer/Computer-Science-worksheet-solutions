/**
 * Bubble sort algorithm.
 * <p>
 * Bubble sort is a simple sorting algorithm that repeatedly steps through the
 * list to be sorted, it compares each pair of adjacent items and swaps them if
 * they are in the wrong order. The entire pass is repeated until there are no
 * more swaps that can be made, as everything is in the right order. This leads
 * to a sorted list.
 * 
 * @author Abdikhaliq Timer
 * @version 30/10/16
 */
public class BubbleSort {
	/**
	 * bubbleSort is a simple method that 'bubbles' the value through the list.
	 * This method uses the bubblesort approach, however does it backwards as
	 * indicated by Manfred on the worksheet. It does the exact same thing as a
	 * normal bubble sort algorithm, except that it bubbles through it from
	 * right to left.
	 * 
	 * @param numbers
	 *            This is the list of numbers which you would like to sort.
	 * 
	 * @return The list of numbers that you entered, but that are sorted in
	 *         ascending order.
	 */
	public static int[] bubbleSort(int[] numbers) {
		/**
		 * temporaryStorage will be used in order to temporarily store a value
		 * to switch adjacent numbers later. This is needed in Java, and in
		 * order for our bubblesort to work.
		 */
		int temporaryStorage;
		/**
		 * The first loop (outer loop) will be pointed towards the most outwards
		 * number, the number on the far right of the list. This number will
		 * then be compared to the number adjacent to it, the one to its direct
		 * left.
		 */
		for (int i = numbers.length - 1; i >= 0; i--) { // outer loop
			/**
			 * The inner loop will find the number which is directly adjacent to
			 * the number identified through the first outer loop. This second
			 * loop will allow us to compare the two numbers which are adjacent,
			 * and will hence allow us to determine whether a switch between the
			 * two numbers is needed.
			 */
			for (int j = numbers.length - 2; j >= 0; j--) { // inner loop
				/**
				 * The 'if' statement to switch the numbers
				 * <p>
				 * The if statement below will determine whether a swap is
				 * needed. The two adjacent numbers identified through the two
				 * loops above will now be compared if the 'if' statement is
				 * true, it means that the number on the right of the two
				 * numbers identified by the loop is smaller than the number to
				 * its immediate right. This is the concept behind the
				 * bubblesort, the smaller number will in this case 'bubble'
				 * down untill it gets to its right position. Likewise, all the
				 * numbers will eventually bubble down until they are all in the
				 * right position.
				 */
				if (numbers[j] > numbers[j + 1]) {       // This is comparing the two adjacent numbers
					temporaryStorage = numbers[j + 1];   // If and only if the left number is bigger than the right most number, we will need to swap them by storing one of them
					numbers[j + 1] = numbers[j];         // The numbers are swapped
					numbers[j] = temporaryStorage;       // The original stored number is placed in the other position.
				}
			}
		}
		/**
		 * The final return will now return the correct order of all the numbers.
		 */
		return numbers;
	}
}
