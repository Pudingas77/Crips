package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow();
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
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdministrator.setBounds(147, 13, 144, 25);
		frame.getContentPane().add(lblAdministrator);
		
		JButton btnNewOffice = new JButton("New Office");
		btnNewOffice.setBounds(37, 47, 114, 25);
		frame.getContentPane().add(btnNewOffice);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(37, 85, 114, 25);
		frame.getContentPane().add(btnDeleteUser);
		
		JButton btnUpdateOffice = new JButton("Update Office");
		btnUpdateOffice.setBounds(37, 123, 114, 25);
		frame.getContentPane().add(btnUpdateOffice);
		
		JButton btnSeeShiftFrom = new JButton("See Shift from");
		btnSeeShiftFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSeeShiftFrom.setBounds(31, 161, 126, 25);
		frame.getContentPane().add(btnSeeShiftFrom);
		
		JButton btnSeeWorkingHours = new JButton("See Working Hours");
		btnSeeWorkingHours.setBounds(31, 199, 144, 25);
		frame.getContentPane().add(btnSeeWorkingHours);
		
		JButton btnSeeWhoWanna = new JButton("See who wanna ask Day off");
		btnSeeWhoWanna.setBounds(181, 51, 191, 25);
		frame.getContentPane().add(btnSeeWhoWanna);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(191, 85, 97, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
