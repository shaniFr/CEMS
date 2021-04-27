package Client;

import java.io.IOException;
import java.util.ArrayList;

import Data.Exam;
import ocsf.client.*;

public class MyClient extends AbstractClient {
	private int clientID;
	private static int i=0;
	
	public MyClient(String host, int port) {
		super(host, port);
		i++;
		clientID=i;
	}
	
//	public void receivedMessageFromServer(Object msg) {
//		
//	}
	@Override
	protected void handleMessageFromServer(Object msg) {
		ArrayList<Exam> examlist;
		
		if (!(msg instanceof ArrayList<?>)) {
			System.out.println("Client : Invalid message from server !!");
			return;
	}
		examlist = (ArrayList<Exam>)msg;
		

	}

	public void handleMessageFromClientUI(Object message) {
//		   try
//		    {
//		    	openConnection();//in order to send more than one message
////		       	awaitResponse = true;
//		    	sendToServer(message);
				// wait for response
//				while (awaitResponse) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//		    }
//		    catch(IOException e)
//		    {
//		    	e.printStackTrace();
//		      clientUI.display("Could not send message to server: Terminating client."+ e);
//		      quit();
//		    }
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
