package structures;

public class BaggyCab implements Cab{

	private ConstrainedCapacityBag<People> cabBag;
	
	public BaggyCab(int capacity){
		cabBag = new ConstrainedCapacityBag<People>();
		this.cabBag.capacity = capacity;
	}
	
	@Override
	public boolean isFull() {
		return (!(cabBag.numNodes < cabBag.capacity));
	}

	@Override
	public boolean addPassenger(People p) {
		if (cabBag.numNodes < cabBag.capacity) {
			cabBag.add(p);
			cabBag.numNodes++;
			return true;
		} else return false;
	}
	
	

}
