package Ex5;

/**
 * Fraction is a program that will add, or multiply, two seperate fractions
 * together.
 * <p>
 * This is a solution to Exercise 5 on Worksheet2.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/16
 */
public class Fraction {
	private int numerator;
	private int denominator;

	/**
	 * This constructor creates a Fraction from the two parts: numerator and
	 * denominator, which are both of data types int
	 *
	 * @param numerator
	 *            The numerator of the Fraction.
	 * 
	 * @param denominator
	 *            The denominator of the Fraction.
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	/*
	 * I will now write methods which will retrieve parts from the Employee,
	 * these are known as getters (accessor methods).
	 */

	/**
	 * This getter gets the numerator of the fraction.
	 * 
	 * @return the numerator of the Fraction.
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * This getter gets the denominator of the fraction.
	 * 
	 * @return The denominator of the Fraction.
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * This method will add two different fractions.
	 * 
	 * @return the addition of two fractions.
	 */
	public Fraction add(Fraction summand) {
		int numerator = (this.numerator * summand.denominator) + (summand.numerator * this.denominator);
		int denominator = (this.denominator * summand.denominator);
		return new Fraction(numerator, denominator);
	}

	/**
	 * This method will multiply the two fractions.
	 * 
	 * @return the multiplication of two fractions.
	 */
	public Fraction multiply(Fraction factor) {
		int numerator = (this.numerator * factor.numerator);
		int denominator = (this.denominator * factor.denominator);
		return new Fraction(numerator, denominator);
	}

	/**
	 * This method is a boolean, so it checks if
	 * 
	 * @return Returns true if our second fraction is smaller than our first
	 *         fraction.
	 */
	public boolean less(Fraction comp) {
		double f1 = this.numerator / (double) this.denominator;
		double f2 = comp.numerator / (double) comp.denominator;
		return (f2 > f1);
		/*
		 * I could have also done it with an if loop, but I believe that would
		 * not be needed.
		 * 
		 * if (f2 > f1) { return true; } else { return false; }
		 */
	}

	/*
	 * I will now write a toString that will print the Fraction.
	 */
	/**
	 * toString prints the Fraction for us, hence the numerator divided by the
	 * denominator.
	 * 
	 * @return The fraction.
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

}
