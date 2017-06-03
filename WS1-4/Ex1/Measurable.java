/**
 * This is a solution to Exercise 1 on Worksheet 4 given to us by Manfred.
 * <p>
 * This is a simple interface that is a reference for two classes which I
 * created; Invoice and Patient. This is an interface that will provide both of
 * these classes with an abstract method getMeasure.
 * 
 * @author Abdikhaliq Timer
 * @version 15/10/12;
 *
 */
interface Measurable {
	/**
	 * This is a getter, that will return the objects measure, which can include
	 * a weight or an amount.
	 * 
	 * @return This will be defined within the particular class that implements
	 *         this interface.
	 */
	double getMeasure();
}
