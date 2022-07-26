package structures;

import java.util.ArrayList;

public class IndividualsCab implements Cab {
	private ArrayList<People> passengers;
	private int capacity;
	
	public IndividualsCab(int capacity) {
		this.capacity = capacity;
		this.passengers = new ArrayList<People>();
	}
	
	
	@Override
	public boolean isFull() {
		return (passengers.size() >= this.capacity);
	}

	@Override
	public boolean addPassenger(People p) {
		if (passengers.size() < this.capacity) {
			passengers.add(p);
			return true;
		}
		return false;
	}

}
