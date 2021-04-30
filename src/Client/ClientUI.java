package Client;

import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {
	public static ClientController chat;
	public MyClientBoundary bd;
	public Stage primaryStage;
	public static void main(String[] args) {
		
		launch(args); 
	}
	
	@Override
	public void start(Stage pS) throws Exception {
		chat = new ClientController("localhost", 5555);
		primaryStage = pS;
		bd = new MyClientBoundary();
		bd.start(primaryStage);
				
	}
}
