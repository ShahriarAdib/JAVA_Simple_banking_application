import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class admin_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Admin = "+ DBConnector.getAllTransactions());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_page frame = new admin_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public admin_page() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10,10,1350,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnGetAllTransactions = new JButton("Transactions");
		JLabel lblTransactions = new JLabel("");
		lblTransactions.setVerticalAlignment(SwingConstants.TOP);
		lblTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		//contentPane.add(lblTransactions);
		lblTransactions.setBounds(218, 235, 122, 48);
		
		btnGetAllTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTransactions.setText(DBConnector.getAllTransactions());
			}
		});
		btnGetAllTransactions.setBounds(486, 568, 336, 23);
		contentPane.add(btnGetAllTransactions);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 140, 900, 400);
		scrollPane.setViewportView(lblTransactions);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Transactions");
		lblNewLabel.setFont(new Font("HP Simplified", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(200, 69, 900, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RUET BANKING SYSTEM ADMIN PANEL");
		lblNewLabel_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(200, 11, 900, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnsearch_user = new JButton("Search User");
		btnsearch_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user_info us =new user_info();
						us.setVisible(true);
			}
		});
		btnsearch_user.setBounds(1110, 140, 214, 60);
		contentPane.add(btnsearch_user);
		
		

		
	
		
		
	}
}
