package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
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