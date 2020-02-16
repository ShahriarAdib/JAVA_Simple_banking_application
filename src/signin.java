import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.sql.*;

public class signin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin frame = new signin();
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
	public signin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 471, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 98, 110, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(43, 123, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(191, 95, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 120, 139, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;
				PreparedStatement ps;
				try
				{
					connection =DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					ps = connection.prepareStatement("SELECT `id`, `username`, `password` FROM `users` WHERE `username`=? AND `password`=?");
					ps.setString(1, textField.getText());
					ps.setString(2, String.valueOf(passwordField.getPassword()));
					ResultSet result = ps.executeQuery();
					if(result.next())
					{
						JOptionPane.showMessageDialog(null, "completed!", "sign in option", 1);
						record.username = textField.getText().toString();
						
						if(textField.getText().toString().trim().equals("admin") && passwordField.getText().toString().trim().equals("admin"))
						{
							admin_page ad= new admin_page();
							ad.setVisible(true);
						}
						else {
							record re= new record();
							re.setVisible(true);
						}
						
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "login failed!", "sign in option", 1);
					}
				
				}
				catch(SQLException ex)
				{
					Logger.getLogger(signin.class.getName()).log(Level.SEVERE, null,ex);
				}
				
			}
		});
		btnNewButton.setBounds(180, 208, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\ruet_logo.jpg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(116, 0, 239, 66);
		contentPane.add(lblNewLabel_2);
		

		
	}
}
