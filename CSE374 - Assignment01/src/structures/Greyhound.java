package structures;

public class Greyhound implements Cab {
	
	private int passengers;
	private int numSeats;
	
	public Greyhound(int numSeats) {
		this.passengers = 0;
		this.numSeats = numSeats - (numSeats % 4) + 4; 
	}
	
	
	@Override
	public boolean isFull() {
		return (this.passengers >= (this.numSeats));
	}

	@Override
	public boolean addPassenger(People p) {
		if (this.passengers < (this.numSeats)) {
			passengers++;
			return true;
		} else return false;
	}

}
