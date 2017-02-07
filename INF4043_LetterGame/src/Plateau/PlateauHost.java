package Plateau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Connexion.Server;
import Information.Popup;

public class PlateauHost extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Server serveur = new Server();
	Popup popup;
	public static JPanel joueur = new JPanel (new BorderLayout());
	static JPanel monjeu = new JPanel (new BorderLayout());
	public static String joueurs, myname;
	JLabel adversaire, moi;
	Thread t2;
	
	public PlateauHost(){
		
	/*	EventQueue.invokeLater(new Runnable() {
		      public void run() {
		            try {
		                  PlateauHost frame = new PlateauHost();
		                  frame.setVisible(true);
		            } catch (Exception e) {
		                  e.printStackTrace();
		            }
		      }});*/
		
		this.setTitle("LetterGame");
		this.setSize(600, 400);

        joueur.setPreferredSize(new Dimension(100,400));
        joueur.setBackground(Color.BLACK);
        monjeu.setPreferredSize(new Dimension(100,400));
        monjeu.setBackground(Color.BLACK);
       
        moi = new JLabel("Pseudo : " + myname);
        adversaire = new JLabel("Adversaire : " + joueurs);
               
        monjeu.add(moi);
        joueur.add(adversaire);
		
        add(joueur,BorderLayout.EAST);
        add(monjeu,BorderLayout.WEST);
		this.setVisible(true);	
		Popup.infoBox("Port 2009 : En attente d'autres joueurs", "Connexion");
	}
}
