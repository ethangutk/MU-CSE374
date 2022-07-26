import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 3, 5, 6));
		LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(2, 4, 7, 7));
		System.out.println("Running...");
		
		List<?> list3 = new Exercise1Shared().exercise01(list2, list1);
		
		System.out.println(list3.size());
		for (Object e1 : list3) {
			System.out.print(e1);
		}
		
		System.out.println("Finished...");
	}
}
