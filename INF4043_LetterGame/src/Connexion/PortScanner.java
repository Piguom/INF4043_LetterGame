package Connexion;

import java.net.InetSocketAddress;
import java.net.Socket;

import Information.Popup;

public class PortScanner {
	
	/**
	 * A insérer pour des améliorations futures
	 */
	
	public PortScanner() {
		
		int port = 0;

        System.out.println("Recherche de port disponible en cours...");
	      for (port = 130; port <= 136; port++) {
	         try {
	            Socket socket = new Socket();
	            socket.connect(new InetSocketAddress("localhost", port),1000);
	            socket.close();
	            System.out.println("Port " + port + " is open");
	        } catch (Exception ex) {
	            System.out.println("Port "+port+" is occupied");
	        }
	      }
	   }
}
