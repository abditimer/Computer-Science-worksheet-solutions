package Ex3;

/**
 * Weight is a program that converts masses given in the imperial system, and
 * changes them into the metric system.
 * <p>
 * It deals with weights given in kilograms, and converts them to pounds, ounces
 * or just gives you a weight back in kilograms. This is a solution to Exercise
 * 1 on Worksheet 2.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/16
 */
public class Weight {
	private double pound;
	private double kilograms;
	private double ounce;
	/*
	 * I begin by creating a constructor that will create Weights.
	 */
	/**
	 * Weight is a simple constructor that is made up of three parts; pound
	 * kilograms and ounces.
	 * I understand that the program could be used 
	 * 
	 * @param kg
	 *            This is a weight in kilograms.
	 */
	public Weight(double kg) {  //returns in terms of a double, as specified on the worksheet.
		this.pound = (kg / 0.45359237);
		this.kilograms = kg;
		this.ounce = (kg * 16) / 0.45359237;
	}
	/*
	 * I will now write methods which will retrieve parts of the weight,
	 * these are the getters (accessor methods).
	 */

	/**
	 * This getter 'getPounds', will return a weight given in pounds,
	 * and return it in terms of kilograms.
	 * 
	 * @return A weight given in pounds, returned in terms of Kilograms.
	 */
	public double getPounds() {
		return pound;
	}
	/**
	 * This getter 'getKilograms', will return a weight given in kilograms,
	 * and return it in terms of kilograms.
	 * 
	 * @return The weight given in kilograms, returned as a kilogram.
	 */
	public double getKilograms() {
		return kilograms;
	}
	/**
	 * This getter 'getOunces', will return a weight given in ounces,
	 * and return it in terms of kilograms.
	 * 
	 * @return The weight given in ounces, and returns it as a kilogram.
	 */
	public double getOunces() {
		return ounce;
	}
}
