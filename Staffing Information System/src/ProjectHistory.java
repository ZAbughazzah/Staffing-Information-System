import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class ProjectHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectHistory frame = new ProjectHistory();
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
	public ProjectHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 401);
		setTitle("Project history");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDisplay.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//Project History. (Project Name, Project Description, Department Name).
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
				PreparedStatement stmt=conn.prepareStatement("SELECT Project.project_name, Project.project_description, Department.dname FROM  Project natural join Department_Project natural join Department");
				ResultSet rs = stmt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				conn.close();
				stmt.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error Occur while retrieving data, please try again");
				e1.printStackTrace();
			}
		}
	});	
		contentPane.setLayout(null);
		btnDisplay.setBounds(148, 31, 117, 29);
		contentPane.add(btnDisplay);
		
		JLabel ProjectHistory = new JLabel("Project History");
		ProjectHistory.setFont(new Font("Tahoma", Font.BOLD, 16));
		ProjectHistory.setBounds(216, 11, 141, 16);
		contentPane.add(ProjectHistory);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 61, 485, 229);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		});
		btnBack.setBounds(275, 31, 117, 29);
		contentPane.add(btnBack);
	}

}
