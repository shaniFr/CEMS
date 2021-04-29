package Client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Data.Exam;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewBoundary implements Initializable  {

	@FXML
	private Button btnBack;

	@FXML
	private TableView<Exam> tblView;

	@FXML
	private TableColumn<Exam, String> ExamID;

	@FXML
	private TableColumn<Exam, String> Subject;

	@FXML
	private TableColumn<Exam, String> Course;

	@FXML
	private TableColumn<Exam, Integer> Duration;

	@FXML
	private TableColumn<Exam, String> QScore;
	
	static ObservableList<Exam> data;

	/* converts Exam array list to Observable Exam array list */
	public void getExams(ArrayList<Exam> exams) {
		System.out.println("getexams");
		data = FXCollections.observableArrayList(exams);
	}
	
	public void start(Stage primaryStage) throws Exception {		
		System.out.println("start");
		Parent root = FXMLLoader.load(this.getClass().getResource("/Client/View.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exam Database");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void loadData(ArrayList<Exam> exams) {
		System.out.println("loadata");
		getExams(exams);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("init");
		setTableView();
	}

	private void setTableView() {
		System.out.println("set");
		/* fill table with data */
		tblView.setItems(data);
		
		/* associate data with columns */
		ExamID.setCellValueFactory(new PropertyValueFactory<Exam, String>("ExamID"));
		Subject.setCellValueFactory(new PropertyValueFactory<Exam, String>("Subject"));
		Course.setCellValueFactory(new PropertyValueFactory<Exam, String>("Course"));
		Duration.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("Duration"));
		QScore.setCellValueFactory(new PropertyValueFactory<Exam, String>("QScore"));
	}

}