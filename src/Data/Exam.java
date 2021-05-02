package Data;

import java.util.ArrayList;

public class Exam {
	private String ExamID = "";
	private int Duration;
	private String Subject = "";
	private String Course = "";
	private String Scores = "";

	public Exam(String ExamID, String Subject, String Course, int Duration, String Scores) {
		this.ExamID = ExamID;
		this.Subject = Subject;
		this.Course = Course;
		this.Duration = Duration;
		this.Scores = Scores;
	}

	public String getExamID() {
		return ExamID;
	}

	public void setExamID(String examID) {
		ExamID = examID;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public void setScores(String scores) {
		Scores = scores;
	}

	public String getScores() {
		return Scores;
	}

	public String getScoresInString() {
		return Scores;
	}
}