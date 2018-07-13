package view;

import java.util.List;
import java.util.Queue;

import model.*;

public class TextView implements View{
	
	// Produce console output
	@Override
	public void render(PetrolStation station) {		
		renderStation();
		renderPumps(station.getPumps());
		renderShop(station.getShop());
		renderTills(station.getTills());
	}
	
	public void renderStation() {
		String output = "Petrol Station:";
		System.out.println(output);
	}
	
	public void renderPumps(List<Pump> pumps) {
		for (Pump p : pumps) {
			
			int pId = p.getId();
			
			Queue<Vehicle> pumpQueue = p.getQueue();
			String vehiclesInQueue = pumpVehicles(pumpQueue);
			String output = String.format("\tPump %s: %s", pId, vehiclesInQueue);
			
			System.out.println(output);
		}
	}
	
	public String pumpVehicles(Queue<Vehicle> pumpQueue){
		String output = "";
		for(Vehicle v : pumpQueue) {
			output = output.concat(String.format("%s%s ", v.getClass().getSimpleName(), v.getId()));
		}
		
		return output;
	}
	
	public void renderShop(Shop shop) {
		List<Vehicle> shopOccupants = shop.getOccupants();
		String output = String.format("\tShop: %s" , shopOccupants);
		System.out.println(output);
	}
	
	private void renderTills(List<Till> tills) {
		for (Till t : tills) {
			int tId = t.getId();
			Queue<Vehicle> tQueue = t.getQueue();
			String output = String.format("\tTill %s: %s", tId, tQueue);
			System.out.println(output);
		}
		
	}

	
}
