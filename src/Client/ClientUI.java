package Client;

import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {
	public static void main(String[] args) {
		launch(args); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ViewBoundary bd = new ViewBoundary();
		bd.start(primaryStage);
	}
}
