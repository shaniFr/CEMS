package Data;

import java.util.ArrayList;

public class Exam {
	private String ExamID;
	private int Duration;
	private String Subject;
	private String Course;
	private String Scores;
	
	public Exam(String ExamID, int Duration, String Subject, String Course, String Scores) {
		this.ExamID = ExamID;
		this.Duration = Duration;
		this.Subject = Subject;
		this.Course = Course;
		this.Scores = Scores;
	}
	
	public String toString() {
		ArrayList<String> scores = getScores();
		return "ExamID: " + ExamID + "\tDuration: " + Duration + "\tSubject: " + Subject + "\tCourse: " + Course + "\tScores: " + scores;
	}
	
	public ArrayList<String> getScores() {
		String temp1, temp2;
		ArrayList<String> res = new ArrayList<>();
		int i=0;
		
		if (Scores == null)
			return null;
		
		temp1 = Scores;
		while(i<temp1.length()-3) {
			temp2 = temp1.substring(i, i+3);
			res.add(temp2);
		}
		return res;	
	}
	
}
