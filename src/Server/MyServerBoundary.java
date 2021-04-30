package Server;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyServerBoundary {

	@FXML
	private Label lblIP;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblHost;

//    private SimpleStringProperty host = new SimpleStringProperty(this, "host");

//    public String getHost() {
//    	return host.get();
//    }
//    
//    public void setHost(String host) {
//    	this.host.set(host);
//    	System.out.println("setHost  : " + this.host);
//    }

	public void start(Stage primaryStage) throws Exception {
//		lblHost = new Label();

//		lblHost.textProperty().bind(this.host);
		Parent root = FXMLLoader.load(getClass().getResource("/Server/MyServer.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Server form");
		primaryStage.setScene(scene);
		ServerUI.runServer(ServerUI.DEFAULT_PORT);
		primaryStage.show();

	}

//	public StringProperty hostProperty() {
//		return host;
//	}
	public Label getIP() {
		return lblIP;
	}
	public void updateServerBoundary(String host, String ip, String status) {
		lblIP = new Label();
		Platform.runLater(() -> {
			lblIP.setText("a");
//			lblHost.setText("n");
//			lblStatus.setText("c");
		});
//		System.out.println("update abd " + host);
//		System.out.println("host - " + host);
//		lblStatus.setText("abd");
//		lblHost.textProperty().bind(this.host);
//		setHost("abcd");
//		System.out.println("this " + this.host);
		// System.out.println("1");
//		System.out.println(this.getClass().getName() + " update client status");
//		this.host = host;
//		this.ip=ip;
//		this.status=status;
//		ActionEvent event = new ActionEvent();
//		updateServerGUI();
	}

//	void updateServerGUI() {
//		this.lblHost.setText("1");
//		this.lblIP.setText("2");
//		this.lblStatus.setText("3");
//		
//		System.out.println("2");
//		lblStatus = new Label();
//		lblStatus.setText("something");
//		System.out.println(lblStatus.getText());
//		System.out.println(lblStatus);
////		System.out.println("ypdateservergui");
//		lblStatus.setText("sdjjsdjdjdjdjjjdd");

//		lblIP.setText(ip);
//		Platform.runLater(()->{
//			lblStatus.setText("abbbcc");
//	    });
//		System.out.println("update server gui ");
//		System.out.println("text field status = " + lblIP.getText());
}
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		System.out.println("initialize..");
//		lblStatus = new Label("a");
//		System.out.println(lblStatus.getText());
//		lblHost = new Label("b");
//		lblIP = new Label("c");
//		
//	}
