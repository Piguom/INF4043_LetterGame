package Connexion;

import java.io.IOException;
import java.net.Socket;

public class Client {

	public static String name;	

	public Client() {}
	
	public Client (int port, String nom){
		Socket socket;
		name = nom;
		try {
		socket = new Socket("localhost",port);
		socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
