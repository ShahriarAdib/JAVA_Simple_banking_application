import java.awt.BorderLayout;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSetMetaData;
//import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Desktop;
public class record extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	public static String username = "";
	private JTextField emailField;
	private JTextField userIDField;
	private JTextField studentIDField;
	private JTextField addressField;
	private JTextField txtAmount;
	private JTextField contactField;
	private JTextField totalField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					record frame = new record();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public record() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10,10,1350,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Profile");
		lblNewLabel_1.setFont(new Font("Elephant", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(465, 11, 264, 58);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("show Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				nameField.setText(DBConnector.getUserProfileName(username));
				emailField.setText(DBConnector.getUserProfileEmail(username));
				studentIDField.setText(DBConnector.getUserProfileStudentID(username));
				userIDField.setText(DBConnector.getUserProfileID(username));
				addressField.setText(DBConnector.getUserProfileAddress(username));
				contactField.setText(DBConnector.getUserContact_number(username));
				
				
				//DBConnector.getUsers();
			}
		});
		btnNewButton.setBounds(162, 354, 133, 58);
		contentPane.add(btnNewButton);
		
		nameField = new JTextField();
		nameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				
			}
		});
		nameField.setBounds(138, 101, 194, 28);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(138, 135, 194, 28);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 101, 118, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Email : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(10, 135, 118, 23);
		contentPane.add(lblNewLabel_2);
		
		userIDField = new JTextField();
		userIDField.setBounds(138, 169, 194, 28);
		contentPane.add(userIDField);
		userIDField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("User ID : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(10, 169, 118, 23);
		contentPane.add(lblNewLabel_4);
		
		studentIDField = new JTextField();
		studentIDField.setBounds(138, 203, 194, 28);
		contentPane.add(studentIDField);
		studentIDField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Student ID : ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setBounds(10, 203, 118, 23);
		contentPane.add(lblNewLabel_5);
		
		addressField = new JTextField();
		addressField.setBounds(138, 276, 194, 67);
		contentPane.add(addressField);
		addressField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Address : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setBounds(10, 287, 118, 44);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblTransactions = new JLabel("<html><table><tr><td>1</td><td>2</td></tr></html>");
		lblTransactions.setVerticalAlignment(SwingConstants.TOP);
		lblTransactions.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactions.setBounds(598, 180, 454, 481);
		//contentPane.add(lblTransactions);
		lblTransactions.setText(DBConnector.getTransactions(DBConnector.getUserProfileID(username)));
		
		txtAmount = new JTextField();
		txtAmount.setBounds(552, 105, 179, 20);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		JButton btnDr = new JButton("Withdraw");
		btnDr.setBounds(535, 138, 106, 23);
		contentPane.add(btnDr);
		btnDr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Calendar calendar = Calendar.getInstance();
				// TODO Auto-generated method stub
				String amount = txtAmount.getText().toString();
				String type = "Dr";
				int userId = Integer.parseInt(DBConnector.getUserProfileID(username));
				String time = "1234";
				DBConnector.addTransaction(userId, type, time, amount);
				lblTransactions.setText(DBConnector.getTransactions(DBConnector.getUserProfileID(username)));
				totalField.setText(DBConnector.getAmount(DBConnector.getUserProfileID(username)));
				
				
			}
		});
		
		JButton btnCr = new JButton("Add money");
		btnCr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String amount = txtAmount.getText().toString();
				String type = "Cr";
				int userId = Integer.parseInt(DBConnector.getUserProfileID(username));
				String time = "1234";
				DBConnector.addTransaction(userId, type, time, amount);
				lblTransactions.setText(DBConnector.getTransactions(DBConnector.getUserProfileID(username)));
				totalField.setText(DBConnector.getAmount(DBConnector.getUserProfileID(username)));
			}
		});
		btnCr.setBounds(639, 138, 106, 23);
		contentPane.add(btnCr);
		
		JLabel lblNewLabel_3 = new JLabel("Amount :");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(456, 104, 106, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Contact Number : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setBounds(10, 237, 118, 28);
		contentPane.add(lblNewLabel_7);
		
		contactField = new JTextField();
		contactField.setBounds(138, 237, 194, 28);
		contentPane.add(contactField);
		contactField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(583, 200, 600, 400);
		scrollPane.setViewportView(lblTransactions);
		contentPane.add(scrollPane);
		
		JButton btnukash = new JButton("New button");
		btnukash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("http://www.yuupay.com/ukash.html"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnukash.setIcon(new ImageIcon("F:\\Ruet banking\\ukashlogo.jpg"));
		btnukash.setBounds(10, 451, 366, 94);
		contentPane.add(btnukash);
		
		JButton btnbkash = new JButton("New button");
		btnbkash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.bkash.com//"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnbkash.setIcon(new ImageIcon("F:\\Ruet banking\\BKash_logo.png"));
		btnbkash.setBounds(10, 556, 366, 94);
		contentPane.add(btnbkash);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(1235, 32, 89, 23);
		contentPane.add(btnNewButton_1);
		
		totalField = new JTextField();
		totalField.setBounds(1066, 110, 117, 53);
		contentPane.add(totalField);
		totalField.setColumns(10);
		totalField.setText(DBConnector.getAmount(DBConnector.getUserProfileID(username)));
		
		JLabel lbltotal = new JLabel("Total :");
		lbltotal.setHorizontalAlignment(SwingConstants.CENTER);
		lbltotal.setBounds(998, 108, 58, 55);
		contentPane.add(lbltotal);
		
		
		
		
		

	}
}
