package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class AdminWindow {

    private JFrame frame;
    private JTextField textField;
    private JTextField tst;

    /**
     * Launch the application.
     */
    public static void main() {
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
	
	JButton btnUserOptions = new JButton("User Options");
	btnUserOptions.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    UserOption.main();
		    frame.dispose();
		}
	});
	
	btnUserOptions.setBounds(12, 49, 135, 25);
	frame.getContentPane().add(btnUserOptions);
	
	
	JButton btnOfficeOptions = new JButton("Office Options");
	btnOfficeOptions.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    ;
		    OfficeOptions.main();
		    frame.dispose();
		   
		}
	});
	btnOfficeOptions.setBounds(12, 87, 135, 25);
	frame.getContentPane().add(btnOfficeOptions);
	
	JButton btnNewButton = new JButton("Vacation Request");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    MessagesStored.main();
		    frame.dispose();
		}
	});
	btnNewButton.setBounds(12, 125, 135, 25);
	frame.getContentPane().add(btnNewButton);
	

    }
}
