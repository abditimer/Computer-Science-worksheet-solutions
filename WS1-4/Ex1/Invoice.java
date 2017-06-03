/**
 * This is a solution to Exercise 1 on Worksheet 4 given to us by Manfred.
 * <p>
 * This is a simple program that implement an interface, which is named
 * measurable, as that is the only thing she will be returning.
 * Hence, this class inherits the abstract methods of the interface Measurable. 
 * <p>
 * This is an invoice class, which creates objects of invoice, that has three components
 * including: account number, sort code and amount.
 * 
 * @author Abdikhaliq Timer
 * @version 14/10/12;
 *
 */
public class Invoice implements Measurable {
	/**
	 * These variables below are needed for an invoice, they include an account
	 * number, sortcode and an amount. These can be called and set using the
	 * getters and setters made below.
	 */
	private String accountNumber;
	private String sortCode;
	private double amount;

	public Invoice(String accountNumber, String sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}

	/**
	 * This is a getter for the account number of the particular object you are
	 * looking at.
	 * 
	 * @return returns to the user a String containing the account number of the
	 *         invoice.
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * This is a setter for the account number.
	 * 
	 * @param accountNumber
	 *            In order to set the account number, you will need to provide a
	 *            new account number which will set the objects account number.
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * This is a getter for the sort code
	 * 
	 * @return it returns the sort code of the invoice object
	 */
	public String getSortCode() {
		return sortCode;
	}

	/**
	 * This is a setter for the sort code
	 * 
	 * @param sortCode
	 *            The sortCode which you provide this method will set the sort
	 *            code of the invoice object
	 */
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	/**
	 * This is a getter for the amount belonging to the invoice object
	 * 
	 * @return This returns the amount which the invoice object has.
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * This is a setter that will set an amount for the invoice object
	 * 
	 * @param amount
	 *            The amount given to this method as a parameter will set the
	 *            invoice objects amount.
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * The getMeasure below is a method that is implemented in order to return
	 * the amount belonging to the invoice object, this is a method that has
	 * also been mentioned within the interface which this file implements,
	 * Measurable.
	 */
	public double getMeasure() {
		return this.amount;
	}
}
