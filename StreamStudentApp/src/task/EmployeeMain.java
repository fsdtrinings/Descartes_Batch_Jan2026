package task;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {

	static List<Employee> list = new ArrayList<>();

	static {
		Employee e1 = new Employee("Raj", 430000, "Manager", "IT");
		Employee e2 = new Employee("Amit", 435000, "Manager", "HR");
		Employee e3 = new Employee("Samay", 84000, "Analyst", "Tech");
		Employee e4 = new Employee("Suman", 56000, "Intern", "IT");
		Employee e5 = new Employee("Ashna", 560000, "Intern", "IT");

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
	}

	public static void main(String[] args) {

		getDepartmentByTotalSalaryPaid();

		getAvgSalaryofManagers();
	}

	public static Map<String, List<Employee>> groupEmployeesByDepartment() {

		Map<String, List<Employee>> employeesByDept = list.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment()));

		for (Map.Entry<String, List<Employee>> entry : employeesByDept.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

		return employeesByDept;
	}

	public static void getAvgSalaryofManagerByDepartment() {

		Map<String, List<Employee>> groupedEmployees = groupEmployeesByDepartment();
	
		Map<String, Integer> totalSalaryByDept =
				groupedEmployees.entrySet()
    		                 .stream()
    		                 .collect(Collectors.toMap(
    		                     entry -> entry.getKey(),
    		                     entry -> entry.getValue()
    		                                   .stream()
    		                                   .collect(Collectors.summingInt(emp -> emp.getSalary()))
    		                 ));

	
	}

	public static void getAvgSalaryofManagers() {
		double managerAvgSalary = list.stream().filter((emp) -> emp.getDesignation().equalsIgnoreCase("manager"))
				.collect(Collectors.averagingDouble(emp -> emp.getSalary()));

		System.out.println(managerAvgSalary);
	}

	public static void getDepartmentByTotalSalaryPaid() {
		Map<String, Integer> departmentsByTotalSalary = list.stream().collect(
				Collectors.groupingBy((emp) -> emp.getDepartment(), Collectors.summingInt(emp -> emp.getSalary())));

		display(departmentsByTotalSalary, "Department by Total Salary Paid "); // gives an error
	}

	public static void display(Map<String, ? extends Number> map, String tagLine) {
		System.out.println("\n\n============  " + tagLine + "  =========================\n");
		for (Map.Entry<String, ? extends Number> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

}// end class
