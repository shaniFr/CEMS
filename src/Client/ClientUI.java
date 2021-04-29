package Client;

import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {
	public static ClientController chat;
	ViewBoundary bd;
	
	public static void main(String[] args) {
		
		launch(args); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		chat = new ClientController("localhost", 5555);
		System.out.println(this.getClass());
//		ViewBoundary bd = new ViewBoundary();
//		bd = new ViewBoundary();
//		bd.start(primaryStage);
	}
}
