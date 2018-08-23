package Crips;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class OfficeOptions {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    OfficeOptions window = new OfficeOptions();
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
    public OfficeOptions() {
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
	
	JLabel lblChooseWhatYou = new JLabel("Choose what you want to do");
	lblChooseWhatYou.setBounds(208, 13, 162, 23);
	frame.getContentPane().add(lblChooseWhatYou);
	
	JButton btnConfirm = new JButton("Confirm");
	btnConfirm.setBounds(156, 215, 97, 25);
	frame.getContentPane().add(btnConfirm);
	
	textField = new JTextField();
	textField.setBounds(208, 102, 116, 22);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	String[] comboBoxx = { "Office Options", "Delete Office", "Register Office" };
	JComboBox comboBox = new JComboBox(comboBoxx);
	comboBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		
		JComboBox cb = (JComboBox) e.getSource();
		if (e.getSource() == comboBox) {
		    String msg = (String) cb.getSelectedItem();
		    JOptionPane.showMessageDialog(null, "you in");
		    switch (msg) {

		    case "User Options":
			lblChooseWhatYou.setText("Please choose if You want to Modify or Delete a user");
			break;
		    case "Delete Office":
			JOptionPane.showMessageDialog(null, "you in");
			lblChooseWhatYou.setText("Enter a BadgeID and press confirm");
			btnConfirm.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				String OfficeID = textField.getText();
				FunctionsSQL.DeleteOffice(OfficeID);
			    }
			});
			
			break;
		    case "Register Office":
			 JOptionPane.showMessageDialog(null, "you in reg");
			lblChooseWhatYou.setText("Enter a BadgeID and press confirm");
			btnConfirm.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				
				String Office = textField.getText();
				FunctionsSQL.RegisterOffice(Office);
			    }
			});
			break;

		    }
		}
		

	    }
	});
	comboBox.setBounds(22, 84, 123, 22);
	frame.getContentPane().add(comboBox);
    }
}
