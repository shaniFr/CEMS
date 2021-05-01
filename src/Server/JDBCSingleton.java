package Server;

import java.sql.*;
import java.util.ArrayList;

import Data.Exam;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
/**
 * 
 * @author Ayala Cohen
 * 
 *         holds connection to the mySQL database singleton - there is only 1
 *         instance of the JDBC connector
 * 
 */
public class JDBCSingleton {
	int temp;
	/**
	 * handle to this class
	 */
	private static JDBCSingleton jdbc = null;
	/**
	 * handle to connection
	 */
	private Connection con;

	/**
	 * constructor, called only once by getInstance() method
	 */
	private JDBCSingleton() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/cems?serverTimezone=IST", "root",
					"Aa123456");
			System.out.println(con);
			System.out.println("SQL connection succeed");
		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

	/**
	 * 
	 * @return instance of the database connector
	 */
	public static JDBCSingleton getInstance() {
		if (jdbc == null)
			jdbc = new JDBCSingleton();

		return jdbc;
	}

	/**
	 * 
	 * @param id     Exam ID that will have its duration updated
	 * @param newdur New duration for given exam ID
	 * @return
	 */
	public boolean updateQuery(String id, String newdur) {
		int duration = Integer.parseInt(newdur);
		Statement stmt;

		try {
			stmt = con.createStatement();
			 temp = stmt.executeUpdate("update test set Duration='" + duration + "' where ExamID='" + id + "';");
		} catch (SQLException e) {
			//e.printStackTrace();
			return false; /* update database unsuccessful */
		}
		if(temp==0) return false;
		return true;
	}


	public String selectQueryToString() {
		Statement stmt;
		ResultSet rs;
		String id, sub, cour, scores, result="";
		
		int dur;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from test");
			while (rs.next()) {
				// get values from database
				id = rs.getString(1);
				sub = rs.getString(2);
				cour = rs.getString(3);
				dur = rs.getInt(4);
				scores = rs.getString(5);
				result += id + "-" + sub + "-" + cour + "-" + dur + "-" + scores +"-";
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
//	public ArrayList<Exam> selectQuery() {
//		Statement stmt;
//		ResultSet rs;
//		Exam newExam;
//		ArrayList<Exam> examlist = new ArrayList<>();
//		String id, sub, cour, scores;
//		
//		int dur;
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("select * from test");
//			while (rs.next()) {
//				// get values from database
//				id = rs.getString(1);
//				sub = rs.getString(2);
//				cour = rs.getString(3);
//				dur = rs.getInt(4);
//				scores = rs.getString(5);
//
//				newExam = new Exam(id, dur, sub, cour, scores);
//				examlist.add(newExam);
//			}
//			
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return examlist;
//
//		
//	}
}
