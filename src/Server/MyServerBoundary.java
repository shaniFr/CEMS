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
	private Pane root = new Pane();
	private Label ip = new Label();
	private Label host = new Label();
	private Label status = new Label();
	private Label showIp = new Label();
	private Label showHost = new Label();
	private Label showStatus = new Label();

	/**
	 * creating and initializing our labels
	 * @param primaryStage
	 * @throws Exception
	 */
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

		ServerUI.runServer(ServerUI.DEFAULT_PORT);

	}

	public void updateServerBoundary(String host, InetAddress ip, String status) {
		javafx.application.Platform.runLater(new Runnable() {
			@Override
			public void run() {
				showIp.setText(ip.toString());
				showHost.setText(host);
				showStatus.setText(status);
			}
		});
	}
}