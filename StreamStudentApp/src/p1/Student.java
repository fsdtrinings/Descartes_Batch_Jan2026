package p1;

public class Student {

	private String name;
	private int marks;
	private String subject;
	
	
	public Student(String name, int marks, String subject) {
		super();
		this.name = name;
		this.marks = marks;
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", subject=" + subject + "]";
	}
	
	
}
