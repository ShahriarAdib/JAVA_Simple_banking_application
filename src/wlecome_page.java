import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Desktop;
import java.net.URI;

public class wlecome_page {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wlecome_page window = new wlecome_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public wlecome_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBounds(10, 10, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\ruet_logo.jpg"));
		lblNewLabel.setBounds(596, 11, 167, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("sign up");
		btnNewButton.setForeground(new Color(51, 0, 102));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup s = new signup();
				s.setVisible(true);
			}
		});
		btnNewButton.setBounds(1177, 54, 120, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("sign in");
		btnNewButton_1.setForeground(new Color(51, 0, 102));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin q =new signin();
				q.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1056, 54, 120, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ABOUT RUET");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("http://www.ruet.ac.bd/"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(1087, 584, 142, 41);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to RUET Banking System");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(473, 118, 421, 78);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("ADMIN");
		btnNewButton_3.setForeground(new Color(204, 51, 51));
		btnNewButton_3.setBackground(new Color(204, 204, 204));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin r =new signin();
				r.setVisible(true);	
			}
		});
		btnNewButton_3.setBounds(637, 207, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u00A9 Shahriar Adib");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 597, 183, 28);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
