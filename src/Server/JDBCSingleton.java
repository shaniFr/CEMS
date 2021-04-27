package Server;

import java.sql.*;

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
 * @param id		Exam ID that will have its duration updated
 * @param newdur	New duration for given exam ID
 * @return
 */
	public boolean updateQuery(String id, String newdur) {
		int duration = Integer.parseInt(newdur);
		Statement stmt;

		try {
			stmt = con.createStatement();
			stmt.executeUpdate("update test set Duration='" + duration + "' where ExamID='" + id + "';");
		} catch (SQLException e) {
			e.printStackTrace();
			return false; /* update database unsuccessful */
		}
		return true;
	}
}
