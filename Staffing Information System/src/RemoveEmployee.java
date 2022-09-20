import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RemoveEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmpid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmployee frame = new RemoveEmployee();
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
	public RemoveEmployee() {
		setFont(new Font("Dubai", Font.BOLD, 15));
		setTitle("Remove employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 52, 124, 23);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.enable(false);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(215, 48, 124, 34);
		panel.add(comboBox);
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
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
					PreparedStatement stmt=conn.prepareStatement("delete from Employee where emp_ID = ? ");
					conn.setAutoCommit(false);
					stmt.setString(1,(String) comboBox.getSelectedItem());
					
					
					int response = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO DeLETE EMPLOYEE?");
					if (response == JOptionPane.YES_OPTION) {
						PreparedStatement stmt2 =conn.prepareStatement("UPDATE TEMPTABLE SET tempID = ? ");
						stmt2.setString(1, (String) comboBox.getSelectedItem());
						stmt2.executeQuery();
						stmt.executeQuery();
						conn.commit();
						JOptionPane.showMessageDialog(null, "EMPLOYEE DELETED SUCCESSFULLY");
						dispose();
					}
					else {
						conn.rollback();
						JOptionPane.showMessageDialog(null, "EMPLOYEE IS NOT DELETED");
					}

					conn.close();
					stmt.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error Occur while deleting employee, please try again");
					e1.printStackTrace();
				}
			}
		});	
		btnNewButton.setBounds(50, 121, 101, 23);
		panel.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("Back ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnNewButton_2.setBounds(50, 155, 101, 23);
		panel.add(btnNewButton_2);
	}
}