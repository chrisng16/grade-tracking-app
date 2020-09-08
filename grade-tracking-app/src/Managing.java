import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Managing implements Serializable {

	private static final long serialVersionUID = -2301011962178459787L;
	private ArrayList<Subject> subjects;
	private String[] subjectNamesArray;
	// Constructor of tracking
	public Managing() {
		subjects = loadData();
	}

	public String addSubject(Subject subject) {
		subjects.add(subject);
		return subject.getName()+" is added."
				+"\nQuiz Percent: "+subject.getQuizPercent()
				+"\nMidterm Percent: "+subject.getMidtermPercent()
				+"\nFinal Percent: "+subject.getFinalPercent();
	}
	// Check if a subject already in the subjectNamesArray
	public boolean isInSubjectNameArray(String subjectName){
		if (subjects.size()==0)
			return false;
		getSubjectNames();
		for (String name: subjectNamesArray) {
			if (name.contains(subjectName))
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
    	subjectNamesArray = names.toArray(new String[names.size()]);;
    	return subjectNamesArray;
	}

	// Add score to certain subject
	public String addScore(String subjectName, String type, int score){
        return getSubject(subjectName).addScore(type, score);
	}
	// Get a subject by name to do things
	private Subject getSubject(String subjectName){
		Subject temp = new Subject("temp",0,0,0);
		for(Subject s: subjects){
			if (s.getName().equals(subjectName))
				temp=s;
		}
		return temp;
	}
	
	public String getReport(String type) {
		StringBuilder report = new StringBuilder();
		if (type == "ALL") {
			for (Subject s: subjects) {
				report.append(s.report());
			}
		}
		else
			report.append(getSubject(type).report());
		return report.toString();
	}
	
	public void saveData() {
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(subjects);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("data.ser");
			ObjectOutputStream obj = new ObjectOutputStream(fileOut);
			obj.writeObject(data);
			obj.close();
			fileOut.close();
			
		} catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Subject> loadData() {
		ArrayList<Object> deserialized = new ArrayList<Object>();
		File f = new File("data.ser");
		if (f.exists() && f.isFile()) {
			try {
				DeleteOnCloseFileInputStream fileIn = new DeleteOnCloseFileInputStream("data.ser");
				ObjectInputStream obj = new ObjectInputStream(fileIn);
				deserialized = (ArrayList<Object>) obj.readObject();
				obj.close();
				fileIn.close();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return (ArrayList<Subject>) deserialized.get(0);
		}
		else
			return new ArrayList<Subject>();
	}
}
