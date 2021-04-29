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
		
	/*	try {
			chat.client.openConnection();
			MyClient.awaitResponse = true;
			chat.client.sendToServer("D");

			while (MyClient.awaitResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			chat.client.quit();
			e.printStackTrace();
		}
*/		
	}
}
