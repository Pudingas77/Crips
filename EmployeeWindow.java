package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmployeeWindow {

    
    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    EmployeeWindow window = new EmployeeWindow();
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
    public EmployeeWindow() {
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
	
	JLabel lblEmployee = new JLabel("Employee");
	lblEmployee.setBounds(209, 43, 56, 16);
	frame.getContentPane().add(lblEmployee);
	lblEmployee.setText(Employee.getBadgeID());
    }

}
