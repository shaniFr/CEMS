package Server;

import ocsf.server.ConnectionToClient;
import ocsf.server.ObservableServer;

public class MyObservableServer extends ObservableServer {
	/**
	 * Constructs a new server.
	 *
	 * @param port the port on which to listen.
	 */
	public MyObservableServer(int port) {
		super(port);
	}

	/**
	 * Hook method called each time a new client connection is accepted. The method
	 * may be overridden by subclasses.
	 *
	 * @param client the connection connected to the client.
	 */
	@Override
	protected synchronized void clientConnected(ConnectionToClient client) {
		/* output client details */
		System.out.println("client connected...");
	}

	/**
	 * Hook method called each time a client disconnects. The method may be
	 * overridden by subclasses.
	 *
	 * @param client the connection with the client.
	 */
	@Override
	protected synchronized void clientDisconnected(ConnectionToClient client) {
		System.out.println("are you getting here?");
		System.out.println("Port: " + this.getPort() + "\tHost: " 
					       + client.getInetAddress().getHostName() 
					       + "\tStatus: Disconnected");
	}
}