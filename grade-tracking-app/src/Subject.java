import java.util.ArrayList;

public class Subject {
	private String name;
	private double quizPercent;
	private double midtermPercent;
	private double finalPercent;
	private double GPA;
	private ArrayList<Integer> quizScores;
	private ArrayList<Integer> midtermScores;
	private int finalScore;
	
	public Subject(String name) {
		this.name = name;
		quizScores = new ArrayList<Integer>();
		midtermScores = new ArrayList<Integer>();
	}
	// Add score
	public void addScore(String type, int score) {
		if (type == "Quiz"){
			quizScores.add(score);
			System.out.println("Quiz Score Added!");
		}
		else if (type == "Midterm") {
			midtermScores.add(score);
			System.out.println("Midterm Score Added!");
		}
		else if (type == "Final") {
			this.finalScore = score;
			System.out.println("Final Score Added!");
		}
		else
			System.out.println("Error");
	}
	// Calculate GPA
	public void calculateGPA() {
		int quizTotal=0,midtermTotal=0;
		for (int quiz: quizScores) quizTotal+=quiz;
		for (int midterm: midtermScores) midtermTotal+=midterm;
		GPA=midtermTotal*midtermPercent+quizTotal*quizPercent+finalScore*finalPercent;
	}
	// Set percentage for each type
	public void setPercent(int quiz, int midterm, int fin) {
		this.quizPercent=(double)quiz/100;
		this.finalPercent=(double)midterm/100;
		this.finalPercent=(double)fin/100;
	}
	// Show report
	public String report() {
		StringBuilder report = new StringBuilder();
		report.append("Subject: "+name
					+"\nGPA: "+this.GPA);
		return report.toString();
	}
	public String getName() {
		return this.name;
	}
}
