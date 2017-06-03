package Ex4;

/**
 * Employee is a program that will give the user various information relating to
 * an employee. this includes the name, hourly salary, number of hours worked,
 * monthly salary and an option to increase the salary of an employee.
 * <p>
 * This is a solution to Exercise 4 on Worksheet2.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/16
 */
public class Employee {
	private String name;
	private double hourlySalary;
	private int numberOfHours;

	/*
	 * I begin by creating a constructor that will create Employee.
	 */
	/**
	 * Employee is a simple constructor that is made up of three parts; pound
	 * kilograms and ounces
	 * 
	 * @param name
	 *            This is the name of the Employee.
	 * @param hourlySalary
	 *            This is the hourly salary of the Employee.
	 * @param numberOfHours
	 *            This is the number of hours an Employee worked.
	 */
	public Employee(String name, double hourlySalary, int numberOfHours) {
		this.name = name;
		this.hourlySalary = hourlySalary;
		this.numberOfHours = numberOfHours;
	}
	/*
	 * I will now write methods which will retrieve parts of the weight, these
	 * are the getters (accessor methods).
	 */

	/**
	 * This getter 'getName', will return the name of the employee.
	 * 
	 * @return Name of the Employee.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This getter 'getHourlySalary', will return the hourly salary of the
	 * employee.
	 * 
	 * @return Hourly salary of Employee.
	 */
	public double getHourlySalary() {
		return hourlySalary;
	}

	/**
	 * This getter 'getNumberOfHours', will return the number of hours worked by
	 * Employee.
	 * 
	 * @return Number of hours worked by Employee.
	 */
	public int getNumberOfHours() {
		return numberOfHours;
	}

	/*
	 * I will now write methods which will set parts for the Employee. These are
	 * known as setters.
	 */
	/**
	 * This setter 'setName', will set the name of the Employee.
	 * 
	 * @param newName
	 *            The name of the Employee.
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * This setter 'setHourlySalary', will set the Hourly Salary.
	 * 
	 * @param newHourlySalary
	 *            The hourly salary of the Employee.
	 */
	public void setHourlySalary(double newHourlySalary) {
		this.hourlySalary = newHourlySalary;
	}

	/**
	 * This setter 'setNumberOfHours', will set the number of hours worked.
	 * 
	 * @param newNumberOfHours
	 *            the number of hours worked by the employee.
	 */
	public void setNumberOfHours(int newNumberOfHours) {
		this.numberOfHours = newNumberOfHours;
	}

	/**
	 * This method will work out the monthly salary.
	 * 
	 * @return The monthly salary.
	 */
	public double monthlySalary() {
		double monthlySalary = (numberOfHours * hourlySalary);
		return monthlySalary;
	}

	/**
	 * This method will work out an increase of salary.
	 * 
	 * @param percentage
	 *            This is the percentage you want to increase the salary by.
	 */
	public void increaseSalary(double percentage) {
		setHourlySalary(hourlySalary * (1 + (percentage / 100)));
	}

}
