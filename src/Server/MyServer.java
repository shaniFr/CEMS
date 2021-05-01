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
//	/**
//	 * The default port to listen on.
//	 */
//	final public static int DEFAULT_PORT = 5555;

	/**
	 * constructor, instantiates the database connection
	 * 
	 * @param port The server port to database
	 */
//	MyObservableServer myObserableServer;
	
	public MyServer(int port) {
		super(port);
		jdbc = JDBCSingleton.getInstance();
//		myObserableServer = new MyObservableServer(port);
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
				//ExamID.substring(7);
				temp = Integer.parseInt(newDuration);
				if (temp < 0) {
					System.out.println("Server : Invalid new duration from client !!");
					break;
				}
				if (jdbc.updateQuery(ExamID, newDuration)) /* update duration in database */
					client.sendToClient("Y"); /* update successful */
				else
					{client.sendToClient("X");/* update unsuccessful */
			     	break;}
			case 'D': /* client says he wants to see the database */
				client.sendToClient("S" + this.jdbc.selectQueryToString());
				break;
			case 'C': /* client says he is disconnected */
				updateClientDetails(client.getInetAddress().getLocalHost(), client.getInetAddress().getHostName(), "Disconnected");
				System.out.println("myserver - got a c");
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
			updateClientDetails(client.getInetAddress().getLocalHost(), client.getInetAddress().getHostName(), "Connected");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	private void updateClientDetails(InetAddress ip, String hostName, String status) {
		System.out.println("...IP: " + ip + "\tHost: " + hostName + "\t\tStatus: " + status);
		ServerUI.sb.updateServerBoundary(hostName, "something", status);
	}

	/**
	 * Hook method called each time a client disconnects. The default implementation
	 * does nothing. The method may be overridden by subclasses but should remains
	 * synchronized.
	 *
	 * @param client the connection with the client.
//	 */
//	synchronized protected void clientDisconnected(ConnectionToClient client) {
//		System.out.println("are you getting here?");
//		System.out.println("Port: " + this.getPort() + "\tHost: " + client.getInetAddress().getHostName()
//				+ "\tStatus: Disconnected");
//	}

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

	/**
	 * This method is responsible for the creation of the server instance (there is
	 * no UI in this phase).
	 *
	 * @param args[0] The port number to listen on. Defaults to 5555 if no argument
	 *                is entered.
	 */
//	public static void main(String[] args) {
//		int port = 0; // Port to listen on
//
//		try {
//			port = Integer.parseInt(args[0]); // Get port from command line
//		} catch (Throwable t) {
//			port = 5555; // Set port to 5555
//		}
//
//		MyServer sv = new MyServer(port);
//
//		try {
//			sv.listen(); // Start listening for connections
//		} catch (Exception ex) {
//			System.out.println("ERROR - Could not listen for clients!");
//		}
//		
//		sv.jdbc.updateQuery("123456", "200");
//		sv.jdbc.selectQuery();

//	}

}
