
/**
 * This provides solutions for Worksheet 1 of Semester 2, given by Uday Reddy.
 * Worksheet 1: Recursion and Lists.
 * 
 * @author Abdikhaliq Timer
 * @version 18/01/2017
 * 
 *          This class contains the solution for Worksheet1
 */

public class Worksheet1 implements Worksheet1Interface {

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	/**
	 * Exercise 1(a): Powers of integers (10%)
	 * 
	 * @param m
	 *            an integer that is the base for our power.
	 * @param n
	 *            the exponent, which also is an integer.
	 * @return m an integer; result of m^n.
	 */
	public static int power(int m, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return m;
		} else {
			return m * power(m, n - 1);
		}
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	/**
	 * Exercise 1(b): FastPower (10%)
	 * 
	 * @param m
	 *            the base m, an integer.
	 * @param n
	 *            the exponent
	 * @return should return m ^ n, using a different method to power.
	 */
	public static int fastPower(int m, int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return m;
		else if (n % 2 == 0)
			return fastPower(m, (n / 2)) * fastPower(m, (n / 2));
		else
			return m * fastPower(m, ((n - 1) / 2)) * fastPower(m, ((n - 1) / 2));

	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	/**
	 * Given a list of integers, this method needs to return a new list with all
	 * the elements of a, but with the sign negated, positive integers to
	 * negative integers and vice versa.
	 * 
	 * @param a
	 *            List of numbers that have both positive and negative numbers
	 * @return List of numbers that have had their signs switched
	 */

	public static List negateAll(List a) {
		// base case; is when the list is empty
		if (a.isEmpty())
			throw new IllegalStateException();
		else if (a.getTail().isEmpty())
			return List.cons(-1 * a.getHead(), List.empty());
		else
			// recursive case; recursively multiple list head by -1
			return List.cons(-1 * a.getHead(), negateAll(a.getTail()));

	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	/**
	 * 
	 * 
	 * This method will find the position of the integer x within the list of a.
	 * The count will begin with 0. For example;
	 * x: 3 a: [7, 5, 3, 8] ==> 2
	 * However, if the list does not contain x, then the an illegalStateException will be
	 * returned;
	 * x: 2 a: [7, 5, 3, 8] ==> IllegalStateException
	 * 
	 * @param x
	 *            the integer you would like to check against the List a
	 * @param a
	 *            List a
	 * @return the position of the occurrence of x in list a, unless its not in
	 *         the list.
	 */
	public static int find(int x, List a) {
		// base case; if list is empty, return exception
		if (a.isEmpty())
			throw new IllegalStateException();
		else if (a.getHead() == x)
			return 0;
		else
			return 1 + find(x, a.getTail());
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	/**
	 * This method will aim to check whether a list is all positives.
	 * 0 is positive in this case.
	 * 
	 * @param a A list, a, that will contain numbers which we will check for positivity.
	 * @return boolean whether the list contains all positive numbers, >=0.
	 */
	public static boolean allPositive(List a) {

		if (a.isEmpty())
			throw new IllegalStateException();
		else if (a.getHead() < 0)
			return false;
		else if (a.getHead() >= 0 && a.getTail().isEmpty())
			return true;
		else
			return allPositive(a.getTail());

	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	/**
	 * Given a list of integers a, this method needs to be able to return a new
	 * list which contains all the positive elements of the list a. The elements
	 * should appear in the result in the same order as the list a. An example
	 * follows: [2, 3, -5, 8, -2] ==> [2, 3, 8]
	 * 
	 * @param a
	 *            List a of integers.
	 * @return List containing all the positive integers from List a which is
	 *         provided.
	 */
	public static List positives(List a) {
		if (a.isEmpty())
			throw new IllegalStateException();
		else if (a.getHead() >= 0 && a.getTail().isEmpty())
			return List.cons(a.getHead(), List.empty());
		else if (a.getHead() < 0 && a.getTail().isEmpty())
			return List.empty();
		else if (a.getHead() < 0)
			return positives(a.getTail());
		else
			return List.cons(a.getHead(), positives(a.getTail()));
	}
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * Here we want to check if a list is sorted. returning true if the list is
	 * in ascending order.
	 * <p>
	 * hence, for a list with the following numbers; a = 1,3, 4, 7, 8 sorted(a)
	 * should return TRUE
	 * 
	 * whereas, b= 3, 5, 2, 7 sorted(b) should return FALSE as its not in
	 * ascending order. 052
	 * 
	 * @param a
	 *            A list a must be passed into the program.
	 * @return TRUE if the list is sorted in ascending order, but FALSE if its
	 *         not sorted in ascending order.
	 */
	public static boolean sorted(List a) {
		// base case; single item its sorted, no items not sorted
		if (a.isEmpty()) {
			throw new IllegalStateException();
		} else if (a.getTail().isEmpty()) {
			return true;
		} else if (a.getHead() > a.getTail().getHead()) {
			return false;
		} else
			return sorted(a.getTail());
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * Given two sorted lists, a and b, this method must return a new sorted
	 * single list that contains
	 * <ul>
	 * <li>all elements of a</li>
	 * <li>all elements of b</li>
	 * <li>Duplicates are allowed</li>
	 * <p>
	 * 
	 * @param a
	 *            a sorted List a of integers
	 * @param b
	 *            a sorted List b of integers
	 * @return the merged list including lists a and b
	 */
	public static List merge(List a, List b) {

		if (a.isEmpty() && b.isEmpty())
			throw new IllegalStateException();
		else if (a.isEmpty()) {
			return b;
		} else if (b.isEmpty()) {
			return a;
		}
		else if (a.getHead() <= b.getHead()) { // a is bigger than b
			return List.cons(a.getHead(), merge(a.getTail(), b));
		} else // b is bigger than a
			return List.cons(b.getHead(), merge(a, b.getTail()));
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * Given a sorted list, this method must return a copy of the list a, with
	 * all of the duplicate copies removed. For example; a = [1, 3, 5, 5, 7]
	 * removeDuplicates(a) = [1, 2, 5, 7].
	 * 
	 * @param a
	 *            sorted list that has duplicates
	 * @return a sorted list that has had its duplicates removed
	 */
	static List removeDuplicates(List a) {
		// base case
		if (a.isEmpty()) {
			throw new IllegalStateException();
		} else if (a.getTail().isEmpty()) {
			return List.cons(a.getHead(), List.empty());
		} else if (a.getHead() != a.getTail().getHead()) {
			return List.cons(a.getHead(), removeDuplicates(a.getTail()));
		} else
			return removeDuplicates(a.getTail());
	}

	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
	// ======================================================================================
	// `¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

	/**
	 * This main method allowed me to see exactly what my recursive functions
	 * were returning.
	 */
	public static void main(String[] args) {
		System.out.println("Exercise 1: Power and fastPower:");
		for (int i = 0; i < 5; i++) {
			System.out.printf("2 to the power of %d is = %d%n", i, power(2, i));
			System.out.printf("2 to the power of %d is = %d%n", i, fastPower(2, i));
		}
		System.out.println("\nExercise 2:");
		List a = List.cons(2, List.cons(-3, List.cons(5, List.cons(-7, List.empty()))));
		List a2 = List.cons(-2, List.cons(3, List.cons(-5, List.cons(7, List.empty()))));
		System.out.println(negateAll(a));
		System.out.println(negateAll(a2));
		System.out.println("");

		System.out.println("\nExercise 3:");
		List b = List.cons(2, List.cons(7, List.cons(9, List.cons(6, List.empty()))));
		System.out.println(b);
		System.out.println(find(9, b) + "nd position\n" + "Answer should be 2nd position");

		System.out.println("\nExercise 4:");
		List c = List.cons(1, List.cons(-2, List.cons(3, List.cons(4, List.empty()))));
		System.out.println(allPositive(c) + " should be false");
		List c2 = List.cons(1, List.cons(2, List.cons(3, List.cons(4, List.empty()))));
		System.out.println(allPositive(c2) + " should be true");

		System.out.println("\nExercise 5:");
		List d = List.cons(-1, List.cons(-2, List.cons(3, List.cons(4, List.empty()))));
		System.out.println(positives(d) + "\n 3 and 4");
		List d2 = List.cons(1, List.cons(-2, List.cons(3, List.cons(-4, List.empty()))));
		System.out.println(positives(d2) + "\n 1 and 3");

		System.out.println("\nExercise 6:");
		List e = List.cons(-1, List.cons(2, List.cons(3, List.cons(4, List.empty()))));
		System.out.println(sorted(e) + ": this is the sorted, should say true");
		List e2 = List.cons(-1, List.cons(21, List.cons(3, List.cons(4, List.empty()))));
		System.out.println(sorted(e2) + ": this is the sorted, should say false");

		System.out.println("\nExercise 7:");
		List f = List.cons(1, List.cons(3, List.cons(5, List.cons(7, List.empty()))));
		List g = List.cons(2, List.cons(4, List.cons(6, List.cons(8, List.empty()))));
		System.out.println(merge(f, g) + " should give  1 - 8");

		System.out.println("\nExercise 8:");
		List h = List.cons(1, List.cons(2, List.cons(2, List.cons(3, List.empty()))));
		System.out.println(removeDuplicates(h) + "should give 1,2,3");
		List i = List.empty();
	}

}
