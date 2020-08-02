import java.util.ArrayList;

public class Tracking {
	private ArrayList<Subject> subjects;
	
	public Tracking() {
		subjects = new ArrayList<Subject>();
	}
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	public ArrayList<Subject> getSubjects(){
		return this.subjects;
	}
	public Subject getSubject(String subjectName){
		System.out.println(subjectName);
		Subject temp = new Subject("temp");
		for(Subject s: subjects){
			if (s.getName()==subjectName)
				temp=s;
		}
		return temp;
	}
}
