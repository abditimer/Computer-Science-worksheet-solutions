/**
 * This is a solution to Exercise 1 on Worksheet 4 given to us by Manfred.
 * <p>
 * This is a simple program that implement interface Measurable. This means that
 * it will implement the abstract methods from the Measurable interface.
 * <p>
 * This is an invoice Patient is similar to the class of invoice, as it creates
 * objects that has a name, age and weight. Hence, the patient objects
 * information can be set and get using the various of methods I created.
 * 
 * @author Abdikhaliq Timer
 * @version 16/10/12;
 *
 */
public class Patient implements Measurable {
	/**
	 * As the patient object needs three main variables, I will be setting these
	 * variables privately, and they include name, age and weight. The patient
	 * objects that will be created will hence have all these components.
	 */
	private String name;
	private int age;
	private double weight;

	/**
	 * The constructor Patient creates the patient objects. It has three
	 * variables which need to be provided in order to create the patient
	 * object.
	 * 
	 * @param name
	 *            the name of the patient will be needed as a parameter in order
	 *            to create the patient object.
	 * @param age
	 *            the age of the patient will also be needed.
	 * @param weight
	 *            The weight of the user will be needed.
	 */
	public Patient(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	/**
	 * This is a getter, which gets the name of the patient object.
	 * 
	 * @return this returns the name of the patient
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is the opposite of the getter, it sets the name of the patient
	 * 
	 * @param name
	 *            The name which you provide this method will set the name of
	 *            the patient.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is a getter, which gets the age of the patient object.
	 * 
	 * @return It returns the age of the patient object.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * This is a setter, which sets the age of the patient object
	 * 
	 * @param age
	 *            The age which is provided to this method sets the age of the
	 *            patient object to that age provided.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This is a getter, which gets the weight of the patient object.
	 * 
	 * @return The weight of the patient.
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * This is a setter, which sets the weight of the patient.
	 * 
	 * @param weight
	 *            The weight provided to this method will set the weight of the
	 *            patient object.
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * This is a getter which has been implemented due to the implamentation of
	 * the interface, hence this program has a method getMeasure, which was an
	 * abstract method in the Measurable interface, and once it is called, it
	 * returns the weight of the patients.
	 * 
	 * @return the weight of the patient.
	 */
	public double getMeasure() {
		return weight;
	}
}
