import java.util.ArrayList;

/**
 * This is a solution to Exercise 1 on Worksheet 4 given to us by Manfred.
 * <p>
 * This is a program that has two methods that are crucial to answering the
 * exercise; it works out both the mean and standard deviation.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/12;
 *
 */
public class Statistics {
	/**
	 * This method works out the average, which expresses the central value of
	 * the data.
	 * <p>
	 * This is a method named "mean" that works out the mean, for example, it
	 * adds up all the numbers in the list of numbers, and it then divides by
	 * the total number of numbers in the list. It works out an average, also
	 * known as the mean, of a set of numbers. This is a really useful method to
	 * have as it will allow us to work out the mean weight of different
	 * patients, or the mean of all the invoices.
	 * 
	 * @param list
	 *            The parameter here will be of the various objects. The method
	 *            will then later extract the Measure of each object via the
	 *            .getMeasure method
	 * @return This mean method will return the mean of the various objects you
	 *         have given to the method. For example, if you have given a list
	 *         of different patients, it will return the mean weight of all the
	 *         different patients.
	 */
	public static double mean (ArrayList<Measurable> list) {
		/*
		 * Like how the mean works, there is a need to first have a temporary
		 * counter, that will be a storage that adds up the different values.
		 */
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			/*
			 * This is a loop that adds up all the different measures from the
			 * objects defined in the paramenters given to the object.
			 */
			total += list.get(i).getMeasure();
		}
		/*
		 * This below will do the main calculation of the mean, which is divide
		 * the total sum of all the numbers, by the total number of numbers
		 * there are in the list.
		 */
		double mean = total / list.size();
		return mean;
	}

	/**
	 * This method determines the standard deviation, which is a quantity
	 * calculated that indicates the extent of deviation for a group as a whole.
	 * This is a method that calculates the standard deviation of the list
	 * provided to this method.
	 * 
	 * @param list
	 *            This method needs to have provided to it a list of objects
	 *            that could include, for example, different patients. This
	 *            program will then use the getMeasure to work out the standard
	 *            deviation of the weight of the different patients.
	 * @return This returns the standard deviation of the list of objects
	 *         provided.
	 */
	public static double standardDeviation(ArrayList<Measurable> list) {
		/*
		 * Like the mean, this is calculated by summing each data point
		 * subtracted by the mean, then doing the square of all the numbers,
		 * dividing by the number of numbers in the list, and hence squaring
		 * this number.
		 */
		double total = 0;
		double variance = 0; // variance is the mathematical name for standard
								// deviation squared
		double standardDeviation = 0;

		for (int j = 0; j < list.size(); j++) {
			/*
			 * The total is worked out by subtracting the data points from the
			 * mean, and hence adding the squared values together.
			 */
			total += Math.pow((list.get(j).getMeasure() - mean(list)), 2);
		}
		variance = total / list.size();
		standardDeviation = Math.sqrt(variance);
		return standardDeviation;
	}
}
