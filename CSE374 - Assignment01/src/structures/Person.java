package structures;

import java.util.Random;

public class Person implements People {
	private String name;
	private int groupNum;
	private boolean covid;

	// Constructor for Person
	public Person(String name) {
		this.name = name;
		this.groupNum = 0;
		//1 in 10 chance of getting covid.
		if ((new Random().nextInt(10)) == 1) {
			this.getsCOVID();
		}
	}
	
	public Person(String name, int groupNum) {
		this(name);
		this.groupNum = groupNum;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public int getGroupNum() {
		return this.groupNum;
	}

	@Override
	public boolean hasCOVID() {
		return this.covid;
	}

	@Override
	public void getsCOVID() {
		this.covid = true;
	}
}
