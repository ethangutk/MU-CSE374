public class Exercise6Comparators implements Comparable<Employee> {
	private String name;
	private float age;
	private int experience;
	private boolean punctuality, collegial, dependable, energetic;
	private short disciplined;
	
	@Override
	public int compareTo(Employee employee) {
		if (this.experience < employee.experience)  return -1;
		if (this.experience > employee.experience)  return  1;
		
		if (this.energetic  != employee.energetic)  return -1;
		
		if (this.collegial  != employee.collegial)  return -1;
		
		if (this.dependable != employee.dependable) return -1;
		return 0;
	}

}
