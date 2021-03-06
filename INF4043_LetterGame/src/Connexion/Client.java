package Connexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 
public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtOutMsg;
	private Socket client;
	private OutputStreamWriter osw;
 
	public Client() { 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 160);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		txtOutMsg = new JTextField();
		txtOutMsg.setText("Test");
		txtOutMsg.setBounds(10, 21, 480, 20);
		
		contentPane.add(txtOutMsg);
		txtOutMsg.setColumns(10);
		
		final JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable(){
					public void run(){
						try {
							client = new Socket("localhost", 54321);
							osw = new OutputStreamWriter(client.getOutputStream());
							btnConnect.setEnabled(false);
							BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				            String line = "";
				            while (true) {
				                line = br.readLine();
				                if (line != null) {
				                    txtOutMsg.setText(line);
				                }
				            }
						} catch (UnknownHostException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
 
		btnConnect.setBounds(508, 20, 89, 23);
		contentPane.add(btnConnect);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					osw.write(txtOutMsg.getText().toString() + "\n");
					osw.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
 
		btnSend.setBounds(10, 52, 131, 45);
		contentPane.add(btnSend);
	}
}
