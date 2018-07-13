package model;

import java.util.LinkedList;
import java.util.Queue;

public class Till {
	
	private static int ID = 0;
	
	private final int id;
	private Queue<Vehicle> queue;
	
	public Till() {
		id = ID++;
		queue = new LinkedList<Vehicle>();
	}
	
	/**
	 * Gets id of this Till.
	 * @return the id of this Till
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the queue of this Till.
	 * @return the queue of this till
	 */
	public Queue<Vehicle> getQueue() {
		return queue;
	}
}
