package Client;

import java.io.IOException;
import java.util.ArrayList;

import Data.Exam;
import ocsf.client.*;

public class MyClient extends AbstractClient {
	private static int i = 0;

	
	public MyClient(String host, int port) {
		super(host, port);		
	}
	
	
	

	@Override
	protected void handleMessageFromServer(Object msg) {
		ArrayList<Exam> examlist;

		if (!(msg instanceof ArrayList<?>)) {
			System.out.println("Client : Invalid message from server !!");
			return;
		}
		examlist = (ArrayList<Exam>) msg;
		System.out.println(examlist);

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

	public static void main(String[] args) {
		MyClient client = new MyClient("localhost", 5555);
		try {
			client.openConnection();
			Thread.sleep(30);
			client.closeConnection(); /* todo: we need to make a connection between the client & the server, plus how do we close the connection and make the server notice it & update the status of the client !!*/
			Thread.sleep(40);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		

	}
}
