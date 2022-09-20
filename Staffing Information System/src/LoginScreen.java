import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Log in");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UsernameLabel = new JLabel("Username:");
		UsernameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		UsernameLabel.setBounds(92, 78, 95, 16);
		contentPane.add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		PasswordLabel.setBounds(101, 134, 106, 16);
		contentPane.add(PasswordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 130, 198, 29);
		contentPane.add(passwordField);
		
		username = new JTextField();
		username.setBounds(198, 74, 198, 29);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 22));
		lblLogin.setBounds(233, 11, 80, 29);
		contentPane.add(lblLogin);
		
		JButton login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.BOLD, 14));
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				String pass = passwordField.getText();
				try {
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
					conn.setAutoCommit(false);
					PreparedStatement stmt=conn.prepareStatement("select * from Employee where username = ? and password = ? ");
					stmt.setString(1, user);
					stmt.setString(2, pass);
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						PreparedStatement stmt2 =conn.prepareStatement("CREATE TABLE TEMPTABLE (tempuser varchar2(20), tempID number(5))");
						stmt2.executeQuery();
						PreparedStatement stmt3 =conn.prepareStatement("INSERT INTO TEMPTABLE (tempuser) VALUES (?)");
						stmt3.setString(1, user);
						stmt3.executeQuery();
						JOptionPane.showMessageDialog(null, "Logged in successfully");
						dispose();
						Menu menu = new Menu();
						menu.setVisible(true);
						menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong username or password");
					conn.close();
					stmt.close();					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error Occur, please try again");
					e1.printStackTrace();
				}
			}
		});
		
		login.setBounds(166, 205, 87, 26);
		contentPane.add(login);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText(null);
				passwordField.setText(null);
			}
		});

		resetButton.setBounds(284, 205, 87, 26);
		contentPane.add(resetButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\DB Proj\\New folder\\22.PNG"));
		lblNewLabel.setBounds(0, 0, 95, 87);
		contentPane.add(lblNewLabel);
		
	}
}