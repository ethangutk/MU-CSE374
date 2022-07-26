package structures;

import java.util.ArrayList;

public class DoublingArray<E> implements RemovalArray<E> {
	// Variables
	ArrayList<E> doublingArray;
	ArrayList<E> tempArray;
	int currentSize;

	// Contructor
	public DoublingArray(int size) {
		doublingArray = new ArrayList<E>(size);
		currentSize = size;
	}

	// Contructor
	public DoublingArray(ArrayList<E> list) {
		doublingArray = list;
		currentSize = list.size();
	}
		
	// Default Constructor
	public DoublingArray() {
		this(0);
	}

	
	/**
	 * Adds element to the end of the list, if the list
	 * is at capacity, it will create a new list with 
	 * double capacity slots, then add it.
	 * 
	 * list = [1, 2];
	 * add(3)
	 * list = [1, 2, 3, null];
	 * 
	 * OR 
	 * 
	 * list = [1, 2, 3, 4, 5, 6, null, null, null];
	 * add(7)
	 * list = [1, 2, 3, 4, 5, 6,    7, null, null];
	 * 
	 * @param e Element to add within the list
	 * @return true if removal was successful, otherwise false
	 */
	@Override
	public boolean add(E e) {
		if (doublingArray.size() == currentSize) {
			tempArray = doublingArray;
			currentSize *= 2;
			doublingArray = new ArrayList<E>(currentSize);
			doublingArray.addAll(tempArray);
		}
		doublingArray.add(e);
		return true;
	}

	/**
	 * Will remove the object at the specified index. If the
	 * object isn't at the end of the list, all elements will
	 * shift down.
	 * 
	 * list = [1, 2, 3, 4, 5, 6   ];
	 * remove(4)
	 * list = [1, 2, 3, 5, 6, null];
	 * 
	 * @param index index for the object to be removed.
	 * @return returns the object that was removed.
	 */
	@Override
	public E removeAt(int index) {
		// Index is out of range, return failure.
		if (index >= doublingArray.size() || index < 0) {
			return null;
		}

		// Removed specified element at index
		E returnValue = doublingArray.remove(index);

		// If element is not at end, shifts all elements down one
		if (index < doublingArray.size()) {
			for (int i = index + 1; i < doublingArray.size(); i++) {
				// Adds moves current element to previous index
				doublingArray.add(i - 1, doublingArray.get(i));

				// removes current element
				doublingArray.remove(i);
			}
		}

		// Returns element removed
		return returnValue;
	}

	/**
	 * Will remove the object within the list. If the
	 * object isn't at the end of the list, all elements will
	 * shift down.
	 * 
	 * list = [1, 2, 3, 4, 5, 6   ];
	 * remove(3)
	 * list = [1, 2, 3, 5, 6, null];
	 * 
	 * @param e Element to be removed within the list
	 * @return true if removal was successful, otherwise false
	 */
	@Override
	public boolean remove(E e) {
		// Index is out of range, return failure.
		if (doublingArray.contains(e)) {
			return false;
		}

		// Find index of element to remove.
		int indexOfRemoved = doublingArray.lastIndexOf(e);
		
		// Call other remove method using index.
		this.removeAt(indexOfRemoved);
		return true;
	}

	/**
	 * Clears list and resets size of array.
	 */
	public void clear() {
		this.doublingArray = new ArrayList<E>(0);
		this.currentSize = 0;
	}
}
