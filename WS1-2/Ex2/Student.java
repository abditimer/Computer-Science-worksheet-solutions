package Ex2;

/**
 * Student is a class for finding information about the Student. The information
 * includes the name, dob, id number and degree programme. This is a solution to
 * Exercise 2 on Worksheet 2.
 * <p>
 * There will be no setters used within this code, as it is not required, and 
 * we do not want anyone changing the names of students in the future. However, the jUnit
 * tests included will check different parts of the Student.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/16
 */
public class Student {
	private String name;
	private String dateOfBirth;
	private String studentID;
	private String degreeProgramme;

	/*
	 * I begin by creating a constructor that will create a Student.
	 */
	/**
	 * Student is a constructor that is made up of four parts; the name, dob, id
	 * number and degree programme of the student.
	 * 
	 * @param name
	 *            The name of the student.
	 * @param dateOfBirth
	 *            This is the date of birth of the student.
	 * @param studentID
	 *            This is the students ID number.
	 * @param degreeProgramme
	 *            This is the students degree programme.
	 */
	public Student(String name, String dateOfBirth, String studentID, String degreeProgramme) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.studentID = studentID;
		this.degreeProgramme = degreeProgramme;
	}

	/*
	 * I will now write methods which will retrieve parts from the Student,
	 * these are known as getters (accessor methods).
	 */
	/**
	 * This getter 'getName', will get the name of the student.
	 * 
	 * @return The name of the Student as a String.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This getter 'getDateOfBirth', will get the date of birth of the student.
	 * 
	 * @return The date of birth of the student.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * This getter 'getStudentID', will get the ID of the student.
	 * 
	 * @return The ID of the Student.
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * This getter 'getDegreeProgramme', will get the degree program of the
	 * student.
	 * 
	 * @return The degree programme the student is on.
	 */
	public String getDegreeProgramme() {
		return degreeProgramme;
	}

	/*
	 * I will now write a toString that will print the parts of the Student.
	 * This will show the name, date of birth, ID number and the degree
	 * programme of the student.
	 */
	/**
	 * toString prints the elements of Student for us.
	 * 
	 * @return the print type of Employee, printing the firstName, surname and
	 *         year of joining.
	 */
	public String toString() {
		return "[" + name + ", " + dateOfBirth + ", ID: " + studentID + ", " + degreeProgramme + "]";
	}
}
