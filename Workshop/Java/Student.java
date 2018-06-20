public class Student{

	private int rollNo;
	private String name;
	public static String universityName="Oxford";

	public Student(int rollNo,String name){
		this.rollNo=rollNo;
		this.name=name;
	}

	public void getStudentDetails(){
		System.out.println("Roll Number "+rollNo+" Name  "+name+" University name  "+universityName);

	}

	public void setStudentDetails(int rollNo,String name){
		this.rollNo=rollNo;
		this.name=name;

	}
}