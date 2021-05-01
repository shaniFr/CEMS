package Server;

import java.net.InetAddress;

import com.sun.media.jfxmediaimpl.platform.Platform;

import Client.MyClient;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ocsf.server.ConnectionToClient;

public class MyServerBoundary {

//	@FXML
//	private Label lblIP;
//
//	@FXML
//	private Label lblStatus;
//
//	@FXML
//	private Label lblHost;

//    private SimpleStringProperty host = new SimpleStringProperty(this, "host");

//    public String getHost() {
//    	return host.get();
//    }
//    
//    public void setHost(String host) {
//    	this.host.set(host);
//    	System.out.println("setHost  : " + this.host);
//    }
	
	private Label showIp = new Label();
	private Label showHost = new Label();
	private Label showStatus = new Label();
	private Pane root = new Pane();
	private Label ip = new Label();
	private Label host = new Label();
	private Label status = new Label();


	public void start(Stage primaryStage) throws Exception {
		
		ip.setText("IP:");
		host.setText("Host:");
		status.setText("Status:");
		showIp.setText("IP");
		showHost.setText("Host");
		showStatus.setText("Status");
		
		root.getChildren().add(ip);
		ip.setLayoutX(211);
		ip.setLayoutY(108);
		root.getChildren().add(host);
		host.setLayoutX(211);
		host.setLayoutY(167);
		root.getChildren().add(status);
		status.setLayoutX(211);
		status.setLayoutY(239);
		root.getChildren().add(showIp);
		showIp.setLayoutX(307);
		showIp.setLayoutY(108);
		root.getChildren().add(showHost);
		showHost.setLayoutX(298);
		showHost.setLayoutY(167);
		root.getChildren().add(showStatus);
		showStatus.setLayoutX(293);
		showStatus.setLayoutY(239);
		
		primaryStage.setTitle("Server form");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
		
//		lblHost = new Label();

//		lblHost.textProperty().bind(this.host);
//		Parent root = FXMLLoader.load(getClass().getResource("/Server/MyServer.fxml"));
//		Scene scene = new Scene(root);
//		primaryStage.setTitle("Server form");
//		primaryStage.setScene(scene);
		ServerUI.runServer(ServerUI.DEFAULT_PORT);
//		primaryStage.show();

	}

//	public StringProperty hostProperty() {
//		return host;
//	}
//	public Label getIP() {
//		return lblIP;
//	}
	public void updateServerBoundary(String host, InetAddress ip, String status) {
//		showIp.setVisible(false);
//		showHost.setVisible(false);
//		showStatus.setVisible(false);
		
		System.out.println("\n\nwhat\n" + host + ip.toString() + status + "\n");
		javafx.application.Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				showIp.setText(ip.toString());
				showHost.setText(host);
				showStatus.setText(status);
			}
		});
		
		

//		lblIP = new Label();
//		Platform.runLater(() -> {
//			lblIP.setText("a");
////			lblHost.setText("n");
////			lblStatus.setText("c");
//		});
////		System.out.println("update abd " + host);
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
