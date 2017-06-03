/**
 * This is a solution to Exercise 2 on Worksheet 4 given to us by Manfred.
 * <p>
 * This is a simple program that implement a class called Vehicle. This is a
 * class that tells us about a vehicle object. For example, a certain vehicle
 * that has a certain maximum speed and maximum number of passangers.
 * 
 * @author Abdikhaliq Timer
 * @version 14/10/12;
 *
 */
public class Vehicle {
	private double maxSpeed;
	private int maxPassengers;

	/**
	 * The constructor Vehicle creates Vehicle objects that have a maximum speed
	 * and passenger number that can occupy the Vehicle.
	 * 
	 * @param maxSpeed
	 *            The maximum speed of the vehicle
	 * @param maxPassengers
	 *            The maximum number of passangers that the vehicle can seat.
	 */
	public Vehicle(double maxSpeed, int maxPassengers) {
		this.maxSpeed = maxSpeed;
		this.maxPassengers = maxPassengers;
	}

	/**
	 * This is a getter for the maximum speed of the vehicle.
	 * 
	 * @return the maximum speed of the vehicle.
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * This is a setter for the vehicle
	 * 
	 * @param maxSpeed
	 *            The maximum speed which you would like to set the vehicle
	 *            object to.
	 */
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * This is the getter for the number of passangers that can sit in a
	 * vehicle. This method includes an if statement that allows the program to
	 * identify when the vehicle can sit more than 1 passenger.
	 * 
	 * @return The number of passengers
	 */
	public String getMaxPassengers() {
		if (maxPassengers > 1) {
			return maxPassengers + " passengers.";
		} else {
			return maxPassengers + " passenger.";
		}
	}

	/**
	 * This sets the maximum number of passengers which the vehicle object can
	 * have.
	 * 
	 * @param maxPassengers
	 *            The maximum number of passengers you want to set the vehicle
	 *            to.
	 */
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	/**
	 * a toString method that represents the vehicle, showing the maximum speed
	 * and maximum number of passangers which can be seated.
	 */
	@Override
	public String toString() {
		return "The vehicle has a maximal speed of " + getMaxSpeed() + " km/h. It carries " + getMaxPassengers();
	}

}
