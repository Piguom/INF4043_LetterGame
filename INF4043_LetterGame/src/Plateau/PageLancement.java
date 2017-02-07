package Plateau;

import java.awt.EventQueue;
import java.io.IOException;

import Connexion.Client;
import Connexion.Server;

public class PageLancement {
	
	/*final static JFrame lancement = new JFrame();
	static Menu menu = new Menu();
	static JPanel pan = new JPanel();
	static JPanel pan1 = new JPanel();
	static JPanel pan2 = new JPanel();
	static JPanel pan3 = new JPanel();
	static JPanel pan4 = new JPanel();
	static JPanel panel = new JPanel(new BorderLayout());
	final static JTextField name = new JTextField("Entrez votre nom");
	static JButton jouer = new JButton("Jouer");
	static JButton commande = new JButton("Régles / Commandes");
	static JButton host = new JButton("Hôte");
	static JButton join = new JButton("Rejoindre");
	static JButton score = new JButton("Afficher les scores");
	static JButton infos = new JButton("Instructions/Commandes");
	static String nom;*/
	
	public static void Lancement() throws IOException{
		
		/**
		 * Lancement des 2 premières fenêtre (hôte + 1 invité)
		 */
		
		
		/*lancement.setTitle("Tetris");
		lancement.setSize(500,400);
		lancement.setResizable(false);	
		lancement.setLocationRelativeTo(null);
		
		panel = setBackgroundImage(lancement, new File("src/Plateau/letter_game.jpg"));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500,400));
		
		name.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent e) {
		    	name.setText("");
		    }
		});
		
		pan.add(name);
		pan.setOpaque(false);
		pan1.add(host);
		pan1.setOpaque(false);
		pan2.add(join);
		pan2.setOpaque(false);
		pan3.add(score);
		pan3.setOpaque(false);
		pan4.add(infos);
		pan4.setOpaque(false);
		
		panel.add(pan);
		panel.add(pan1);
		panel.add(pan2);
		panel.add(pan3);
		panel.add(pan4);
		
		panel.getComponent(0).setBounds(200,5,100,30);
		panel.getComponent(1).setBounds(20,270,58,30);
		panel.getComponent(2).setBounds(420,270,58,30);
		panel.getComponent(3).setBounds(100,365,120,30);
		panel.getComponent(4).setBounds(300,365,150,30);
		
		lancement.setVisible(true);*/
	}
	
	public static void main(String[] args) {
		 
		EventQueue.invokeLater(new Runnable() {
		      public void run() {
		            try {
		                  Server frame = new Server();
		                  frame.setVisible(true);
		            } catch (Exception e) {
		                  e.printStackTrace();
		            }
		      }});
		

	     EventQueue.invokeLater(new Runnable() {
	          public void run() {
	               try {
	                    Client frame = new Client();
	                    frame.setVisible(true);
	               } catch (Exception e) {
	                    e.printStackTrace();
	     }}});
		}
	
	/*public static String getName()
	{
		return nom;
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException
	{
		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1;
			
			private BufferedImage buf = ImageIO.read(img);
			
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(buf, 0,0, null);
			}
		};
		
		frame.setContentPane(panel);
		
		return panel;
	}

	public static void main(String[] args) throws IOException
	{
		Lancement();
		
		host.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				new Thread(new Runnable(){
					public void run(){
						nom = name.getText();
						if(!nom.equals("")){
							//PortScanner ps = new PortScanner();
							Serveur serveur = new Serveur();					
							pan.setVisible(false);
							lancement.setVisible(false);
						}
						else
							JOptionPane.showMessageDialog(null, "ALERTE : Vous devez entrer un nom pour jouer !!!");
					}
				});
				
			}			
		}); 	
		
		join.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
					new Thread(new Runnable(){
						public void run(){
							nom = name.getText();
							if(!nom.equals("")){
								Client client = new Client(2009, nom);
								pan.setVisible(false);
								lancement.setVisible(false);
							}
							else
								JOptionPane.showMessageDialog(null, "ALERTE : Vous devez entrer un nom pour jouer !!!");			
						}
					});
			}			
		});
		
		score.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String msg = sc.lectureScore();
				 JOptionPane optionPane = new NarrowOptionPane();
				 optionPane.setMessage("Tableau des Scores (TOP 5) : \n\n" + msg);
				 optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				 JDialog dialog = optionPane.createDialog(null, "High Score");
				 dialog.setVisible(true);
			}			
		});
		
		infos.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Pour bouger la pièce:\nFléches de gauche et de droite pour aller à gauche et à droite\nLes fléches haut et bas pour tourner respectivement les pièces vers la droite et vers la gauche\n\nLa barre espace pour déposer la pièce tout en bas\nLa touche D pour descendre la pièce d'une case");
			}			
		});
		
	}*/

}

