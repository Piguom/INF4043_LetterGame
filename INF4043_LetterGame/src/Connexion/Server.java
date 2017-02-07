package Connexion;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 

public class Server extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMsg;
	Socket client;
	private OutputStreamWriter osw;

	public Server() {
 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 144);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		

		txtMsg = new JTextField();
		txtMsg.setText("Server side");
		txtMsg.setBounds(10, 11, 510, 20);
		
		contentPane.add(txtMsg);
		txtMsg.setColumns(10);
 
		final JButton btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							ServerSocket serv = new ServerSocket(54321);
				            btnStartServer.setEnabled(false);
				            client = serv.accept();
				            txtMsg.setText("Client Accepted");
							osw = new OutputStreamWriter(client.getOutputStream());
				            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				            String line = "";
				            while (true) {
				                line = br.readLine();
				                if (line != null) {
				                    txtMsg.setText(line);
				                }
				            }
 
						} catch (IOException e) {
							e.printStackTrace();
						}
						}
				}).start();
			}
		});
 
		btnStartServer.setBounds(10, 42, 147, 45);
		contentPane.add(btnStartServer);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					osw.write(txtMsg.getText().toString() + "\n");
					osw.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnSend.setBounds(300, 52, 131, 45);
		contentPane.add(btnSend);
	}
}