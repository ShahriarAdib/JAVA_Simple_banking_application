import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.Statement;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField Fname;
	private JTextField student_idField;
	private JTextField addressField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JTextField contact_numberField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 609, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 206, 112, 20);
		contentPane.add(lblNewLabel);
		
		Fname = new JTextField();
		Fname.setBounds(163, 205, 271, 23);
		contentPane.add(Fname);
		Fname.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Student ID :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setBounds(10, 243, 112, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel address = new JLabel("Address :");
		address.setHorizontalAlignment(SwingConstants.TRAILING);
		address.setBounds(10, 287, 112, 14);
		contentPane.add(address);
		
		student_idField = new JTextField();
		student_idField.setBounds(163, 239, 271, 23);
		contentPane.add(student_idField);
		student_idField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setBounds(163, 273, 271, 42);
		contentPane.add(addressField);
		addressField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Email :");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_8.setBounds(10, 329, 112, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9.setBounds(10, 360, 112, 14);
		contentPane.add(lblNewLabel_9);
		
		emailField = new JTextField();
		emailField.setBounds(163, 326, 271, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 357, 271, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String firstName = Fname.getText().toString();
				String password = passwordField.getText().toString();
				String email = emailField.getText().toString();
				String studentid= student_idField.getText().toString();
				String address = addressField.getText().toString();
				String contact = contact_numberField.getText().toString();
				
				JOptionPane.showMessageDialog(null, "completed!", "sign up option", 1);
				
				DBConnector.addUser(firstName, password, email, studentid, address, contact );
		
			}

		});
		btnNewButton.setBounds(124, 475, 330, 23);
		contentPane.add(btnNewButton);
		
		contact_numberField = new JTextField();
		contact_numberField.setBounds(163, 388, 271, 20);
		contentPane.add(contact_numberField);
		contact_numberField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contact number : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(10, 387, 112, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(153, 114, 271, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\ruet_logo.jpg"));
		lblNewLabel_3.setBounds(198, 38, 193, 65);
		
		contentPane.add(lblNewLabel_3);
	}
}
