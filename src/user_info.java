import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class user_info extends JFrame {

	private JPanel contentPane;
	public static String user_id = "";
	
    ResultSet rs ;
    Connection connection;
	PreparedStatement ps;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_info frame = new user_info();
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
	public user_info() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10,10,1350,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTransactions = new JLabel("");
		lblTransactions.setVerticalAlignment(SwingConstants.TOP);
		lblTransactions.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactions.setBounds(598, 180, 454, 481);
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = textField.getText().toString().trim();
				lblTransactions.setText(DBConnector.getTransactions(userid));
				/***
				try
				{
					connection =DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					ps = connection.prepareStatement("SELECT  `user_id` FROM `transactions` WHERE `user_id`=?");
					ps.setString(1, passwordField.getText().toString());
					
					ResultSet result = ps.executeQuery();
					if(result.next())
					{
						JOptionPane.showMessageDialog(null, "completed!", "sign in option", 1);
						
						
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "failed!", "sign in option", 1);
					}
				
				}
				catch(SQLException ex)
				{
					Logger.getLogger(signin.class.getName()).log(Level.SEVERE, null,ex);
				}
				***/
			}
			
		});
		btnNewButton.setBounds(108, 87, 101, 23);
		contentPane.add(btnNewButton);
		
		
		
		//contentPane.add(lblTransactions);
		//lblTransactions.setText(DBConnector.getTransactions(DBConnector.getUserProfileID(user_id)));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 140, 900, 400);
		scrollPane.setViewportView(lblTransactions);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 63, 101, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(1175, 59, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(10, 88, 96, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
	}
}
