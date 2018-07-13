package control;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import model.FamilySedan;
import model.Motorbike;
import model.PetrolStation;
import model.SmallCar;
import model.Vehicle;
import view.GraphicView;
import view.TextView;
import view.View;

public class Simulation {
	
	private static final int DEFAULT_NUM_OF_TICKS = 100;
	private static final String DEFAULT_VIEW_TYPE = "text";
	private static final double DEFAULT_P = 0.01;
	private static final double DEFAULT_Q = 0.01;
	
	private final PetrolStation station;
	private List<Vehicle> vehicles;
	private View view;
	private int step;
	
	public static void main(String[] args) {
		int n = DEFAULT_NUM_OF_TICKS;
		String viewType = DEFAULT_VIEW_TYPE;
		
		if (args.length>0) {
			n = Integer.parseInt(args[0]);
		}
		
		if (args.length>1) {
			if(args[1] == "text") {
				viewType = args[1];
			} else if(args[1] == "graphic") {
				viewType = args[1];
			}
		}
		
		Simulation s = new Simulation(viewType);
		
		s.simulate(n);
	}	

	public Simulation(String viewType) {
		station = new PetrolStation();
		vehicles = new ArrayList<Vehicle>();
		
		if(viewType == "text") {
			view = new TextView();
		}
		if(viewType == "graphic") {
			view = new GraphicView();
		}
		
		step = 0;
	}
	
	
	/**
	 * Runs the simulation a given number of times.
	 * 
	 * @param numOfTicks  the number of steps to run.
	 */
	public void simulate(int numOfTicks) {
		for(int i=0; i<numOfTicks; i++) {
			simulateOneTick();
		}
	}
	
	/**
	 * Carries out one step of the simulation.
	 * Advances simulation one step.
	 * Calls {@link #removeLeavingVehicles()} to deal with cars that have left the station.
	 * Generates a new random vehicle.
	 * If there are any vehicles in current step of simulation, call their {@link Vehicle#act(PetrolStation)} method.
	 * Finally, display current step in selected view.
	 */
	public void simulateOneTick() {
		step ++;
		removeLeavingVehicles();
		generateNewVehicle();
		if(!vehicles.isEmpty()) {
			for(Vehicle v : vehicles) {
				v.act(station);
			}
		}
		view.render(station);
	}
	
	/**
	 * Randomly generates a new vehicle using values of p and q.
	 * Currently set to use default values defined in fields of this class.
	 * Adds new vehicle (if any) to the class field {@link #vehicles} list.
	 */
	public void generateNewVehicle() {
		Random rand = new Random();
		float newRand = rand.nextFloat();
		
		Vehicle newVehicle = null;
		
		if(newRand <= DEFAULT_P) {
			newVehicle = new SmallCar();
		} else if(newRand <= DEFAULT_P * 2) {
			newVehicle = new Motorbike();
		} else if(newRand <= DEFAULT_P * 2 + DEFAULT_Q) {
			newVehicle = new FamilySedan();
		}
		
		if(newVehicle != null){
			vehicles.add(newVehicle);
		}
	}
	
	/**
	 * Removes vehicles from this simulation.
	 * Removes vehicles from {@link #vehicles} that have been flagged for removal during the previous step.
	 */
	public void removeLeavingVehicles() {
		ListIterator<Vehicle> i = vehicles.listIterator();
		while(i.hasNext()){
		    if(i.next().isLeavingNextStep()){
		        i.remove();
		    }
		}
	}
	
	/**
	 * Gets the current step number of this simulation.
	 * @return the current step number
	 */
	public int getStep() {
		return step;
	}
	
}
