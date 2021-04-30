package Server;

import javafx.application.Application;
import javafx.stage.Stage;

public class ServerUI extends Application {
	final public static int DEFAULT_PORT = 5555;
	public Stage primaryStage;
	public MyServerBoundary sb;
	public static void main( String args[] ) throws Exception
	   {   
		 launch(args);
	  } // end main
	
	public void start(Stage pS) throws Exception {
		primaryStage =  pS;
		sb = new MyServerBoundary();
		sb.start(primaryStage);
	}
	
//	public static void runServer(String p)
//	{
//		
//	        MyServer sv = new MyServer(DEFAULT_PORT);
//	        
//	        try 
//	        {
//	          sv.listen(); //Start listening for connections
//	        } 
//	        catch (Exception ex) 
//	        {
//	          System.out.println("ERROR - Could not listen for clients!");
//	        }
//	}
//	


}


