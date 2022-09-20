import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class EmployeeHistory extends JFrame {

private JPanel contentPane;
private JTable table;

/**
* Launch the application.
*/
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	public void run() {
	try {
	EmployeeHistory frame = new EmployeeHistory();
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
public EmployeeHistory() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 539, 356);
	setTitle("Employee history");
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton btnDisplay = new JButton("Display");
	btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnDisplay.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			//Employee History (Employee Name, Department Name, Hiredate).
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa","za1908270", "za1908270");
			PreparedStatement stmt=conn.prepareStatement("select ename employee_name, dname department_name, Hiredate from Employee natural join Department");
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
	btnDisplay.setBounds(127, 38, 96, 18);
	contentPane.add(btnDisplay);
	
	JLabel lblEmployeeHistory = new JLabel("Employee History");
	lblEmployeeHistory.setFont(new Font("Dialog", Font.BOLD, 16));
	lblEmployeeHistory.setBounds(185, 11, 148, 16);
	contentPane.add(lblEmployeeHistory);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(20, 61, 500, 247);
	contentPane.add(scrollPane_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane_1.setViewportView(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	
	JButton btnBack = new JButton("Back");
	btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnBack.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
	});
	btnBack.setBounds(272, 38, 96, 18);
	contentPane.add(btnBack);
	}
}

