package Server;

import javafx.application.Application;
import javafx.stage.Stage;

public class ServerUI extends Application {
	final public static int DEFAULT_PORT = 5555;
	public Stage primaryStage;
	public static MyServerBoundary sb;
	public static void main( String args[] ) throws Exception
	   {   
		 launch(args);
	  } // end main
	
	public void start(Stage pS) throws Exception {
//		MyServer sv = new MyServer(DEFAULT_PORT);
//        
//        try 
//        {
//          sv.listen(); //Start listening for connections
//        } 
//        catch (Exception ex) 
//        {
//          System.out.println("ERROR - Could not listen for clients!");
//        }
        
		primaryStage =  pS;
		sb = new MyServerBoundary();
		sb.start(primaryStage);
		
	}
	public static void runServer(int p)
	{
		 int port = 0; //Port to listen on

	        try
	        {
	        	port = DEFAULT_PORT; //Set port to 5555
	          
	        }
	        catch(Throwable t)
	        {
	        	System.out.println("ERROR - Could not connect!");
	        }
	    	
	        MyServer sv = new MyServer(port);
	        
	        try 
	        {
	          sv.listen(); //Start listening for connections
	        } 
	        catch (Exception ex) 
	        {
	          System.out.println("ERROR - Could not listen for clients!");
	        }
	}
	
}


