package Client;

import java.io.IOException;

import ocsf.client.*;

public class MyClient extends AbstractClient {

	public MyClient(String host, int port) {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub

	}

	public void handleMessageFromClientUI(Object message) {
		   try
		    {
		    	openConnection();//in order to send more than one message
		       	awaitResponse = true;
		    	sendToServer(message);
				// wait for response
				while (awaitResponse) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		    }
		    catch(IOException e)
		    {
		    	e.printStackTrace();
		      clientUI.display("Could not send message to server: Terminating client."+ e);
		      quit();
		    }
	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

	public void accept(Object message) {

	}

}
