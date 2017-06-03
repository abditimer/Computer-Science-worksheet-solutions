/**
 * This is a solution to Exercise 2 on Worksheet 4 given to us by Manfred.
 * <p>
 * This is a simple program that implements vehicle, inheriting the variables
 * maximum speed and passengers. This program gives you information about a car,
 * for example how fast it travels, and how much fuel it uses.
 * 
 * @author Abdikhaliq Timer
 * @version 14/10/12;
 *
 */
public class Car extends Vehicle {
	private double fuelConsumption;

	/**
	 * The constructor Car creates objects of cars that have a speed, number of
	 * passengers that use the car, and a fuel consumption.
	 * 
	 * @param maxSpeed
	 *            This is the maximum speed of the car.
	 * @param maxPassengers
	 *            This is the maximum number of passangers that the car can
	 *            occupy.
	 * @param fuelConsumption
	 *            This is the maximum fuel consumption of the car.
	 */
	public Car(double maxSpeed, int maxPassengers, double fuelConsumption) {
		super(maxSpeed, maxPassengers);
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * This is a getter, that retrieves the fuel consumption of the particular
	 * car object.
	 * 
	 * @return This returns the fuel consumption of the car.
	 */
	public double getFuelConsumption() {
		return this.fuelConsumption;
	}

	/**
	 * This is a setter, that sets the fuel consumption of the car object.
	 * 
	 * @param fuelConsumption
	 *            This sets the fuel consumption of the car, with units l/100km.
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * This toString method overrides the string which it could inherit from
	 * Vehicle, as it needs to also include the fuel consumption of the car.
	 */
	@Override
	public String toString() {
		return super.toString() + " Its fuel consumption is " + getFuelConsumption() + " l/100km.";
	}

}
