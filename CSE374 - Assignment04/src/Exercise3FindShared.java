import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exercise3FindShared <E extends Comparable<?super E>> {	
	public List<E> exercise03(List<E> L1, List<E> L2) {
		List<E> L3 = new LinkedList<>();
		
		if (L1.size() < L2.size()) {
			// if list 1 is smaller
			Collections.sort(L1);
			
			// For every element of L2, Binary search L1
			for (E e1 : L2) {
				if (Collections.binarySearch(L2, e1) > -1) {
					L3.add(e1);
				}
			}
		} else {
			// If list 2 is smaller or lists are same size
			Collections.sort(L2);
			// For every element of L1, Binary search L2
			for (E e1 : L1) {
				if (Collections.binarySearch(L2, e1) > -1) {
					L3.add(e1);
				}
			}
		}
		return L3;
	}
}