package structures;

public class AggregateCab implements Cab{
	
	//This only tracks of the number of passenger seats (passed to the constructor)
	//and number of passengers (initially 0). Said otherwise, this class needs only two number variables.
	private int numSeats;
	private int numPassengers;
	
	public AggregateCab(int numSeats) {
		this.numSeats = numSeats;
		this.numPassengers = 0;
	}
	
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (this.numPassengers == this.numSeats);
	}

	@Override
	public boolean addPassenger(People p) {
		// TODO Auto-generated method stub
		if (this.numPassengers < this.numSeats) {
			this.numPassengers++;
			return true;
		} else return false;
	}
	

}
