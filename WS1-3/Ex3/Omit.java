import java.util.ArrayList;

/**
 * This is a program called Omit, that omits a certain value from a range of
 * values.
 * <p>
 * This program has been created in order to print a range of numbers that have
 * been specified by the user, and it then proceeds to omit those values.
 * <p>
 * The method I have used converts the number into a string, I could have
 * divided the number which I am trying to remove by 10 within the loop
 * condition parameter, and then have used the modulus, but to the best of my
 * knowledge I believe this code is more efficient.
 * 
 * @author Abdikhaliq Timer
 * @version 30/10/16
 */
public class Omit {
	/**
	 * The method allIntegersWithout is being used in order to create a list of
	 * numbers, that starts at from the given parameter integer 'from' and goes
	 * all the way till it reaches the integer 'to', then the program removes
	 * the 'omittedDigit'
	 * 
	 * @param from
	 *            This is the integer you would like to begin your list of
	 *            numbers from
	 * @param to
	 *            This is where our list will end, the final number of our list.
	 * @param omittedDigit
	 *            This is the value which we do not want in our final ordered
	 *            list.
	 * @return This will return our final list, starting from the integer
	 *         mentioned, and ending on the integer we want. This list will not
	 *         include any number with the ommitedDigit.
	 */
	public static ArrayList<Integer> allIntegersWithout(int from, int to, int omittedDigit) {
		/**
		 * This will create an empty array list that will be used to store the
		 * list we want to omit digits from.
		 */
		ArrayList<Integer> elements = new ArrayList<Integer>();
		/**
		 * This initial loop will loop around the values which have been
		 * specified within the parameters, creating a full list without the
		 * omitted numbers. This calls upon another method called containsDigit,
		 * as that will check if the actual number contains a certain digit, the
		 * one which we would like to omit.
		 */
		for (int i = from; i <= to; i++) {
			/**
			 * the Integer.toString converts our integer into a string, this is
			 * useful as we will be able to loop through the number, and check
			 * if any of the actual characters within the string are the same as
			 * the integer we want to omit.
			 */
			String x = Integer.toString(i);
			if (!(containsDigit(x, omittedDigit))) { // this will run only if it
														// does not contain the
														// digit we want to
														// omit.
				elements.add(i);
			}
		}

		return elements;
	}

	/**
	 * This is an extra method I have created to simplify the code, and make the
	 * code clean.
	 * 
	 * @param integerString
	 * @param digit
	 * @return
	 */
	public static boolean containsDigit(String integerString, int digit) {
		for (int i = 0; i < integerString.length(); i++) {
			if (Character.getNumericValue(integerString.charAt(i)) == digit) {
				return true;
			}
		}
		return false;
	}
}