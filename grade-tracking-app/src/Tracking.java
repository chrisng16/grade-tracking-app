import java.util.ArrayList;

public class Tracking {
	private ArrayList<Subject> subjects;
	private String[] subjectNamesArray;
	
	public Tracking() {
		subjects = new ArrayList<Subject>();
	}

	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public boolean isInSubjectNameArray(String subjectName){
		if (subjects.size()==0)
			return false;
		for (String name: subjectNamesArray) {
			if (subjectName.toLowerCase() == name.toLowerCase())
				return true;
		}
		return false;
	}

	// Get subject name array to display in addScoreFrame JComboBox
	public String[] getSubjectNames() {
    	ArrayList<String> names = new ArrayList<String>();
    	for (Subject s: subjects) {
    		names.add(s.getName());
    	}
    	subjectNamesArray = names.toArray(new String[names.size()]);
    	System.out.println(subjectNamesArray.length);
    	return subjectNamesArray;
	}

	// Add score to certain subject
	public void addScore(String subjectName, String type, int score){
        getSubject(subjectName).addScore(type, score);
	}
	private Subject getSubject(String subjectName){
		System.out.println(subjectName);
		Subject temp = new Subject("temp");
		for(Subject s: subjects){
			if (s.getName()==subjectName)
				temp=s;
		}
		return temp;
	}
}
