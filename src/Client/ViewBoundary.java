package Client;

import java.util.ArrayList;

import Data.Exam;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ViewBoundary {

	@FXML
	private Button btnBack;

	@FXML
	private TableView<?> tblView;

	@FXML
	private static TableColumn<?, ?> ExamID;

	@FXML
	private TableColumn<?, ?> Subject;

	@FXML
	private TableColumn<?, ?> Course;

	@FXML
	private TableColumn<?, ?> Duration;

	@FXML
	private TableColumn<?, ?> QScore;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/ViewDataBase.fxml"));

		Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("/gui/AcademicFrame.css").toExternalForm());

		primaryStage.setTitle("View DataBase");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void loadData(ArrayList<Exam> decodeMessageFromServer) {
//		ExamID.setCellValueFactory(decodeMessageFromServer.g);
		ArrayList<Exam> examTable = new ArrayList<>();
		String[] decodedMsg = null;
		for (int i = 0; i < decodedMsg.length / 5; i++) {
			decodeMessageFromServer.get(i);
		}
	}
}