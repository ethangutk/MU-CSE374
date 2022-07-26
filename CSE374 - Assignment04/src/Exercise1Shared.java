import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exercise1Shared <E extends Comparable<?super E>> {	
	public List<E> exercise01(List<E> L1, List<E> L2) {
		Collections.sort(L1);
		Collections.sort(L2);
		List<E> L3 = new LinkedList<>();

		Iterator<E> it1 = L1.iterator(), it2 = L2.iterator();
		E nextItem1 = it1.next(),        nextItem2 = it2.next();
		
		while ( (it1.hasNext()) && (it2.hasNext() ) ) {
			
			if (nextItem1.equals(nextItem2)) {
				L3.add(nextItem1);
				nextItem1 = it1.next();
				nextItem2 = it2.next();
			} else if (nextItem1.compareTo(nextItem2) < 0) {
				nextItem1 = it1.next();
			} else
				nextItem2 = it2.next();
		}
		return L3;
	}
}
