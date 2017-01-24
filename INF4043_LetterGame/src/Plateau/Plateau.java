package Plateau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Connexion.Serveur;
import Information.Popup;

public class Plateau extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Serveur serveur = new Serveur();
	Popup popup;
	static JPanel joueur = new JPanel (new BorderLayout());
	static JPanel monjeu = new JPanel (new BorderLayout());
	public static String joueurs, myname;
	JLabel adversaire, moi;
	
	public Plateau(){
		this.setTitle("LetterGame");
		this.setSize(600, 400);
		

        joueur.setPreferredSize(new Dimension(100,400));
        joueur.setBackground(Color.BLACK);
        monjeu.setPreferredSize(new Dimension(100,400));
        monjeu.setBackground(Color.BLACK);
        
        moi = new JLabel("Pseudo : " + myname);
        monjeu.add(moi);
        
        adversaire = new JLabel("Adversaire : " + joueurs);
        joueur.add(adversaire);
		
        add(joueur,BorderLayout.EAST);
        add(monjeu,BorderLayout.WEST);
		this.setVisible(true);	
		Popup.infoBox("Port 2009 : En attente d'autres joueurs", "Connexion");
	}
}
