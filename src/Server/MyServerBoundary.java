package Server;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class MyServerBoundary extends Application {
    @FXML
    private Label lblConnectedIp;

    @FXML
    private Text txtHost; //

    @FXML
    private Text txtStatus; //

    @FXML
    private Label lblConnectionStatus;

    @FXML
    private Label lblHostName;

    @FXML
    private Text txtIP; //
	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;
	
	
	
	/**
	 * Launches server application
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception
	   {   
		 launch(args);
	  } // end main

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub				  		
//		ServerPortFrameController aFrame = new ServerPortFrameController(); // create StudentFrame
		 
//		aFrame.start(primaryStage);
	}
	
	/**
	 * Fetches port& runs server under port name
	 * @param p		Server port
	 */
	public static void runServer(String p) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(p); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		MyServer sv = new MyServer(port);

		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
}
