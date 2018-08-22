package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JSlider;

public class Login_System {

    private JFrame frame;
    private JTextField txtBadgeID;
    private JPasswordField txtPassword;

    /**
     * Launch the application.
     */
    public static void main() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Login_System window = new Login_System();
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
    public Login_System() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(200, 200, 500, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("Login");
	lblNewLabel.setBounds(225, 25, 55, 15);
	frame.getContentPane().add(lblNewLabel);

	JLabel lblBadgeID = new JLabel("BadgeID");
	lblBadgeID.setBounds(44, 108, 79, 16);
	frame.getContentPane().add(lblBadgeID);

	JLabel lblNewLabel_2 = new JLabel("Password");
	lblNewLabel_2.setBounds(44, 153, 56, 16);
	frame.getContentPane().add(lblNewLabel_2);

	txtBadgeID = new JTextField();
	txtBadgeID.setBounds(220, 105, 116, 22);
	frame.getContentPane().add(txtBadgeID);
	txtBadgeID.setColumns(10);

	txtPassword = new JPasswordField();
	txtPassword.setBounds(220, 150, 116, 22);
	frame.getContentPane().add(txtPassword);

	JButton btnLogin = new JButton("Login");
	btnLogin.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String BadgeID = txtBadgeID.getText();
		String Password = txtPassword.getText();
		if (UserLogin.UserLogin(BadgeID, Password)) {
		    if (UserLogin.IsAdmin()) {

			JOptionPane.showMessageDialog(null, "Logged has an ADMIN");
			AdminWindow.main();
			frame.dispose();
		    } else {
			EmployeeWindow.main();
			frame.dispose();
		    }
		}
	    }
	});
	btnLogin.setBounds(12, 215, 97, 25);
	frame.getContentPane().add(btnLogin);

	JButton btnReset = new JButton("Reset");
	btnReset.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		txtBadgeID.setText(null);
		txtPassword.setText(null);

	    }
	});
	btnReset.setBounds(121, 215, 97, 25);
	frame.getContentPane().add(btnReset);

	JButton btnExit = new JButton("Exit");
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		frame.dispose();

	    }
	});
	btnExit.setBounds(373, 215, 97, 25);
	frame.getContentPane().add(btnExit);

	JButton btnRegister = new JButton("Register");
	btnRegister.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		RegisterBTN.main();
	    }
	});
	btnRegister.setBounds(264, 215, 97, 25);
	frame.getContentPane().add(btnRegister);
    }
}
