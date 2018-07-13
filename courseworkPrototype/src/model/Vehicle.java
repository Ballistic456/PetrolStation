package model;

import java.util.Queue;

public abstract class Vehicle {
	
	private static int ID = 0;
	
	private final int id;
	private double tank;
	private double size;
	private boolean leaveNextStep;
	
	public Vehicle(double tank, double space) {
		id = ID++;
		this.tank = tank;
		this.size = space;
		this.leaveNextStep = false;
	};
	
	/**
	 * This Vehicle arrives at a given station.
	 * @param station  the station the vehicle arrives at
	 */
	public void arrive(PetrolStation station) {
		findPumpQueue(station);
	}
	
	/**
	 * This Vehicle will leave the station on the next step.
	 * Sets flag {@link #leaveNextStep} to true to be picked up by {@link Simulation#removeLeavingVehicles} next step.
	 */
	public void leaveStation() {
		this.leaveNextStep = true;
	};
	
	/**
	 * This Vehicle enters the first Pump queue that has enough space for it.
	 * If there is not enough space in any queues, this Vehicle will leave the station.
	 * @param station  the station the Vehicle is at
	 */
	public void findPumpQueue(PetrolStation station) {
		// Look for a pump vehicle can join, otherwise leave station
		for(Pump p : station.getPumps()) {
			if(p.getQueueSpace() >= size) {
				joinPumpQueue(p);
				break;
			}
		}
		leaveStation();
	};
	
	/**
	 * This Vehicle joins the queue of a given Pump .
	 * @param p  the Pump this Vehicle queues as
	 */
	public void joinPumpQueue(Pump p) {
		p.addToQueue(this);
	};
	
	/**
	 * This Vehicle leaves a given Pump queue.
	 * @param p  the Pump this Vehicle leaves the queue of
	 */
	public void leavePumpQueue(Pump p) {
		p.removeFromQueue(this);
	};
	
	public void topUp() {
		//TODO 
	};
	
	public  void pickUp() {
		//TODO 
	};
	
	public void joinTillQueue(Queue<Vehicle> q) {
		//TODO 
	};
	
	public void leaveTillQueue(Queue<Vehicle> q) {
		//TODO 
	};
	
	//TODO Finish method
	public void act(PetrolStation station) {
		arrive(station);
		/*
		topUp();
		pickUp();
		findTillQueue();
		joinTillQueue();
		pay();
		leaveTillQueue();
		leavePumpQueue();
		leaveStation();
		*/
	};
	
	/**
	 * Gets the size of this Vehicle.
	 * @return the size of this vehicle
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Gets the id of this Vehicle.
	 * @return the id of this vehicle
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets whether the vehicle is set to leave the station.
	 * @return true if set to leave, false if not
	 */
	public boolean isLeavingNextStep() {
		return leaveNextStep;
	}

}
