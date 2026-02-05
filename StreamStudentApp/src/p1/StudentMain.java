package p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentMain {

	
	Map<String, Student> allStudents ;
	
	public StudentMain() {
	
		allStudents = new HashMap<>();
		
		allStudents.put("Java", new Student("A", 78, "Java"));
		allStudents.put("AWS", new Student("erfA", 8, "Java"));
		allStudents.put("Salesforce", new Student("Adf", 98, "PJava"));
		allStudents.put("MS-Dynamics", new Student("sdAass", 88, "retJava"));
		allStudents.put("Python", new Student("sdfA", 89, "gfbJava"));
		
	}
	
	
	public static void main(String[] args) {
		
		StudentMain mainObj = new StudentMain();
		// collect the students having marks > 80
		// -------- approach - 1----------
		Set<Student> set1 = mainObj.allStudents.values()
				          .stream()
				          .filter((entry)->entry.getMarks()>80)
				          .collect(Collectors.toSet());
		
		// ---- approach - 2------------------
		Set<Student> set2 = mainObj.allStudents.entrySet()
		          .stream()
		          .filter((entry)->entry.getValue().getMarks()>80)
		          .map((entry)->{
		        	  // -------
		        	  return entry.getValue();
		          })
		          .collect(Collectors.toSet());

		
		
	}
}









