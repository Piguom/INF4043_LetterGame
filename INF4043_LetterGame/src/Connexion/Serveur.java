package Connexion;

import java.io.IOException;
import java.net.*;

import Plateau.PageLancement;
import Plateau.Plateau;

public class Serveur {

	String nom = PageLancement.getName();
	public static String info;
		
	public Serveur(){

		ServerSocket socket = null;
		Plateau plateau;
		
		try {
		socket = new ServerSocket(2009);
		Thread t = new Thread(new Accepter_clients(socket));
		t.start();
		info = nom + " vous êtes en attente d'autres joueurs.";
		System.out.println(nom + " vous êtes en attente d'autres joueurs sur le port 2009");
		Plateau.myname = nom;
		plateau = new Plateau();
		} catch (IOException e) {
			System.err.println("Le port 2009 est déjà utilisé !");
		}
	}
}

class Accepter_clients implements Runnable {	

	   private ServerSocket socketserver;
	   private Socket socket;
		Plateau plateau;
	//   private int nbrclient = 1;
	   
		public Accepter_clients(ServerSocket s){
			socketserver = s;
		}
		
		public void run() {

	        try {
	        	while(true){
	        		socket = socketserver.accept(); // Un client se connecte on l'accepte
	        		System.out.println("Le client "+Client.name+ " est connecté !");
	        		Plateau.joueurs = Client.name;
	        		plateau = new Plateau();
	        	//	nbrclient++;
	        		socket.close();
	        	}
	        
	        } catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

