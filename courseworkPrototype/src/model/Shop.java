package model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	
	List<Vehicle> occupants;
	
	public Shop() {
		occupants = new ArrayList<Vehicle>();
	}
	
	/**
	 * Gets a list of occupants within this shop.
	 * {@link Vehicle} is used to model the occupant.
	 * @return a list of occupants.
	 */
	public List<Vehicle> getOccupants(){
		return occupants;
	}

}
