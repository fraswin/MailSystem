package Client;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;


import java.awt.event.WindowEvent; //for CloseListener()
import java.awt.event.WindowListener;
import java.io.Serializable;
import java.awt.event.WindowAdapter; //for CloseListener()

import java.util.Observable; //for update();
import java.awt.event.ActionListener; //for addController()
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.*;

class ClientView implements java.util.Observer, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Font inBoxMailFont = (new Font("Times New Roman", Font.BOLD, 13));
	private Font headerFont = (new Font("Times New Roman", Font.BOLD, 18));
	private Font receiverFontFocus = (new Font("Times New Roman", Font.BOLD, 18));
	private Font receiverFontNoFocus = (new Font("Times New Roman", Font.BOLD, 18));

	//  Client GUI
	private JFrame frame = new JFrame();
	private JTable table = new JTable();
	private JButton newMailBtn = new JButton("Nuova Mail");
	
   

	// Mi creo la Mail GUI
	private JFrame newMailFrame;
	private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
	private JLabel headerLbl = new JLabel("Nuovo messaggio");
	private JTextArea receiverTextArea = new JTextArea();
	private JTextArea subjectTextArea = new JTextArea();
	private JTextArea messageTextArea = new JTextArea();
	private JButton sendBtn = new JButton("Invia");

	// legge Mail GUI
	private JFrame readMailFrame = new JFrame();
	

	public JTable getTable() {
		return table;
	}

	ActionListener controller;

	public JTextArea getReceiverField() {
		return receiverTextArea;
	}

	public JTextArea getSubjectField() {
		return subjectTextArea;
	}

	public JFrame getNewMailFrameView() {
		return newMailFrame;
	}

	public JFrame getReadMailFrame() {
		return readMailFrame;
	}

	ClientView() {
		System.out.println("Client View Created Successfully");

		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		restyleButton(newMailBtn, Color.BLACK, Color.decode("#E44C41"), Color.BLACK);
		newMailBtn.setFont(new Font("Arial", Font.BOLD, 14));
		newMailBtn.setActionCommand("Create");
		mainPanel.add(newMailBtn);

		styleTable(table);
		frame.add(mainPanel, BorderLayout.SOUTH);

		setFrame(frame);

	}

	/*
	 * gives basic behaviour and attributes to the frame
	 */
	private void setFrame(JFrame frame) {
		frame.setSize(1000, 400);
		frame.setLocation(100, 100);
		frame.setVisible(true);
	}

	/*
	 * lo stile della tabella
	 */
	private void styleTable(JTable table) {
		JTableHeader anHeader = table.getTableHeader();
		table.setFont(inBoxMailFont);
		anHeader.setForeground(Color.black);
		anHeader.setFont(headerFont);
	}


	private void restyleButton(JButton button, Color foreground, Color background, Color border) {
		button.setForeground(foreground);
		button.setBackground(background);
		Border line = new LineBorder(border);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		button.setBorder(compound);
		button.setPreferredSize(new Dimension(180, 30));

	}

	public void update(Observable obs, Object obj) {
		System.out.println("View : Observable is " + obs.getClass() + ",object passed is " + obj + "");

	}

	public void addController(ActionListener controller) {
		System.out.println("View: adding controller");

		this.controller = controller;
		newMailBtn.addActionListener(controller);
		sendBtn.addActionListener(controller);
		table.addMouseListener((MouseListener) controller);
		frame.addWindowListener((WindowListener) controller);

	}

	/*
	 * creo la GUI per leggere email
	 */
	public void createReadMailGUI(String sender, String messageText) {

		JLabel dialogueLbl = new JLabel("");
		JScrollPane scrollPane = new JScrollPane(dialogueLbl);

		JTextArea messageTextArea = new JTextArea("");
		JScrollPane scrollPane1 = new JScrollPane(messageTextArea);
		dialogueLbl.setText(sender);
		messageTextArea.setText(messageText);
		JPanel mainPanel = new JPanel();
		JButton replyBtn = new JButton("Reply");

		dialogueLbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		messageTextArea.setFont(new Font("Tahoma", Font.PLAIN, 18));

		mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		JButton deleteMailBtn = new JButton("Delete");
		JButton forwardMailBtn = new JButton("Forward");

		
		deleteMailBtn.addActionListener(controller);
		forwardMailBtn.addActionListener(controller);
		replyBtn.addActionListener(controller);

		mainPanel.add(deleteMailBtn);
		mainPanel.add(replyBtn);
		mainPanel.add(forwardMailBtn);

		messageTextArea.setEditable(false);

		readMailFrame.add(scrollPane, BorderLayout.NORTH);
		readMailFrame.add(scrollPane1, BorderLayout.CENTER);
		readMailFrame.add(mainPanel, BorderLayout.SOUTH);

		readMailFrame.setVisible(true);
		readMailFrame.setSize(1000, 400);
		readMailFrame.setLocation(100, 100);
		readMailFrame.setVisible(true);
		readMailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	
	public void createMailGUI() {

		newMailFrame = new JFrame();

		mainPanel.setOpaque(true);
		mainPanel.setBackground(new Color(66, 66, 66));

		headerLbl.setForeground(Color.WHITE);
		headerLbl.setFont(headerFont);

		settingReceiverTextArea();
		settingSubjectTextArea();

		sendBtn.setBackground(new Color(59, 89, 182));
		sendBtn.setForeground(Color.BLACK);
		sendBtn.setFocusPainted(false);
		sendBtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sendBtn.setActionCommand("Send");
		Box box = new Box(BoxLayout.Y_AXIS);

		messageTextArea.setText("");
		messageTextArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
		messageTextArea.setLineWrap(true);
		messageTextArea.setWrapStyleWord(true);

		JScrollPane jScrollPane1 = new JScrollPane(receiverTextArea);
		JScrollPane jScrollPane2 = new JScrollPane(subjectTextArea);
		JScrollPane jScrollPane = new JScrollPane(messageTextArea);

		box.add(jScrollPane1);
		box.add(jScrollPane2);
		box.add("Center", jScrollPane);
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		btnPanel.add(sendBtn);

		int x = 1000;
		int y = 400;
		mainPanel.add(headerLbl);

		newMailFrame.add("North", mainPanel);
		newMailFrame.add("Center", box);
		newMailFrame.add("South", btnPanel);
		newMailFrame.setSize(x, y);
		newMailFrame.setLocation(100, 100);
		newMailFrame.setVisible(true);
		receiverTextArea.grabFocus();
		jScrollPane1.setMinimumSize(new Dimension(x, 300));
		jScrollPane1.setMaximumSize(new Dimension(x, 300));
		jScrollPane2.setMinimumSize(new Dimension(x, 300));
		jScrollPane2.setMaximumSize(new Dimension(x, 300));
		newMailFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ClientController.isMailEditorOpen = false;
				newMailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}

	public void resetTextBox(JTextArea txtArea, String value) {
		txtArea.setText("");
		txtArea.setText(value);
		txtArea.setFont(receiverFontNoFocus);
		txtArea.setForeground(new Color(144, 164, 174));
	}

	public void addKeyListener(JTextArea txtArea, String value) {
		txtArea.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {

					if (txtArea.getText().equals("")) {
						resetTextBox(txtArea, value);
					}
					txtArea.transferFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		});
	}

	public void addFocusListener(JTextArea txtArea, String value) {
		txtArea.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if (txtArea.getText().equals(value) || txtArea.getText().equals(value + "\t")) {
					txtArea.setText("");
					txtArea.setFont(receiverFontFocus);
					txtArea.setForeground(Color.BLACK);

				}

			}

			public void focusLost(FocusEvent e) {
				if (txtArea.getText().equals("")) {
					resetTextBox(txtArea, value);

				}

			}

		});

	}

	public void settingReceiverTextArea() {
		String startingValue = "Aggiungi destinatario";
		resetTextBox(receiverTextArea, startingValue);
		addKeyListener(receiverTextArea, startingValue);
		addFocusListener(receiverTextArea, startingValue);
	}

	public void settingSubjectTextArea() {
		String startingValue = "Aggiungi oggetto";
		resetTextBox(subjectTextArea, startingValue);
		addKeyListener(subjectTextArea, startingValue);
		addFocusListener(subjectTextArea, startingValue);
	}
	public void settingMessageTextArea() {
		String startingValue = "Testo";
		resetTextBox(messageTextArea, startingValue);
		addKeyListener(messageTextArea, startingValue);
		addFocusListener(messageTextArea, startingValue);
	}

	public void setFrameTitle(String title) {
		frame.setTitle(title);
	}

	public String getReceiverData() {
		return receiverTextArea.getText();
	}

	public String getSubjectData() {
		return subjectTextArea.getText();
	}

	public String getMessageData() {
		return messageTextArea.getText();

	}

}
