package Server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import Data.Exam;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

/**
 * 
 * @author Ayala Cohen arbitrator between clients & database
 */
public class MyServer extends AbstractServer {
	/**
	 * mySQL connection
	 */
	JDBCSingleton jdbc;

	/**
	 * constructor, instantiates the database connection
	 * 
	 * @param port The server port to database
	 */
	public MyServer(int port) {
		super(port);
		jdbc = JDBCSingleton.getInstance();
	}

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 */
	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		/* get update duration for exam from client */
		String newDuration, ExamID, str, tmp; /* new exam duration in minutes & exam ID */
		char op;
		int temp;

		System.out.println(this.getClass() + " received msg from client");

		System.out.println(this.getClass().getName() + msg);
		if (!(msg instanceof String)) {
			System.out.println("Server : Invalid message from client !!");
			return;
		}

		str = (String) msg;
		op = str.charAt(0);
		try {
			switch (op) {

			case 'U': /* client says he wants to update the database */
				String decoded[] = str.split("-");
				ExamID = decoded[1];
//				.substring(1, 7); /* ExamID is 6 digit long */
				newDuration = decoded[2];
				// ExamID.substring(7);
				temp = Integer.parseInt(newDuration);
				if (temp < 0) {
					System.out.println("Server : Invalid new duration from client !!");
					break;
				}
				if (jdbc.updateQuery(ExamID, newDuration)) /* update duration in database */
					client.sendToClient("Y"); /* update successful */
				else {
					client.sendToClient("X");/* update unsuccessful */
					break;
				}
			case 'D': /* client says he wants to see the database */
				client.sendToClient("S" + this.jdbc.selectQueryToString());
				break;
			case 'C': /* client says he is disconnected */
				updateClientDetails(client.getInetAddress().getLocalHost(), client.getInetAddress().getHostName(),
						"Disconnected");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hook method called each time a new client connection is accepted. The default
	 * implementation does nothing.
	 * 
	 * @param client the connection connected to the client.
	 */
	protected void clientConnected(ConnectionToClient client) {
		/* output client details */
		System.out.println("client connected...");
		try {
			updateClientDetails(client.getInetAddress().getLocalHost(), client.getInetAddress().getHostName(),
					"Connected");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	private void updateClientDetails(InetAddress ip, String hostName, String status) {
		System.out.println("IP: " + ip + "\tHost: " + hostName + "\tStatus: " + status);
		ServerUI.sb.updateServerBoundary(hostName, ip, status);
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}
}