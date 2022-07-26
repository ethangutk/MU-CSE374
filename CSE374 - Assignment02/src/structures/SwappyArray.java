package structures;

import java.util.ArrayList;

public class SwappyArray<E> implements RemovalArray<E> {

	// Variables
	ArrayList<E> swappyArray;
	ArrayList<E> tempArray;
	int currentSize;
	int indexOfLastElement;
	
	// Constructor
	public SwappyArray(int size) {
		swappyArray = new ArrayList<E>(size);
		currentSize = size;
		indexOfLastElement = 0;
	}

	// Constructor
	public SwappyArray(ArrayList<E> list) {
		swappyArray = list;
		currentSize = list.size();
		indexOfLastElement = list.size() - 1;
	}
	
	// Default Constructor
	public SwappyArray() {
		this(0);
	}

	/**
	 * Unsupported method
	 * 
	 * @param e Element to be added within the list
	 * @return true if removal was successful, otherwise false
	 */
	@Override
	public boolean add(E e) {
		throw new java.lang.UnsupportedOperationException("Not Implemented Yet");
	}

	/**
	 * Will remove the object within the list. If the
	 * object isn't at the end of the list, the last 
	 * element will be swapped with one removed
	 * 
	 * list = [1, 2, 3, 4, 5, 6   ];
	 * removeAt(3)
	 * list = [1, 2, 3, 6, 5, null];
	 * 
	 * @param index Index of element to be removed
	 * @return E object that was removed
	 */
	@Override
	public E removeAt(int index) {
		// Index is out of range, return failure.
		if (index >= swappyArray.size() || index < 0) {
			return null;
		}

		// Removed specified element at index
		E returnValue = swappyArray.get(index);
		
		// If element is not at end, shifts all elements down one
		if (index < swappyArray.size()) {
			swappyArray.set(index, swappyArray.get(indexOfLastElement));
			swappyArray.remove(indexOfLastElement);
		}
		indexOfLastElement--;

		// Returns element removed
		return returnValue;
	}

	/**
	 * Will remove the object within the list. If the
	 * object isn't at the end of the list, the last 
	 * element will be swapped with one removed
	 * 
	 * list = [1, 2, 3, 4, 5, 6   ];
	 * remove(3)
	 * list = [1, 2, 6, 4, 5, null];
	 * 
	 * @param e Element to be removed within the list
	 * @return true if removal was successful, otherwise false
	 */
	@Override
	public boolean remove(E e) {
		// Index is out of range, return failure.
		if (swappyArray.contains(e)) {
			return false;
		}

		// Find index of element to remove.
		int indexOfRemoved = swappyArray.lastIndexOf(e);
		
		// Call other remove method using index.
		this.removeAt(indexOfRemoved);
		return true;
	}

	/**
	 * Clears list and resets size of array.
	 */
	@Override
	public void clear() {
		swappyArray = new ArrayList<E>(0);
		currentSize = 0;
		indexOfLastElement = 0;
	}
	
}
