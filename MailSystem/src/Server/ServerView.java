package Server;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ServerView implements java.util.Observer {

	private ServerController controller;
	
	public JTable table = new JTable();
	private JTextArea logArea = new JTextArea(20, 10);

	public ServerView() throws RemoteException, InterruptedException {
		
		JFrame frame = new JFrame("MailServer");
		JScrollPane scrollPane = new JScrollPane(table);
		JScrollPane scrollPane1 = new JScrollPane(logArea);
		logArea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		logArea.setLineWrap(true);
		logArea.setWrapStyleWord(true);

		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(scrollPane1, BorderLayout.SOUTH);

		frame.setSize(1000, 800);
		frame.setLocation(0, 0);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				System.exit(0);

			}

		});

	}

	public void addController(ServerController c) {

		System.out.print("Server: adding controller to view");
		this.controller = c;

	}

	public void update(java.util.Observable obs, Object obj) {

		System.out.println("Server: updating view");

	}

	public JTextArea getLogArea() {
		return logArea;
	}

}
