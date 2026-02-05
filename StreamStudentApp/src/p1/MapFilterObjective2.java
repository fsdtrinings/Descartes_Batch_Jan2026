package p1;

import java.util.*;
import java.util.stream.Collectors;

public class MapFilterObjective2 {
	
	public static void main(String[] args) {
		
		
		Map<String,List<Student>> allStudents;
		 
		
			List<Student> javaStudents = new ArrayList<>();
			List<Student> awsStudents = new ArrayList<>();
			List<Student> htmlStudents = new ArrayList<>();
			
			
			javaStudents.add(new Student("John",88,"java"));
			javaStudents.add(new Student("Alice",56,"java"));
			javaStudents.add(new Student("Lily",92,"java"));
		
			awsStudents.add(new Student("Steve",95,"aws"));
			awsStudents.add(new Student("Oliver",88,"aws"));
			awsStudents.add(new Student("Jane",67,"aws"));
			
			
			htmlStudents.add(new Student("hello",67,"Html"));
			
			
			
			allStudents = new HashMap<>();
			allStudents.put("java", javaStudents);
			allStudents.put("aws", awsStudents);
			allStudents.put("html", htmlStudents);
			
		
			// -------- get the Students above 80 marks -----------------------------------------------
			//    problem : also select the category with empty student list
			Map<String,Set<Student>> toppers = allStudents.entrySet().stream()
					.collect(Collectors.toMap(
							 entry->entry.getKey()
							, 
							  entry->entry.getValue().stream()
							                       .filter((stu->stu.getMarks()>80))
							                       .collect(Collectors.toSet())
							));
		
			for (Map.Entry<String, Set<Student>> entry : toppers.entrySet()) {
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
				System.out.println("------------------------------------------------");
			}
				System.out.println("\n\n\n through groupingBy");
			// -------------------------------------------------------------------------
			//  ---------- Solution of the above issue ------------------
				
				
		Map<String,List<Student>> topStudentSetBySubject = 
                        allStudents.values().stream().		
                        					flatMap(list->list.stream()).
                        									   filter(student->{
                        										   			if(student.getMarks()>=80)return true;
                        										   			return false;
                        									   })
                                                      .collect(Collectors
                                                    		    .groupingBy(student->student.getSubject()));

				
		for (Map.Entry<String, List<Student>> entry2 : topStudentSetBySubject.entrySet()) {
			System.out.println(entry2.getKey());
			System.out.println(entry2.getValue());
			System.out.println("------------------------------------------------");
				
				
			}
			
		
	

}//end main
}//end class
















