package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Ayala Cohen
 * 
 * holds connection to the mySQL database
 * singleton - there is only 1 instance of the JDBC connector
 * 
 */
public class JDBCSingleton { 
	/**
	 * handle to this class
	 */
	private static JDBCSingleton jdbc=null;
	/**
	 * handle to connection
	 */
	private static Connection con;
	/**
	 * constructor, called only once by getInstance() method
	 */
	private JDBCSingleton() { 
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
        	 }
        
        try 
        {
        	Connection con =
        			DriverManager.getConnection("jdbc:mysql://localhost/cems?serverTimezone=IST","root","Aa123456");
            System.out.println("SQL connection succeed");
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
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

//	public static void main(String[] args) 
//	{
//		try 
//		{
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//            System.out.println("Driver definition succeed");
//        } catch (Exception ex) {
//        	/* handle the error*/
//        	 System.out.println("Driver definition failed");
//        	 }
//        
//        try 
//        {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test/world?serverTimezone=IST","root","Aa123456");
//            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
//            System.out.println("SQL connection succeed");
//            //createTableCourses(conn);
//     	} catch (SQLException ex) 
//     	    {/* handle any errors*/
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//            }
//   	}
}
