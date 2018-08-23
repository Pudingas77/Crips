package Crips;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class UserOptions {

    private JFrame frame;
    private JTextField txtBadgeID;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserOptions window = new UserOptions();
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
    public UserOptions() {
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

	JLabel lblNewLabel = new JLabel("Administrator");
	lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
	lblNewLabel.setBounds(130, 13, 196, 39);
	frame.getContentPane().add(lblNewLabel);
	JButton btnRegister = new JButton("Register New User");
	btnRegister.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		RegisterBTN.main();
	    }
	});
	btnRegister.setBounds(264, 215, 139, 25);
	frame.getContentPane().add(btnRegister);
	JLabel lblappearsafterclick = new JLabel("");
	lblappearsafterclick.setBounds(194, 84, 158, 16);
	frame.getContentPane().add(lblappearsafterclick);

	JButton btnConfirm = new JButton("Confirm");
	

	btnConfirm.setBounds(264, 187, 97, 25);
	frame.getContentPane().add(btnConfirm);
	
	String[] comboBoxx = { "User Options", "Delete User", "Modify User" };
	JComboBox comboBox = new JComboBox(comboBoxx);
	comboBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		
		JComboBox cb = (JComboBox) e.getSource();
		if (e.getSource() == comboBox) {
		    String msg = (String) cb.getSelectedItem();
		    JOptionPane.showMessageDialog(null, "you in");
		    switch (msg) {

		    case "User Options":
			lblappearsafterclick.setText("Please choose if You want to Modify or Delete a user");
			break;
		    case "Delete User":
			lblappearsafterclick.setText("Enter a BadgeID and press confirm");
			btnConfirm.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				String BadgeID = txtBadgeID.getText();
				FunctionsSQL.DeleteUser(BadgeID);
			    }
			});
			
			break;
		    case "Modify User":
			lblappearsafterclick.setText("Enter a BadgeID and press confirm");
			btnConfirm.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
				String BadgeID = txtBadgeID.getText();
				String WhereToModify= textField.getText();
				String Modified = textField_1.getText();
				FunctionsSQL.ModifyUser(BadgeID, WhereToModify, Modified);
			    }
			});
			break;

		    }
		}

	    }
	});
	comboBox.setBounds(22, 84, 103, 22);
	frame.getContentPane().add(comboBox);

	txtBadgeID = new JTextField();
	txtBadgeID.setBounds(187, 127, 165, 22);
	frame.getContentPane().add(txtBadgeID);
	txtBadgeID.setColumns(10);
	
	textField = new JTextField();
	textField.setBounds(187, 102, 116, 22);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(187, 78, 116, 22);
	frame.getContentPane().add(textField_1);
	textField_1.setColumns(10);

    }
}
