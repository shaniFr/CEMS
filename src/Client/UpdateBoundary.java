package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateBoundary {

	
    @FXML
    private Button btnBack;
    @FXML
    private Label lblExamDuration;

    @FXML
    private TextField txtExamID;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblExamID;

    @FXML
    private TextField txtNewDuration;

    public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("/Client/Update.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Update Exam");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    
    
    @FXML
    public void Save(ActionEvent event) throws Exception {
		/* send message to client controller */
		String temp = "U" + "-" + this.txtExamID.getText() + "-" + this.txtNewDuration.getText() + "-";
		System.out.println(this.getClass().getName() + "save : " + temp);
		ClientUI.chat.accept(temp);
	}
    
    @FXML
	void backMain(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide(); //hide primary window
		MyClientBoundary mcb = new MyClientBoundary();
		Stage primaryStage = new Stage();
		try {
			mcb.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
