package structures;

import java.util.Iterator;

public class ConstrainedCapacityBag<Item> implements Iterable<Item> {
	private Node first; // first node in list
	public int capacity = 0;
	public int numNodes = 0;
	
	
	private class Node {
		Item item;
		Node next;
	}

	public boolean add(Item item) { // same as push() in Stack
		if (numNodes < capacity) return false;
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		numNodes++;
		return true;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}
		
		public boolean isFull() {
			return (numNodes == capacity);
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
