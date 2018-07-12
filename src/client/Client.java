package client;

import java.net.Socket;

public class Client {

	private static final int PORT = 5555;
	private static Socket serverConnection;
	
	public Client(String serverIp) {
		//TODO Add error checking for bad ip
		//Potentially have user put in port
				
//		System.out.print("Please enter ip of server: ");
//		Scanner in = new Scanner(System.in);
//		String serverIp = in.nextLine();
//		in.close();
		serverConnection = null;
		try {
			serverConnection = new Socket(serverIp, PORT);
			System.out.println();
			System.out.println("Connected to " + serverIp + "!");
		}catch (Exception e) {
			System.err.println("Unable to resolve " + serverIp + ":" + PORT);
			e.printStackTrace();
		}
		
	}
	public Socket getSocket() {
		return this.serverConnection;
	}
	//TODO check server is still connected
	public boolean checkConnection() {
		return true;
	}
	
}
