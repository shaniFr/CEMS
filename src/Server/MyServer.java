package Server;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

/**
 * 
 * @author Ayala Cohen
 * arbitrator between clients & database
 */
public class MyServer extends AbstractServer {
	/**
	 * mySQL connection
	 */
	JDBCSingleton jdbc;
	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	/**
	 * constructor, instantiates the database connection
	 * @param port 	The server port to database
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
		
		String newDuration, ExamID, str; /* new exam duration in minutes & exam ID */
		int temp;
		
		if (!(msg instanceof String)) 
			System.out.println("Server : Invalid message from client !!");
		
		str = (String)msg;
		ExamID = str.substring(0, 6); /* ExamID is 6 digit long */
		newDuration = ExamID.substring(6);
		
		temp = Integer.parseInt(newDuration);
		if (temp < 0)
			System.out.println("Server : Invalid new duration from client !!");
		
		/* update duration in db */
		jdbc.updateQuery(ExamID, newDuration);
	}

	/**
	 * Hook method called each time a new client connection is accepted. The default
	 * implementation does nothing.
	 * 
	 * @param client the connection connected to the client.
	 */
	protected void clientConnected(ConnectionToClient client) {
	}

	/**
	 * Hook method called each time a client disconnects. The default implementation
	 * does nothing. The method may be overridden by subclasses but should remains
	 * synchronized.
	 *
	 * @param client the connection with the client.
	 */
	synchronized protected void clientDisconnected(ConnectionToClient client) {
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

	/**
	 * This method is responsible for the creation of the server instance (there is
	 * no UI in this phase).
	 *
	 * @param args[0] The port number to listen on. Defaults to 5555 if no argument
	 *                is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		MyServer sv = new MyServer(port);
		
		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
//		sv.jdbc.updateQuery("123456", "200");
	}

}
