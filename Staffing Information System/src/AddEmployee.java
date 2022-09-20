import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField eIDtextField;
	private JTextField enametextField;
	private ButtonGroup bg = new  ButtonGroup();
	private JTextField phoneTextField;
	private JTextField salTextField;
	private JTextField comTextField;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JTextField platenoTextField;
	private JTextField DOBTextField;
	private JTextField HireTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 666);
		setTitle("Add employee");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		eIDtextField = new JTextField();
		eIDtextField.setBounds(231, 92, 142, 23);
		contentPane.add(eIDtextField);
		eIDtextField.setColumns(10);
		
		JLabel enameLabel = new JLabel("Employee name");
		enameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		enameLabel.setBounds(40, 34, 142, 39);
		contentPane.add(enameLabel);
		
		JLabel lblEmployeeId = new JLabel("Hiredate (dd-mon-yyyy) *");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId.setBounds(35, 534, 203, 39);
		contentPane.add(lblEmployeeId);
		
		enametextField = new JTextField();
		enametextField.setColumns(10);
		enametextField.setBounds(231, 44, 142, 23);
		contentPane.add(enametextField);
		
		JLabel lblNewLabel = new JLabel("Add new Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(132, 0, 161, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmployeeId_1 = new JLabel("Employee ID *");
		lblEmployeeId_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_1.setBounds(40, 84, 131, 35);
		contentPane.add(lblEmployeeId_1);
		
		JLabel lblEmployeeId_2 = new JLabel("Gender *");
		lblEmployeeId_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_2.setBounds(40, 130, 85, 27);
		contentPane.add(lblEmployeeId_2);
		
		JLabel lblEmployeeId_3 = new JLabel("Phone number *");
		lblEmployeeId_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_3.setBounds(40, 168, 131, 27);
		contentPane.add(lblEmployeeId_3);
		
		JLabel lblEmployeeId_3_1 = new JLabel("Date of Birth (dd-mon-yyyy) *");
		lblEmployeeId_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_3_1.setBounds(35, 500, 234, 23);
		contentPane.add(lblEmployeeId_3_1);
		
		JRadioButton MaleRadioButton = new JRadioButton("male");
		MaleRadioButton.setBounds(231, 134, 57, 23);
		contentPane.add(MaleRadioButton);
		
		JRadioButton FemaleRadioButton_1 = new JRadioButton("Female");
		FemaleRadioButton_1.setBounds(305, 134, 68, 23);
		contentPane.add(FemaleRadioButton_1);
		
		bg.add(FemaleRadioButton_1);
		bg.add(MaleRadioButton);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(231, 172, 142, 23);
		contentPane.add(phoneTextField);
		
		JLabel lblEmployeeId_3_2 = new JLabel("Department number");
		lblEmployeeId_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_3_2.setBounds(40, 206, 176, 39);
		contentPane.add(lblEmployeeId_3_2);
		
		JLabel lblEmployeeId_2_1 = new JLabel("Salary");
		lblEmployeeId_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_2_1.setBounds(40, 302, 85, 23);
		contentPane.add(lblEmployeeId_2_1);
		
		JLabel lblEmployeeId_2_1_1 = new JLabel("Commissions");
		lblEmployeeId_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_2_1_1.setBounds(40, 336, 105, 27);
		contentPane.add(lblEmployeeId_2_1_1);
		
		salTextField = new JTextField();
		salTextField.setColumns(10);
		salTextField.setBounds(231, 304, 142, 23);
		contentPane.add(salTextField);
		
		comTextField = new JTextField();
		comTextField.setColumns(10);
		comTextField.setBounds(231, 340, 142, 23);
		contentPane.add(comTextField);
		
		JLabel lblEmployeeId_2_1_1_1 = new JLabel("Username");
		lblEmployeeId_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_2_1_1_1.setBounds(40, 374, 96, 35);
		contentPane.add(lblEmployeeId_2_1_1_1);
		
		JLabel lblEmployeeId_2_1_1_1_1 = new JLabel("Password");
		lblEmployeeId_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_2_1_1_1_1.setBounds(40, 420, 96, 23);
		contentPane.add(lblEmployeeId_2_1_1_1_1);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(231, 374, 142, 23);
		contentPane.add(usernameTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(231, 423, 142, 20);
		contentPane.add(passwordField);
		
		platenoTextField = new JTextField();
		platenoTextField.setBounds(231, 454, 142, 23);
		contentPane.add(platenoTextField);
		platenoTextField.setColumns(10);
		
		JLabel lblVehcilePlateno = new JLabel("Vehcile plateNo.");
		lblVehcilePlateno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVehcilePlateno.setBounds(35, 454, 136, 27);
		contentPane.add(lblVehcilePlateno);
		
		DOBTextField = new JTextField();
		DOBTextField.setColumns(10);
		DOBTextField.setBounds(279, 502, 142, 23);
		contentPane.add(DOBTextField);
		
		HireTextField = new JTextField();
		HireTextField.setColumns(10);
		HireTextField.setBounds(279, 544, 142, 23);
		contentPane.add(HireTextField);
		
		JComboBox DeptomboBox = new JComboBox();
		DeptomboBox.setBounds(241, 212, 110, 30);
		contentPane.add(DeptomboBox);
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
			PreparedStatement stmt=conn.prepareStatement("select Deptno from Department");
			ResultSet rs= stmt.executeQuery();
			while (rs.next()) {
				DeptomboBox.addItem(rs.getString("Deptno"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JComboBox PositioncomboBox = new JComboBox();
		PositioncomboBox.setBounds(241, 263, 110, 30);
		contentPane.add(PositioncomboBox);
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
			PreparedStatement stmt=conn.prepareStatement("select position_name from position");
			ResultSet rs= stmt.executeQuery();
			while (rs.next()) {
				PositioncomboBox.addItem(rs.getString("position_name"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton EnterButton = new JButton("Add");
		EnterButton.setForeground(new Color(0, 0, 0));
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eIDtextField.getText().isBlank() || phoneTextField.getText().isBlank() || DOBTextField.getText().isBlank() || 
						HireTextField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Please fill required fields");
				}
				else {
				try {
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
					conn.setAutoCommit(false);
					PreparedStatement stmt=conn.prepareStatement("INSERT into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							
					stmt.setString(1,eIDtextField.getText());
					stmt.setString(2,enametextField.getText());
					stmt.setString(3,phoneTextField.getText());
					if (MaleRadioButton.isSelected())
						stmt.setString(4,"M");
					else if (FemaleRadioButton_1.isSelected())
						stmt.setString(4,"F");
					stmt.setString(5,DOBTextField.getText());
					stmt.setString(6,HireTextField.getText());
					
					stmt.setString(7,(String) (DeptomboBox.getSelectedItem()));
					stmt.setString(8,(String) PositioncomboBox.getSelectedItem());
					stmt.setString(9,salTextField.getText());
					if (comTextField.getText().isBlank())
						stmt.setString(10,null);
					else
						stmt.setString(10,comTextField.getText());
					stmt.setString(11,(usernameTextField.getText()));
					stmt.setString(12,(passwordField.getText()));
					if (!platenoTextField.getText().isBlank())
						stmt.setString(13,platenoTextField.getText());
					else 
						stmt.setString(13,null);
					String sal = salTextField.getText();
					if (!sal.isBlank()) {
						double salary = Double.parseDouble(sal);
							if (salary >= 30000 && salary <= 50000 )
								stmt.setString(14,"A");
							else if (salary >= 20000 && salary < 30000)
								stmt.setString(14,"B");
							else if (salary >= 10000 && salary < 20000 )
								stmt.setString(14,"C");
					}
					else
						stmt.setString(14,null);
					
					
					int response = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO ADD NEW EMPLOYEE?");
					if (response == JOptionPane.YES_OPTION) {
						PreparedStatement stmt2 =conn.prepareStatement("UPDATE TEMPTABLE SET tempID = ? ");
						stmt2.setString(1, eIDtextField.getText());
						stmt2.executeQuery();
						stmt.executeQuery();
						conn.commit();
						JOptionPane.showMessageDialog(null, "EMPLOYEE ADDED");
						dispose();
					}
					else {
						conn.rollback();
						JOptionPane.showMessageDialog(null, "EMPLOYEE NOT ADDED");
					}
					conn.close();
					stmt.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error Occur while adding new employee, please try again");
				e1.printStackTrace();
				}
				}
			}
		});
		EnterButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		EnterButton.setBounds(104, 584, 78, 27);
		contentPane.add(EnterButton);
		
		JLabel lblEmployeeId_3_2_1 = new JLabel("Position");
		lblEmployeeId_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId_3_2_1.setBounds(40, 256, 85, 35);
		contentPane.add(lblEmployeeId_3_2_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(253, 584, 85, 27);
		contentPane.add(btnNewButton);
		
		
	}
}
