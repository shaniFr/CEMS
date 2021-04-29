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
	
	ObservableList<Exam> data;
//	final ObservableList<Exam> exams = FXCollections.observableArrayList();
	
	

	/* converts Exam arraylist to Observable Exam array list */
	public ObservableList<Exam> getExams() {
		System.out.println("???");
		final ObservableList<Exam> exams = FXCollections.observableArrayList(new Exam("testExam","some","thing",0,"."), new Exam("exm2","aaaa","bbb",123,".fddf"));
//		exams.add(new Exam("testExam","some","thing",0,"."));
//		exams.add(new Exam("exm2","aaaa","bbb",123,".fddf"));
		return exams;
	}
	
	public void start(Stage primaryStage) throws Exception {	
//		System.out.println("startr..");
//		final ObservableList<Exam> data = FXCollections.observableArrayList(new Exam("testExam","some","thing",0,"."), new Exam("exm2","aaaa","bbb",123,".fddf"));

		
		
//		ExamID = new TableColumn<>("ExamID");
//		Subject = new TableColumn<>("Subject");
//		Course = new TableColumn<>("Course");
//		Duration= new TableColumn<>("Duration");
//		QScore = new TableColumn<>("QScore");
//		tblView.getColumns().addAll(ExamID,Subject,Course,Duration,QScore);
//		
//		/* associate data with columns */
//		ExamID.setCellValueFactory(new PropertyValueFactory<Exam, String>("ExamID"));
//		Subject.setCellValueFactory(new PropertyValueFactory<Exam, String>("Subject"));
//		Course.setCellValueFactory(new PropertyValueFactory<Exam, String>("Course"));
//		Duration.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("Duration"));
//		QScore.setCellValueFactory(new PropertyValueFactory<Exam, String>("QScore"));
//		
//		/* set data in table */
//		tblView.setItems(data);
//		final ObservableList<Exam> data = FXCollections.observableArrayList(new Exam("testExam","some","thing",0,"."), new Exam("exm2","aaaa","bbb",123,".fddf"));
//
//		tblView = new TableView<>();
//		
//		ExamID = new TableColumn<>("ExamID");
//		Subject = new TableColumn<>("Subject");
//		Course = new TableColumn<>("Course");
//		Duration= new TableColumn<>("Duration");
//		QScore = new TableColumn<>("QScore");
//		tblView.getColumns().addAll(ExamID,Subject,Course,Duration,QScore);
//		
//		/* associate data with columns */
//		ExamID.setCellValueFactory(new PropertyValueFactory<Exam, String>("ExamID"));
//		Subject.setCellValueFactory(new PropertyValueFactory<Exam, String>("Subject"));
//		Course.setCellValueFactory(new PropertyValueFactory<Exam, String>("Course"));
//		Duration.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("Duration"));
//		QScore.setCellValueFactory(new PropertyValueFactory<Exam, String>("QScore"));
//		
//		/* set data in table */
//		tblView.setItems(data);
		
		
//		//		/* ExamID column */
//		ExamID = new TableColumn<>("ExamID");
////		ExamID.setMinWidth(100);
//		ExamID.setCellValueFactory(new PropertyValueFactory<>("examID"));
//		
//		/* Subject column */
//		Subject = new TableColumn<>("Subject");
////		Subject.setMinWidth(100);
//		Subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
//		
//		/* Course column */
//		Course = new TableColumn<>("Course");
////		Course.setMinWidth(100);
//		Course.setCellValueFactory(new PropertyValueFactory<>("course"));
//		
//		/* Duration column */
//		Duration= new TableColumn<>("Duration");
////		Duration.setMinWidth(100);
//		Duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
//		
//		/* QScore column */
//		QScore = new TableColumn<>("QScore");
////		QScore.setMinWidth(100);
//		QScore.setCellValueFactory(new PropertyValueFactory<>("qScore"));
//		
		/* set up the table */
		
		
//		tblView.getColumns().addAll(ExamID,Subject,Course,Duration,QScore);
		
		
		
		Parent root = FXMLLoader.load(this.getClass().getResource("/Client/View.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Exam Database");
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tblView = new TableView<>(getExams());
//		ExamID = new TableColumn<>("ExamID");
//		Subject = new TableColumn<>("Subject");
//		Course = new TableColumn<>("Course");
//		Duration= new TableColumn<>("Duration");
//		QScore = new TableColumn<>("QScore");
//		tblView.getColumns().addAll(ExamID,Subject,Course,Duration,QScore);
		
		/* associate data with columns */
		ExamID.setCellValueFactory(new PropertyValueFactory<Exam, String>("ExamID"));
		Subject.setCellValueFactory(new PropertyValueFactory<Exam, String>("Subject"));
		Course.setCellValueFactory(new PropertyValueFactory<Exam, String>("Course"));
		Duration.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("Duration"));
		QScore.setCellValueFactory(new PropertyValueFactory<Exam, String>("QScore"));
		
		/* set data in table */
//		tblView.setItems(data);		
	}

}