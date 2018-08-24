package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	lblEmployee.setBounds(189, 13, 56, 16);
	frame.getContentPane().add(lblEmployee);
	lblEmployee.setText(Employee.getBadgeID());

	JButton btnSeeShifts = new JButton("See Shifts");
	btnSeeShifts.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Employee.Shifts();
		}
	});
	btnSeeShifts.setBounds(12, 54, 97, 25);
	frame.getContentPane().add(btnSeeShifts);

	JButton btnChangePassword = new JButton("Change Password");
	btnChangePassword.setBounds(12, 95, 135, 25);
	frame.getContentPane().add(btnChangePassword);

	JButton btnAskDayOff = new JButton("Ask day Off");
	btnAskDayOff.setBounds(12, 139, 97, 25);
	frame.getContentPane().add(btnAskDayOff);

	JButton btnInsertExtrahours = new JButton("Insert ExtraHours");
	btnInsertExtrahours.setBounds(12, 177, 146, 25);
	frame.getContentPane().add(btnInsertExtrahours);

	JButton btnVacationRentals = new JButton("Vacation Rentals");
	btnVacationRentals.setBounds(12, 215, 135, 25);
	frame.getContentPane().add(btnVacationRentals);
    }
}
