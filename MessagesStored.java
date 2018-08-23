package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessagesStored {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MessagesStored window = new MessagesStored();
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
    public MessagesStored() {
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
	
	table = new JTable();
	table.setEnabled(false);
	table.setBounds(12, 56, 408, 184);
	frame.getContentPane().add(table);
	
	JButton btnNewButton = new JButton("New button");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    FunctionsSQL.MessageStore(table);
		}
	});
	btnNewButton.setBounds(163, 13, 97, 25);
	frame.getContentPane().add(btnNewButton);
    }

}
