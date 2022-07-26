package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.github.javafaker.Faker;

import structures.Cab;
import structures.People;
import structures.People;
import structures.Person;
import structures.AggregateCab;
import structures.BaggyCab;
import structures.IndividualsCab;
import structures.Greyhound;

public class Main {

	public static void test1() {
		ArrayList<People> peopleToStore = new ArrayList<People>();
		ArrayList<Cab> cabsToStore = new ArrayList<Cab>();
		Faker faker = new Faker();
		
		for (int i = 0 ; i < 50 ; i++) {
			peopleToStore.add(new Person(faker.name().fullName()));
		}
		
		for (int i = 0 ; i < 11 ; i++) {
			cabsToStore.add(new AggregateCab(5));
		}
		
		//Should return 0
		System.out.println(storePeople(peopleToStore, cabsToStore));
	}
	
	public static void test2() {
		ArrayList<People> peopleToStore = new ArrayList<People>();
		ArrayList<Cab> cabsToStore = new ArrayList<Cab>();
		Faker faker = new Faker();
		
		for (int i = 0 ; i < 50 ; i++) {
			peopleToStore.add(new Person(faker.name().fullName()));
		}
		
		for (int i = 0 ; i < 2 ; i++) {
			cabsToStore.add(new IndividualsCab(5));
			cabsToStore.add(new Greyhound(2));
		}
		
		// Should return 32 (8 in greyhound and 10 in IndividualsCab)
		System.out.println(storePeople(peopleToStore, cabsToStore));
	}
	
	public static void test3() {
		Queue<People> peopleToStore = new LinkedList<>();
		Queue<Cab> cabsToStore = new LinkedList<>();
		Faker faker = new Faker();
		
		for (int i = 0 ; i < 50 ; i++) {
			peopleToStore.add(new Person(faker.name().fullName(), (i / 3)));
		}
		
		for (int i = 0 ; i < 6 ; i++) {
			cabsToStore.add(new BaggyCab(5));
		}
		
		// Should return 40 (8 in greyhound and 10 in IndividualsCab)
		storeGroupPeople(peopleToStore, cabsToStore);
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static void apocalypticCabs(Queue<People> p, Queue<Cab> c) {
		while (!p.isEmpty()) { // while there are people needing cabs
			if (c.isEmpty()) return; //no more cabs
			if (c.peek().isFull()) { // if the current cab is full…
				c.remove(); // …that cab is dealt with
				continue;
			}
			// the current person can get into the current cab
			boolean hasCOVIDCab = p.peek().hasCOVID();
			while (!c.peek().isFull() && !p.isEmpty() && p.peek().hasCOVID() == hasCOVIDCab) {
				c.peek().addPassenger(p.peek());
				p.remove();
			}
			c.remove();
		}
	}
	
	
	public static void storeGroupPeople(Queue<People> p, Queue<Cab> c) {
		while (!p.isEmpty()) { // while there are people needing cabs
			if (c.isEmpty()) return; //no more cabs
			if (c.peek().isFull()) { // if the current cab is full…
				c.remove(); // …that cab is dealt with
				continue;
			}
			// the current person can get into the current cab
			int currentGroupToAdd = p.peek().getGroupNum();
			while (!c.peek().isFull()&& !p.isEmpty() && p.peek().getGroupNum() == currentGroupToAdd) {
				if (!p.isEmpty() && p.peek().getGroupNum() == currentGroupToAdd) {
					c.peek().addPassenger(p.peek());
					p.remove();
				}
			}
		}
	}
	
	public static void fastStorePeople(Queue<People> p, Queue<Cab> c) {
		while (!p.isEmpty()) { // while there are people needing cabs
			if (c.isEmpty()) return;
			if (c.peek().isFull()) { // if the current cab is full…
				c.remove(); // …that cab is dealt with
				continue;
			}
			// the current person can get into the current cab
			c.peek().addPassenger(p.peek());
			p.remove(); // person dealt with
		}
	}
	
	public static int storePeople(List<People> p, List<Cab> c) {
		/*
		 * While there are people that need a cab If there are no cabs then stop the
		 * method If the cab at the front of the queue is full then remove it from queue
		 * and return to top of loop Put person in the front of the person queue in the
		 * cab
		 * 
		 * 
		 * 
		 */

		while (!p.isEmpty()) { // while there are people needing cabs
			if (c.isEmpty())
				return p.size(); // error, stranded people
			if (c.get(0).isFull()) { // if the current cab is full…
				c.remove(0); // …that cab is dealt with
				continue;
			}
			// the current person can get into the current cab
			c.get(0).addPassenger(p.get(0));
			p.remove(0); // person dealt with
		}
		return 0;
	}

}
