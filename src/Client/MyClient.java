package Client;

import java.io.IOException;
import java.util.ArrayList;
import Data.Exam;
import ocsf.client.*;

public class MyClient extends AbstractClient {
	public static boolean awaitResponse = false;
	public static ArrayList<Exam> exams = new ArrayList<>();
	ChatIF clientUI;

	public MyClient(String host, int port, ChatIF clientUI) throws IOException {
		super(host, port);
		System.out.println(this.getClass() + "constructor");
		this.clientUI = clientUI;
		
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		ArrayList<Exam> examlist;
		String str;
		char op;

		System.out.println(this.getClass().getName() + " handle msg from server received");
		if (!(msg instanceof String)) {
			System.out.println("Client : Invalid message from server !!");
			return;
		}
		str = (String) msg;
		op = str.charAt(0);
		switch (op) {
		case 'X': /* server says he updated the database unsuccessfully */
			System.out.println("client is sad :(");
			break;
		case 'Y': /* server says he updated the database successfully */
			System.out.println("client is happy :)");
			break;
		case 'S': /* server says he replayed the database */
			exams = decodeMessageFromServer(str);
//			System.out.println("\n\nr\n\n");
////			exams = decodeMessageFromServer(str);
			break;

		}
		awaitResponse = false;
	}

	private ArrayList<Exam> decodeMessageFromServer(String str) {
		ArrayList<Exam> examTable = new ArrayList<>();
		String[] decodedMsg;
		String temp = str.substring(1);
		decodedMsg = temp.split("-");
		int i = 0;

		for (int j = 0; j < decodedMsg.length / 5; j++) {
			Exam ex = new Exam("", "", "", 0, "");
			ex.setExamID(decodedMsg[i]);
			ex.setSubject(decodedMsg[i + 1]);
			ex.setCourse(decodedMsg[i + 2]);
			ex.setDuration(Integer.parseInt(decodedMsg[i + 3]));
			ex.setScores(decodedMsg[i + 4]);
			i = i + 5;
			examTable.add(ex);
			//System.out.println(examTable.get(i).getScores());
		}
		return examTable;
	}

	public void handleMessageFromClientUI(Object message) {
		System.out.println("Recieved from UI:" + message);
		try {
			openConnection();// in order to send more than one message
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

		catch (IOException e) {
			e.printStackTrace();
			clientUI.display("Could not send message to server: Terminating client." + e);
			quit();
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
//			System.out.println(this.getClass().getName() + " quit");
			this.sendToServer("C");
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

//	public static void main(String[] args) throws IOException {
//		MyClient client = new MyClient("localhost", 5555, new ClientController("localhost", 5555));
//		try {
//			client.openConnection();
//			awaitResponse = true;
//			client.sendToServer("D");
//
//			while (awaitResponse) {
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//		} catch (Exception e) {
//			client.quit();
//			e.printStackTrace();
//		}
//
//	}
}
