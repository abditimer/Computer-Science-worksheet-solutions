/**
 * Rating interpreter
 * <p>
 * This program has been created in order to interpret ratings, these ratings
 * can be any from the range of 0 -> 5.
 * 
 * @author Abdikhaliq Timer
 * @version 30/10/16
 */
public class StarRating {
	/**
	 * large if statement that seperates the possible outcomes for the different
	 * ratings.
	 * <p>
	 * The if statement splits up the different ratings into different sections.
	 * A simple program that is able to correctly identify what an individual
	 * rating should be classed as.
	 * 
	 * @param rating
	 *            This is the rating which you would like to be interpreted by
	 *            the program.
	 * @return The correct range the rating belongs to.
	 */
	public static String interpret(double rating) {
		/**
		 * There are 5 different possibilities, as the range for the ratings
		 * include the actual ranges that have an actual corresponding rating,
		 * and also ranges that are out of the bounds such as negative votes,
		 * and votes greater than 5, all which have been considered.
		 */
		if (rating >= 5)
			return "[HAS ONLY ONE REVIEW]";
		else if (4.5 <= rating && rating < 5)
			return "EXCELLENT";
		else if (4 <= rating && rating < 4.5)
			return "OK";
		else if (0 <= rating && rating < 4)
			return "CRAP";
		else
			return "not rated"; // This will include negative votes.

	}
}
