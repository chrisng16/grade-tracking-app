import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable {

	private static final long serialVersionUID = 6247879941746885027L;
	private String name;
	private double quizPercent;
	private double midtermPercent;
	private double finalPercent;
	private double GPA;
	private char letterGrade;
	private double quizAvg, midtermAvg;
	private ArrayList<Integer> quizScores;
	private ArrayList<Integer> midtermScores;
	private int finalScore;
	
	public Subject(String name, int quizPercent, int midtermPercent, int finalPercent) {
		this.name = name;
		setPercent(quizPercent,midtermPercent,finalPercent);
		quizScores = new ArrayList<Integer>();
		midtermScores = new ArrayList<Integer>();
	}
	// Getters for percentage
	public int getQuizPercent() {
		return (int)(quizPercent*100);
	}
	public int getMidtermPercent() {
		return (int)(midtermPercent*100);
	}
	public int getFinalPercent() {
		return (int)(finalPercent*100);
	}
	// Add score
	public String addScore(String type, int score) {
		if (type == "Quiz"){
			quizScores.add(score);
		}
		else if (type == "Midterm") {
			midtermScores.add(score);
		}
		else if (type == "Final") {
			this.finalScore = score;
		}
		else
			return "Error";
		
		return type +" score added to "+ name;
	}
	// Calculate GPA
	private void calculateGPA() {
		int quizTotal=0,midtermTotal=0;
		for (int quiz: quizScores) {
			quizTotal+=quiz;
		}
		System.out.println(quizTotal);
		quizAvg=(double)quizTotal/(double)(quizScores.size());
		for (int midterm: midtermScores) {
			midtermTotal+=midterm;
		}
		midtermAvg=(double)midtermTotal/(double)(midtermScores.size());
		System.out.println(midtermTotal);
		if (finalScore!=0) {
			GPA=midtermAvg*midtermPercent+quizAvg*quizPercent+(double)finalScore*finalPercent;
			calculateLetterGrade(GPA);
		}
	}
	// Set percentage for each type
	private void setPercent(int quiz, int midterm, int fin) {
		this.quizPercent=(double)quiz/100;
		this.midtermPercent=(double)midterm/100;
		this.finalPercent=(double)fin/100;
	}
	
	private void calculateLetterGrade(double GPA) {
		if (GPA <=100 && GPA>=90) letterGrade='A';
		else if (GPA <90 && GPA>=80) letterGrade='B';
		else if (GPA <80 && GPA>=70) letterGrade='C';
		else if (GPA <70 && GPA>=60) letterGrade='D';
		else if (GPA <60) letterGrade='F';
	}
	
	// Show report
	public String report() {
		calculateGPA();
		StringBuilder report = new StringBuilder();
		report.append("Subject: "+name
					+"\nQuiz Average: "+ round(quizAvg)
					+"\nMidterm Average: "+round(midtermAvg)
					+"\nFinal Score: "+finalScore
					+"\nGPA: "+round(this.GPA)
					+"\nLetter Grade: "+this.letterGrade
					+"\n\n");
		return report.toString();
	}
	public String getName() {
		return this.name;
	}
	// Round quiz and midterm average to two decimals
	private double round(double number) {
		double temp = Math.floor(number*100)/100;
		System.out.println(temp);
		return temp;
	}
}
