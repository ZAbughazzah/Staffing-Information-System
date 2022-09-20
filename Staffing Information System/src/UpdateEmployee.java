import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class UpdateEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField sal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Update emplyee salary");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateEmployeeSalary = new JLabel("Update salary");
		lblUpdateEmployeeSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdateEmployeeSalary.setBounds(161, 32, 123, 16);
		contentPane.add(lblUpdateEmployeeSalary);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(76, 80, 94, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Salary: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(76, 136, 94, 16);
		contentPane.add(lblNewLabel_1);
		
		sal = new JTextField();
		sal.setBounds(205, 137, 130, 16);
		contentPane.add(sal);
		sal.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(211, 72, 124, 34);
		contentPane.add(comboBox);
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
			PreparedStatement stmt=conn.prepareStatement("select emp_ID from Employee");
			ResultSet rs= stmt.executeQuery();
			while (rs.next()) {
				comboBox.addItem(rs.getString("emp_ID"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
					conn.setAutoCommit(false);
					PreparedStatement stmt=conn.prepareStatement("UPDATE Employee set salary = ?, emp_rank = ? where emp_ID = ?" );
					stmt.setString(1,sal.getText());
					stmt.setString(3, (String) comboBox.getSelectedItem());
					String salary = sal.getText();
					if (!salary.isBlank()) {
						double s = Double.parseDouble(salary);
							if (s >= 30000 && s <= 50000 )
								stmt.setString(2,"A");
							else if (s >= 20000 && s < 30000)
								stmt.setString(2,"B");
							else if (s >= 10000 && s < 20000 )
								stmt.setString(2,"C");
					}
					else
						stmt.setString(2,null);
					
					
					
					int response = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO UPDATE EMPLOYEE SALARY ?");
					if (response == JOptionPane.YES_OPTION) {
						PreparedStatement stmt2 =conn.prepareStatement("UPDATE TEMPTABLE SET tempID = ? ");
						stmt2.setString(1, (String) comboBox.getSelectedItem());
						stmt2.executeQuery();
						stmt.executeQuery();
						conn.commit();
						stmt2.close();
						JOptionPane.showMessageDialog(null, "EMPLOYEE SALARY IS UPDATED");
						dispose();
					}
					else {
						conn.rollback();
						JOptionPane.showMessageDialog(null, "EMPLOYEE SALARY IS NOT UPDATED");
					}
					conn.close();
					stmt.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error Occur while updating employee’s salary, please try again");
					e1.printStackTrace();
				}
			}
		});	

		
		btnSubmit.setBounds(102, 188, 89, 23);
		contentPane.add(btnSubmit);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(223, 188, 89, 23);
		contentPane.add(btnBack);
	}
}
