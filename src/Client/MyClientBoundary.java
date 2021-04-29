package Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyClientBoundary {
	
    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;
    
    public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/Client/MyClient.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("User form");
		primaryStage.setScene(scene);
		
		primaryStage.show();	 	   
	}
}