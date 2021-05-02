package Client;

import java.io.IOException;
import java.util.Optional;

import Server.MyServerBoundary;
import Server.ServerUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent event) {

		        // consume event
		        event.consume();

		        // show close dialog
		        Alert alert = new Alert(AlertType.CONFIRMATION);
		        alert.setTitle("Close Confirmation");
		        alert.setHeaderText("Do you really want to quit?");
		        alert.initOwner( primaryStage);

		        Optional<ButtonType> result = alert.showAndWait();
		        if (result.get() == ButtonType.OK){
		            ClientUI.chat.client.quit();
		        	Platform.exit();
		        }
		    }
		});
		
	}

	@FXML
	void viewServer(ActionEvent event) {
		ClientUI.chat.accept("D");
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		ViewBoundary vb = new ViewBoundary();
		Stage primaryStage = new Stage();
		try {
			vb.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void updateServer(ActionEvent event) {
//		ClientUI.chat.accept("U");
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		UpdateBoundary ub = new UpdateBoundary();
		Stage primaryStage = new Stage();
		try {
			ub.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}