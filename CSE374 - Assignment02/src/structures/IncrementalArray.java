package structures;

import java.util.ArrayList;

public class IncrementalArray<E> implements RemovalArray<E> {
	// Variables
	ArrayList<E> incrementalArray;
	ArrayList<E> tempArray;
	int arraySize;

	// Contructor
	public IncrementalArray(int size) {
		incrementalArray = new ArrayList<E>(size);
		arraySize = size;
	}
	
	// Constructor
	public IncrementalArray(ArrayList<E> list) {
		incrementalArray = list;
		arraySize = list.size();
	}

	// Default Constructor
	public IncrementalArray() {
		this(0);
	}

	
	
	
	/**
	 * Adds element to the end of the list, if the list
	 * is at capacity, it will create a new list with 
	 * an extra capacity slot, then add it.
	 * 
	 * list = [1, 2, 3, 4, 5, 6];
	 * add(7)
	 * list = [1, 2, 3, 4, 5, 6, 7];
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
		if (incrementalArray.size() == arraySize) {
			tempArray = incrementalArray;
			incrementalArray = new ArrayList<E>(++arraySize);
			incrementalArray.addAll(0, tempArray);
		}
		incrementalArray.add(e);
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
		if (index >= incrementalArray.size() || index < 0) {
			return null;
		}

		// Removed specified element at index
		E returnValue = incrementalArray.remove(index);

		// If element is not at end, shifts all elements down one
		if (index < incrementalArray.size()) {
			for (int i = index + 1; i < incrementalArray.size(); i++) {
				// Adds moves current element to previous index
				incrementalArray.add(i - 1, incrementalArray.get(i));

				// removes current element
				incrementalArray.remove(i);
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
		if (incrementalArray.contains(e)) {
			return false;
		}

		// Find index of element to remove.
		int indexOfRemoved = incrementalArray.lastIndexOf(e);
		
		// Call other remove method using index.
		this.removeAt(indexOfRemoved);
		return true;
	}
	
	/**
	 * Clears list and resets size of array.
	 */
	public void clear() {
		incrementalArray = new ArrayList<E>(0);
		arraySize = 0;
	}
}


