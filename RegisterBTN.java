package Crips;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class RegisterBTN {

	private JFrame frame;
	private JTextField txtBadgeID;
	private JTextField txtOfficeID;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterBTN window = new RegisterBTN();
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
	public RegisterBTN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 403, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(147, 29, 55, 15);
		frame.getContentPane().add(lblRegister);

		JLabel lblBadgeID = new JLabel("BadgeID");
		lblBadgeID.setBounds(44, 61, 79, 16);
		frame.getContentPane().add(lblBadgeID);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(44, 133, 56, 16);
		frame.getContentPane().add(lblName);

		JLabel lblOfficeid = new JLabel("OfficeID");
		lblOfficeid.setBounds(44, 99, 56, 16);
		frame.getContentPane().add(lblOfficeid);

		JLabel lblLastName = new JLabel("LastName");
		lblLastName.setBounds(44, 168, 56, 16);
		frame.getContentPane().add(lblLastName);

		txtBadgeID = new JTextField();
		txtBadgeID.setBounds(179, 58, 116, 22);
		frame.getContentPane().add(txtBadgeID);
		txtBadgeID.setColumns(10);

		txtOfficeID = new JTextField();
		txtOfficeID.setBounds(179, 93, 116, 22);
		frame.getContentPane().add(txtOfficeID);
		txtOfficeID.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(179, 128, 116, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setBounds(179, 163, 116, 22);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = txtBadgeID.getText();
				String Name = txtName.getText();
				String LastName = txtLastName.getText();
				String OfficeID = txtOfficeID.getText();
				String Password = txtLastName.getText();

				if (UserCreator.CreateUser(ID, OfficeID, Name, LastName, Password)) {
					txtBadgeID.setText(null);
					txtOfficeID.setText(null);
					txtName.setText(null);
					txtLastName.setText(null);
					txtPassword.setText(null);
					Login_System.main();
					frame.dispose();
				} else {
					txtBadgeID.setText(null);
					txtPassword.setText(null);
					txtOfficeID.setText(null);

				}
			}
		});

		txtPassword = new JTextField();
		txtPassword.setBounds(179, 198, 116, 22);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		btnRegister.setBounds(126, 237, 97, 25);
		frame.getContentPane().add(btnRegister);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(44, 203, 56, 16);
		frame.getContentPane().add(lblPassword);

	}
}
