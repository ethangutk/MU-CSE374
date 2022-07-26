import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise9Force <E extends Comparable<?super E>> {
	public List<E> wrapper(List<E> list) {
		Map<E, Integer> map = new HashMap<>();
		int index = 0;
		
		for (E e : list) {
			map.put(e, index);
			index++;
		}
		
		// Sort
		
		//Return list
		
		return list;
	}
	
	
	
}
