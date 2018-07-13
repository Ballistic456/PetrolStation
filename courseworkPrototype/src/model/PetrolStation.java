package model;

import java.util.ArrayList;
import java.util.List;

public class PetrolStation {
	
	private static final int DEFAULT_NUM_OF_PUMPS = 3;
	private static final int DEFAULT_NUM_OF_TILLS = 3;
	
	private final Shop shop;
	private final List<Pump> pumps;
	private final List<Till> tills;

	public PetrolStation() {
		this(DEFAULT_NUM_OF_TILLS, DEFAULT_NUM_OF_PUMPS);
	}
	
	public PetrolStation(int numOfTills, int numOfPumps) {
		pumps = new ArrayList<Pump>();
		for(int i=0; i<numOfTills; i++) {
			pumps.add(new Pump());
		}
		tills = new ArrayList<Till>();
		for(int i=0; i<numOfPumps; i++) {
			tills.add(new Till());
		}
		shop = new Shop();
	}
	
	/**
	 * Gets shop for this station.
	 * @return {@link #shop}
	 */
	public Shop getShop() {
		return shop;
	}
	
	/**
	 * Gets list of pumps for this station.
	 * @return {@link #pumps}
	 */
	public List<Pump> getPumps() {
		return pumps;
	}
	
	/**
	 * Gets list of tills for this station.
	 * @return {@link #tills}
	 */
	public List<Till> getTills() {
		return tills;
	}
}
