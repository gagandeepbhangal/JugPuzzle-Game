package ca.utoronto.utm.assignment1.q1;

/**
 * @author Gagandeep Bhangal 
 * This class is used to create Jugs with specific amounts of liquids and capacities.
 */
public class Jug {

	/**
	 * Declare private variables to store the capacity and amount of liquid in a jug
	 */
	private int capacity = 0, amount = 0;

	/**
	 * Construct a new empty Jug
	 */
	public Jug() {
		this.amount = 0;
	}

	/**
	 * Construct a new Jug with a specified capacity given
	 * 
	 * @param capacity is the max amount of liquid the jug can hold
	 */
	public Jug(int capacity) {
		this.capacity = capacity;
		this.amount = 0;
	}

	/**
	 * Set the amount of liquid in the jug
	 * 
	 * @param x is the amount of liquid you are setting in the jug
	 */
	public void setAmount(int x) {
		this.amount = x;
	}

	/**
	 * @return the capacity of the given jug
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * @return the amount of liquid in the given jug
	 */
	public int getAmount() {
		return this.amount;
	}
}
