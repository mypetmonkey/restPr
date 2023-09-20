package pojoclass;

public class Student {
	String name;
	int age;
	long phno;
	String subject[];
	
	
	public Student(String name,int age,long phno,String subject[]) {
		this.name=name;
		this.age=age;
		this.phno=phno;
		this.subject=subject;
	}
	public Student() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String[] getSubject() {
		return subject;
	}
	public void setSubject(String[] subject) {
		this.subject = subject;
	}

}
