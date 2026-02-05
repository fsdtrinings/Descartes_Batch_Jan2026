package task;

public class Employee {
	private String name;
	private int salary;
	private String designation;
	private String department;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int salary, String designation, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", designation=" + designation + ", department="
				+ department + "]";
	}
	
	
}
