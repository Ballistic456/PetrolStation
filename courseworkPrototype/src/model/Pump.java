package model;

import java.util.LinkedList;
import java.util.Queue;

public class Pump {
	
	private static int ID = 0;
	private static double DEFAULT_QUEUE_CAPACITY = 3.0;
	
	private final int id;
	private Queue<Vehicle> queue;
	private final double maxQueueSpace;
	
	public Pump(){
		id = ID++;
		queue = new LinkedList<Vehicle>();
		maxQueueSpace = DEFAULT_QUEUE_CAPACITY;
	}
	
	/**
	 * Adds new vehicle to this Pump's queue.
	 * @param member  the vehicle to add
	 */
	public void newMember(Vehicle member) {
		queue.add(member);
	}
	
	/**
	 * Gets id of this Pump.
	 * @return {@link #id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the queue of this Pump.
	 * @return {@link #queue}
	 */
	public Queue<Vehicle> getQueue() {
		return queue;
	}
	
	/**
	 * Gets the remaining space available in this Pump's queue.
	 * @return the difference between {@link #maxQueueSpace} and {@link #getQueueCurrentLevel()}
	 */
	public double getQueueSpace() {
		return maxQueueSpace - getQueueCurrentLevel();
	}
	
	/**
	 * Gets the amount of space in this Pump's queue taken up by all vehicles within it.
	 * @return the total size of all vehicles in {@link #queue}
	 */
	public double getQueueCurrentLevel() {
		double output = 0.0;
		for(Vehicle v : queue) {
			output += v.getSize();
		}
		
		return output;
	}
	
	/**
	 * Adds given vehicle to this Pump's queue.
	 * @param v  the vehicle to be added
	 */
	public void addToQueue(Vehicle v) {
		queue.add(v);
	}
	
	/**
	 * Removes given vehicle from this Pump's queue.
	 * @param v  the vehicle to be removed
	 */
	public void removeFromQueue(Vehicle v) {
		queue.remove(v);
	}
}
