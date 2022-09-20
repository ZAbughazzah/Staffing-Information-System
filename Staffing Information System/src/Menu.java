import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Menu");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 426, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Employee");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add new employee");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee addEmp = new AddEmployee();
				addEmp.setVisible(true);
				addEmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Remove employee");
		mntmNewMenuItem_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveEmployee removeEmp = new RemoveEmployee();
				removeEmp.setVisible(true);
				removeEmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Update employee salary");
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				UpdateEmployee updateEmp =  new UpdateEmployee();
				updateEmp.setVisible(true);
				updateEmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Employee allowances");
		mntmNewMenuItem_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeAllowances empAllowances = new EmployeeAllowances();
				empAllowances.setVisible(true);
				empAllowances.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Reports");
		mnNewMenu_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Employee history");
		mntmNewMenuItem_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeHistory empHist = new EmployeeHistory();
				empHist.setVisible(true);
				empHist.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Vehicle history");
		mntmNewMenuItem_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VehcileHistory vehicleHist = new VehcileHistory();
				vehicleHist.setVisible(true);
				vehicleHist.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Project history");
		mntmNewMenuItem_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectHistory projHist = new ProjectHistory();
				projHist.setVisible(true);
				projHist.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_2 = new JMenu("Exit");
		mnNewMenu_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Close");
		mntmNewMenuItem_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
					conn.setAutoCommit(true);
					PreparedStatement stmt=conn.prepareStatement("DROP TABLE TEMPTABLE");
					stmt.executeQuery();
					conn.close();
					stmt.close();	
					JOptionPane.showMessageDialog(null, "Program is closed");
					dispose();//sys.exit(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error occure while closing program");
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\images (2).png"));
		lblNewLabel.setBounds(98, 62, 250, 190);
		contentPane.add(lblNewLabel);
	}
}
