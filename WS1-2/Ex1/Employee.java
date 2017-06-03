package Ex1;

/**
 * Employee is a class for a finding out information about an Employee. This
 * information includes their firstname, surname and the year they joined.
 * <p>
 * This is a solution to Exercise 1 on Worksheet 2.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/16
 */
public class Employee {
	private String firstName;
	private String surname;
	private int yearOfJoining;

	/*
	 * I begin by creating a constructor that will create an Employee.
	 */
	/**
	 * Employee is a simple constructor that is made up of three parts; first
	 * name, surname and the year of joining.
	 * 
	 * @param firstName
	 *            This is the Employee's first name.
	 * @param surname
	 *            This is the Employee's surname.
	 * @param yearOfJoining
	 *            This is the Employee's year of joining.
	 */
	public Employee(String firstName, String surname, int yearOfJoining) { // This
																			// is
																			// the
																			// constructor.
		this.firstName = firstName;
		this.surname = surname;
		this.yearOfJoining = yearOfJoining;
	}
	/*
	 * I will now write methods which will retrieve parts from the Employee,
	 * these are known as getters (accessor methods).
	 */

	/**
	 * This getter 'getFirstName', will get the first name of the Employee.
	 * 
	 * @return The first name as a String.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This getter 'getSurname', will get the surname of the employee.
	 * 
	 * @return The surname as a String.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * This getter 'getYearOfJoining', will get the year the employee joined.
	 * 
	 * @return The year of joining.
	 */
	public int getYearOfJoining() {
		return yearOfJoining;
	}

	/*
	 * I will now write methods which will set parts for the Employee. These are
	 * known as setters.
	 */
	/**
	 * This setter 'setFirstName', will set the surname.
	 * 
	 * @param newFirstName
	 *            The first name of the Employee.
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	/**
	 * This setter 'setSurname', will set the surname.
	 * 
	 * @param surname
	 *            The surname of the Employee.
	 */
	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}

	/**
	 * The setter 'setYearOfJoining' will set the surname.
	 * 
	 * @param newYearOfJoining
	 *            The year the Employee joined.
	 */
	public void setYearOfJoining(int newYearOfJoining) {
		this.yearOfJoining = newYearOfJoining;
	}

	/*
	 * I will now write a toString that will print the parts of the Employee.
	 * This will show the first name, surname and the year the employee joined.
	 */
	/**
	 * toString prints Employee for us, hence the name, surname and
	 * yearOfJoining.
	 * 
	 * @return the print type of Employee, printing the firstName, surname and
	 *         year of joining.
	 */
	public String toString() {
		return "firstname: " + firstName + "surname: " + surname + "year joined: " + yearOfJoining;
	}
}

