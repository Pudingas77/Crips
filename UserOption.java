package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserOption {

    private JFrame frame;
    private JTable table;
    private JTextField txtBadgeID;
    private JTextField txtOfficeID;
    private JTextField txtName;
    private JTextField txtLastName;
    private JTextField txtPassword;
    private JTextField txtNewPassword;

    /**
     * Launch the application.
     */
    public static void main() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserOption window = new UserOption();
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
    public UserOption() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 650, 570);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JButton btnLoadEmployers = new JButton("Load Employers");
	btnLoadEmployers.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		FunctionsSQL.EmployersData(table);
	    }
	});
	btnLoadEmployers.setBounds(287, 33, 162, 25);
	frame.getContentPane().add(btnLoadEmployers);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(213, 97, 407, 357);
	frame.getContentPane().add(scrollPane);

	table = new JTable();

	table.setShowVerticalLines(false);
	scrollPane.setViewportView(table);

	JLabel lblBadgeid = new JLabel("BadgeID");
	lblBadgeid.setBounds(12, 107, 72, 25);
	frame.getContentPane().add(lblBadgeid);

	JLabel lblOfficeid = new JLabel("OfficeID");
	lblOfficeid.setBounds(12, 140, 56, 16);
	frame.getContentPane().add(lblOfficeid);

	JLabel lblName = new JLabel("Name");
	lblName.setBounds(12, 169, 56, 16);
	frame.getContentPane().add(lblName);

	JLabel lblLastname = new JLabel("LastName");
	lblLastname.setBounds(12, 198, 56, 16);
	frame.getContentPane().add(lblLastname);

	JLabel lblNewPassword = new JLabel("New Password");
	lblNewPassword.setBounds(12, 254, 56, 16);
	frame.getContentPane().add(lblNewPassword);
	
	JLabel lblNewPassword1 = new JLabel("New Password");
	lblNewPassword1.setBounds(12, 227, 56, 16);
	frame.getContentPane().add(lblNewPassword1);
	
	txtNewPassword = new JTextField();
	txtNewPassword.setColumns(10);
	txtNewPassword.setBounds(85, 251, 116, 22);
	frame.getContentPane().add(txtNewPassword);

	txtBadgeID = new JTextField();
	txtBadgeID.setBounds(85, 108, 116, 22);
	frame.getContentPane().add(txtBadgeID);
	txtBadgeID.setColumns(10);

	txtOfficeID = new JTextField();
	txtOfficeID.setBounds(85, 137, 116, 22);
	frame.getContentPane().add(txtOfficeID);
	txtOfficeID.setColumns(10);

	txtName = new JTextField();
	txtName.setBounds(85, 166, 116, 22);
	frame.getContentPane().add(txtName);
	txtName.setColumns(10);

	txtLastName = new JTextField();
	txtLastName.setBounds(85, 195, 116, 22);
	frame.getContentPane().add(txtLastName);
	txtLastName.setColumns(10);

	txtPassword = new JTextField();
	txtPassword.setBounds(85, 222, 116, 22);
	frame.getContentPane().add(txtPassword);
	txtPassword.setColumns(10);

	JButton btnRegisterNewUser = new JButton("Register New User");
	btnRegisterNewUser.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String BadgeID = txtBadgeID.getText();
		String OfficeID = txtOfficeID.getText();
		String Name = txtName.getText();
		String LastName = txtLastName.getText();
		String Password = txtPassword.getText();

		FunctionsSQL.CreateUser(BadgeID, OfficeID, Name, LastName, Password);
		FunctionsSQL.EmployersData(table);
		
	    }
	});

	btnRegisterNewUser.setBounds(12, 294, 162, 25);
	frame.getContentPane().add(btnRegisterNewUser);

	JButton btnEditUser = new JButton("Edit User");
	btnEditUser.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String BadgeID = txtBadgeID.getText();
		String OfficeID = txtOfficeID.getText();
		String Name = txtName.getText();
		String LastName = txtLastName.getText();
		FunctionsSQL.Modify(BadgeID, Name, LastName, OfficeID);
		FunctionsSQL.EmployersData(table);
	    }
	});
	btnEditUser.setBounds(12, 332, 162, 25);
	frame.getContentPane().add(btnEditUser);

	JButton btnDeleteUser = new JButton("Delete User");
	btnDeleteUser.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String BadgeID = txtBadgeID.getText();
		FunctionsSQL.DeleteUser(BadgeID);
		FunctionsSQL.EmployersData(table);
	    }
	});
	btnDeleteUser.setBounds(12, 370, 162, 25);
	frame.getContentPane().add(btnDeleteUser);
	
	JButton btnChangePassword = new JButton("Change Password");
	btnChangePassword.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String BadgeID = txtBadgeID.getText();
		    String Password = txtPassword.getText();
		    String Password1 = txtNewPassword.getText();
		    FunctionsSQL.NewPassword(BadgeID, Password, Password1);
		}
	});
	btnChangePassword.setBounds(12, 408, 162, 25);
	frame.getContentPane().add(btnChangePassword);
	
	

    }
}
