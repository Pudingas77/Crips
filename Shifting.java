package Crips;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class Shifting {

    private static JFrame frame;
    private JTextField txtOffice;
    private JTextField txtTill;
    JComboBox comboBox;
    private JTextField txtOfficeOpeeningHours;
    private JTextField txtOfficeClosingHours;

    /*
     * public void fillComboBox(){ try{ String query =
     * "SELECT * FROM test WHERE OfficeID ='%s';"; PreparedStatement pst =
     * connection.prepareStatement(query); }catch (Exception e) {
     * e.printStackTrace(); } }
     */
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {

	    public void run() {
		try {
		    Shifting window = new Shifting();
		    window.frame.setVisible(true);
		    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//    JScrollPane scroll = new JScrollPane(frame, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	//	  frame.add(scroll);

		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public Shifting() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    private void initialize() {
	
	frame = new JFrame();
	frame.setAlwaysOnTop(true);
	frame.setBounds(100, 100, 1635, 880);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblMonday = new JLabel("Monday");
	lblMonday.setBounds(207, 30, 56, 16);
	frame.getContentPane().add(lblMonday);

	Panel p730 = new Panel();
	p730.setFont(new Font("Dialog", Font.PLAIN, 5));
	p730.setBackground(Color.BLACK);
	p730.setBounds(38, 75, 15, 10);
	frame.getContentPane().add(p730);

	Panel p8 = new Panel();
	p8.setFont(new Font("Dialog", Font.PLAIN, 5));
	p8.setBackground(Color.BLACK);
	p8.setBounds(53, 75, 15, 10);
	frame.getContentPane().add(p8);

	Panel p830 = new Panel();
	p830.setFont(new Font("Dialog", Font.PLAIN, 5));
	p830.setBackground(Color.BLACK);
	p830.setBounds(68, 75, 15, 10);
	frame.getContentPane().add(p830);

	Panel p9 = new Panel();
	p9.setFont(new Font("Dialog", Font.PLAIN, 5));
	p9.setBackground(Color.BLACK);
	p9.setBounds(83, 75, 15, 10);
	frame.getContentPane().add(p9);

	Panel p930 = new Panel();
	p930.setFont(new Font("Dialog", Font.PLAIN, 5));
	p930.setBackground(Color.BLACK);
	p930.setBounds(98, 75, 15, 10);
	frame.getContentPane().add(p930);

	Panel p10 = new Panel();
	p10.setFont(new Font("Dialog", Font.PLAIN, 5));
	p10.setBackground(Color.BLACK);
	p10.setBounds(113, 75, 15, 10);
	frame.getContentPane().add(p10);

	Panel p1030 = new Panel();
	p1030.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1030.setBackground(Color.BLACK);
	p1030.setBounds(128, 75, 15, 10);
	frame.getContentPane().add(p1030);

	Panel p11 = new Panel();
	p11.setFont(new Font("Dialog", Font.PLAIN, 5));
	p11.setBackground(Color.BLACK);
	p11.setBounds(143, 75, 15, 10);
	frame.getContentPane().add(p11);

	Panel p1130 = new Panel();
	p1130.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1130.setBackground(Color.BLACK);
	p1130.setBounds(158, 75, 15, 10);
	frame.getContentPane().add(p1130);

	Panel p12 = new Panel();
	p12.setFont(new Font("Dialog", Font.PLAIN, 5));
	p12.setBackground(Color.BLACK);
	p12.setBounds(173, 75, 15, 10);
	frame.getContentPane().add(p12);

	Panel p1230 = new Panel();
	p1230.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1230.setBackground(Color.BLACK);
	p1230.setBounds(188, 75, 15, 10);
	frame.getContentPane().add(p1230);

	Panel p13 = new Panel();
	p13.setFont(new Font("Dialog", Font.PLAIN, 5));
	p13.setBackground(Color.BLACK);
	p13.setBounds(203, 75, 15, 10);
	frame.getContentPane().add(p13);

	Panel p1330 = new Panel();
	p1330.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1330.setBackground(Color.BLACK);
	p1330.setBounds(218, 75, 15, 10);
	frame.getContentPane().add(p1330);

	Panel p14 = new Panel();
	p14.setFont(new Font("Dialog", Font.PLAIN, 5));
	p14.setBackground(Color.BLACK);
	p14.setBounds(233, 75, 15, 10);
	frame.getContentPane().add(p14);

	Panel p1430 = new Panel();
	p1430.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1430.setBackground(Color.BLACK);
	p1430.setBounds(248, 75, 15, 10);
	frame.getContentPane().add(p1430);

	Panel p15 = new Panel();
	p15.setFont(new Font("Dialog", Font.PLAIN, 5));
	p15.setBackground(Color.BLACK);
	p15.setBounds(263, 75, 15, 10);
	frame.getContentPane().add(p15);

	Panel p1530 = new Panel();
	p1530.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1530.setBackground(Color.BLACK);
	p1530.setBounds(278, 75, 15, 10);
	frame.getContentPane().add(p1530);

	Panel p16 = new Panel();
	p16.setFont(new Font("Dialog", Font.PLAIN, 5));
	p16.setBackground(Color.BLACK);
	p16.setBounds(293, 75, 15, 10);
	frame.getContentPane().add(p16);

	Panel p1630 = new Panel();
	p1630.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1630.setBackground(Color.BLACK);
	p1630.setBounds(308, 75, 15, 10);
	frame.getContentPane().add(p1630);

	Panel p17 = new Panel();
	p17.setFont(new Font("Dialog", Font.PLAIN, 5));
	p17.setBackground(Color.BLACK);
	p17.setBounds(323, 75, 15, 10);
	frame.getContentPane().add(p17);

	Panel p1730 = new Panel();
	p1730.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1730.setBackground(Color.BLACK);
	p1730.setBounds(338, 75, 15, 10);
	frame.getContentPane().add(p1730);

	Panel p18 = new Panel();
	p18.setFont(new Font("Dialog", Font.PLAIN, 5));
	p18.setBackground(Color.BLACK);
	p18.setBounds(353, 75, 15, 10);
	frame.getContentPane().add(p18);

	Panel p1830 = new Panel();
	p1830.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1830.setBackground(Color.BLACK);
	p1830.setBounds(368, 75, 15, 10);
	frame.getContentPane().add(p1830);

	Panel p19 = new Panel();
	p19.setFont(new Font("Dialog", Font.PLAIN, 5));
	p19.setBackground(Color.BLACK);
	p19.setBounds(383, 75, 15, 10);
	frame.getContentPane().add(p19);

	Panel p1930 = new Panel();
	p1930.setFont(new Font("Dialog", Font.PLAIN, 5));
	p1930.setBackground(Color.BLACK);
	p1930.setBounds(398, 75, 15, 10);
	frame.getContentPane().add(p1930);

	Panel p20 = new Panel();
	p20.setFont(new Font("Dialog", Font.PLAIN, 5));
	p20.setBackground(Color.BLACK);
	p20.setBounds(413, 75, 15, 10);
	frame.getContentPane().add(p20);

	Panel panel = new Panel();
	panel.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel.setBackground(Color.BLACK);
	panel.setBounds(38, 91, 15, 10);
	frame.getContentPane().add(panel);

	Panel panel_1 = new Panel();
	panel_1.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_1.setBackground(Color.BLACK);
	panel_1.setBounds(53, 91, 15, 10);
	frame.getContentPane().add(panel_1);

	Panel panel_2 = new Panel();
	panel_2.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_2.setBackground(Color.BLACK);
	panel_2.setBounds(68, 91, 15, 10);
	frame.getContentPane().add(panel_2);

	Panel panel_3 = new Panel();
	panel_3.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_3.setBackground(Color.BLACK);
	panel_3.setBounds(83, 91, 15, 10);
	frame.getContentPane().add(panel_3);

	Panel panel_4 = new Panel();
	panel_4.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_4.setBackground(Color.BLACK);
	panel_4.setBounds(98, 91, 15, 10);
	frame.getContentPane().add(panel_4);

	Panel panel_5 = new Panel();
	panel_5.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_5.setBackground(Color.BLACK);
	panel_5.setBounds(113, 91, 15, 10);
	frame.getContentPane().add(panel_5);

	Panel panel_6 = new Panel();
	panel_6.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_6.setBackground(Color.BLACK);
	panel_6.setBounds(128, 91, 15, 10);
	frame.getContentPane().add(panel_6);

	Panel panel_7 = new Panel();
	panel_7.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_7.setBackground(Color.BLACK);
	panel_7.setBounds(143, 91, 15, 10);
	frame.getContentPane().add(panel_7);

	Panel panel_8 = new Panel();
	panel_8.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_8.setBackground(Color.BLACK);
	panel_8.setBounds(158, 91, 15, 10);
	frame.getContentPane().add(panel_8);

	Panel panel_9 = new Panel();
	panel_9.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_9.setBackground(Color.BLACK);
	panel_9.setBounds(173, 91, 15, 10);
	frame.getContentPane().add(panel_9);

	Panel panel_10 = new Panel();
	panel_10.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_10.setBackground(Color.BLACK);
	panel_10.setBounds(188, 91, 15, 10);
	frame.getContentPane().add(panel_10);

	Panel panel_11 = new Panel();
	panel_11.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_11.setBackground(Color.BLACK);
	panel_11.setBounds(203, 91, 15, 10);
	frame.getContentPane().add(panel_11);

	Panel panel_12 = new Panel();
	panel_12.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_12.setBackground(Color.BLACK);
	panel_12.setBounds(218, 91, 15, 10);
	frame.getContentPane().add(panel_12);

	Panel panel_13 = new Panel();
	panel_13.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_13.setBackground(Color.BLACK);
	panel_13.setBounds(233, 91, 15, 10);
	frame.getContentPane().add(panel_13);

	Panel panel_14 = new Panel();
	panel_14.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_14.setBackground(Color.BLACK);
	panel_14.setBounds(248, 91, 15, 10);
	frame.getContentPane().add(panel_14);

	Panel panel_15 = new Panel();
	panel_15.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_15.setBackground(Color.BLACK);
	panel_15.setBounds(263, 91, 15, 10);
	frame.getContentPane().add(panel_15);

	Panel panel_16 = new Panel();
	panel_16.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_16.setBackground(Color.BLACK);
	panel_16.setBounds(278, 91, 15, 10);
	frame.getContentPane().add(panel_16);

	Panel panel_17 = new Panel();
	panel_17.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_17.setBackground(Color.BLACK);
	panel_17.setBounds(293, 91, 15, 10);
	frame.getContentPane().add(panel_17);

	Panel panel_18 = new Panel();
	panel_18.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_18.setBackground(Color.BLACK);
	panel_18.setBounds(308, 91, 15, 10);
	frame.getContentPane().add(panel_18);

	Panel panel_19 = new Panel();
	panel_19.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_19.setBackground(Color.BLACK);
	panel_19.setBounds(323, 91, 15, 10);
	frame.getContentPane().add(panel_19);

	Panel panel_20 = new Panel();
	panel_20.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_20.setBackground(Color.BLACK);
	panel_20.setBounds(338, 91, 15, 10);
	frame.getContentPane().add(panel_20);

	Panel panel_21 = new Panel();
	panel_21.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_21.setBackground(Color.BLACK);
	panel_21.setBounds(353, 91, 15, 10);
	frame.getContentPane().add(panel_21);

	Panel panel_22 = new Panel();
	panel_22.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_22.setBackground(Color.BLACK);
	panel_22.setBounds(368, 91, 15, 10);
	frame.getContentPane().add(panel_22);

	Panel panel_23 = new Panel();
	panel_23.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_23.setBackground(Color.BLACK);
	panel_23.setBounds(383, 91, 15, 10);
	frame.getContentPane().add(panel_23);

	Panel panel_24 = new Panel();
	panel_24.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_24.setBackground(Color.BLACK);
	panel_24.setBounds(398, 91, 15, 10);
	frame.getContentPane().add(panel_24);

	Panel panel_25 = new Panel();
	panel_25.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_25.setBackground(Color.BLACK);
	panel_25.setBounds(413, 91, 15, 10);
	frame.getContentPane().add(panel_25);

	JLabel label = new JLabel("07:30");
	label.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label.setBounds(38, 53, 15, 16);
	frame.getContentPane().add(label);

	JLabel label_1 = new JLabel("20:00");
	label_1.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_1.setBounds(413, 50, 56, 16);
	frame.getContentPane().add(label_1);

	JLabel lblTuesday = new JLabel("Tuesday");
	lblTuesday.setBounds(650, 30, 56, 16);
	frame.getContentPane().add(lblTuesday);

	Panel panel_26 = new Panel();
	panel_26.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_26.setBackground(Color.BLACK);
	panel_26.setBounds(481, 75, 15, 10);
	frame.getContentPane().add(panel_26);

	Panel panel_27 = new Panel();
	panel_27.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_27.setBackground(Color.BLACK);
	panel_27.setBounds(496, 75, 15, 10);
	frame.getContentPane().add(panel_27);

	Panel panel_28 = new Panel();
	panel_28.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_28.setBackground(Color.BLACK);
	panel_28.setBounds(511, 75, 15, 10);
	frame.getContentPane().add(panel_28);

	Panel panel_29 = new Panel();
	panel_29.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_29.setBackground(Color.BLACK);
	panel_29.setBounds(526, 75, 15, 10);
	frame.getContentPane().add(panel_29);

	Panel panel_30 = new Panel();
	panel_30.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_30.setBackground(Color.BLACK);
	panel_30.setBounds(541, 75, 15, 10);
	frame.getContentPane().add(panel_30);

	Panel panel_31 = new Panel();
	panel_31.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_31.setBackground(Color.BLACK);
	panel_31.setBounds(556, 75, 15, 10);
	frame.getContentPane().add(panel_31);

	Panel panel_32 = new Panel();
	panel_32.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_32.setBackground(Color.BLACK);
	panel_32.setBounds(571, 75, 15, 10);
	frame.getContentPane().add(panel_32);

	Panel panel_33 = new Panel();
	panel_33.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_33.setBackground(Color.BLACK);
	panel_33.setBounds(586, 75, 15, 10);
	frame.getContentPane().add(panel_33);

	Panel panel_34 = new Panel();
	panel_34.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_34.setBackground(Color.BLACK);
	panel_34.setBounds(601, 75, 15, 10);
	frame.getContentPane().add(panel_34);

	Panel panel_35 = new Panel();
	panel_35.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_35.setBackground(Color.BLACK);
	panel_35.setBounds(616, 75, 15, 10);
	frame.getContentPane().add(panel_35);

	Panel panel_36 = new Panel();
	panel_36.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_36.setBackground(Color.BLACK);
	panel_36.setBounds(631, 75, 15, 10);
	frame.getContentPane().add(panel_36);

	Panel panel_37 = new Panel();
	panel_37.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_37.setBackground(Color.BLACK);
	panel_37.setBounds(646, 75, 15, 10);
	frame.getContentPane().add(panel_37);

	Panel panel_38 = new Panel();
	panel_38.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_38.setBackground(Color.BLACK);
	panel_38.setBounds(661, 75, 15, 10);
	frame.getContentPane().add(panel_38);

	Panel panel_39 = new Panel();
	panel_39.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_39.setBackground(Color.BLACK);
	panel_39.setBounds(676, 75, 15, 10);
	frame.getContentPane().add(panel_39);

	Panel panel_40 = new Panel();
	panel_40.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_40.setBackground(Color.BLACK);
	panel_40.setBounds(691, 75, 15, 10);
	frame.getContentPane().add(panel_40);

	Panel panel_41 = new Panel();
	panel_41.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_41.setBackground(Color.BLACK);
	panel_41.setBounds(706, 75, 15, 10);
	frame.getContentPane().add(panel_41);

	Panel panel_42 = new Panel();
	panel_42.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_42.setBackground(Color.BLACK);
	panel_42.setBounds(721, 75, 15, 10);
	frame.getContentPane().add(panel_42);

	Panel panel_43 = new Panel();
	panel_43.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_43.setBackground(Color.BLACK);
	panel_43.setBounds(736, 75, 15, 10);
	frame.getContentPane().add(panel_43);

	Panel panel_44 = new Panel();
	panel_44.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_44.setBackground(Color.BLACK);
	panel_44.setBounds(751, 75, 15, 10);
	frame.getContentPane().add(panel_44);

	Panel panel_45 = new Panel();
	panel_45.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_45.setBackground(Color.BLACK);
	panel_45.setBounds(766, 75, 15, 10);
	frame.getContentPane().add(panel_45);

	Panel panel_46 = new Panel();
	panel_46.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_46.setBackground(Color.BLACK);
	panel_46.setBounds(781, 75, 15, 10);
	frame.getContentPane().add(panel_46);

	Panel panel_47 = new Panel();
	panel_47.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_47.setBackground(Color.BLACK);
	panel_47.setBounds(796, 75, 15, 10);
	frame.getContentPane().add(panel_47);

	Panel panel_48 = new Panel();
	panel_48.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_48.setBackground(Color.BLACK);
	panel_48.setBounds(811, 75, 15, 10);
	frame.getContentPane().add(panel_48);

	Panel panel_49 = new Panel();
	panel_49.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_49.setBackground(Color.BLACK);
	panel_49.setBounds(826, 75, 15, 10);
	frame.getContentPane().add(panel_49);

	Panel panel_50 = new Panel();
	panel_50.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_50.setBackground(Color.BLACK);
	panel_50.setBounds(841, 75, 15, 10);
	frame.getContentPane().add(panel_50);

	Panel panel_51 = new Panel();
	panel_51.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_51.setBackground(Color.BLACK);
	panel_51.setBounds(856, 75, 15, 10);
	frame.getContentPane().add(panel_51);

	Panel panel_52 = new Panel();
	panel_52.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_52.setBackground(Color.BLACK);
	panel_52.setBounds(481, 91, 15, 10);
	frame.getContentPane().add(panel_52);

	Panel panel_53 = new Panel();
	panel_53.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_53.setBackground(Color.BLACK);
	panel_53.setBounds(496, 91, 15, 10);
	frame.getContentPane().add(panel_53);

	Panel panel_54 = new Panel();
	panel_54.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_54.setBackground(Color.BLACK);
	panel_54.setBounds(511, 91, 15, 10);
	frame.getContentPane().add(panel_54);

	Panel panel_55 = new Panel();
	panel_55.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_55.setBackground(Color.BLACK);
	panel_55.setBounds(526, 91, 15, 10);
	frame.getContentPane().add(panel_55);

	Panel panel_56 = new Panel();
	panel_56.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_56.setBackground(Color.BLACK);
	panel_56.setBounds(541, 91, 15, 10);
	frame.getContentPane().add(panel_56);

	Panel panel_57 = new Panel();
	panel_57.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_57.setBackground(Color.BLACK);
	panel_57.setBounds(556, 91, 15, 10);
	frame.getContentPane().add(panel_57);

	Panel panel_58 = new Panel();
	panel_58.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_58.setBackground(Color.BLACK);
	panel_58.setBounds(571, 91, 15, 10);
	frame.getContentPane().add(panel_58);

	Panel panel_59 = new Panel();
	panel_59.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_59.setBackground(Color.BLACK);
	panel_59.setBounds(586, 91, 15, 10);
	frame.getContentPane().add(panel_59);

	Panel panel_60 = new Panel();
	panel_60.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_60.setBackground(Color.BLACK);
	panel_60.setBounds(601, 91, 15, 10);
	frame.getContentPane().add(panel_60);

	Panel panel_61 = new Panel();
	panel_61.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_61.setBackground(Color.BLACK);
	panel_61.setBounds(616, 91, 15, 10);
	frame.getContentPane().add(panel_61);

	Panel panel_62 = new Panel();
	panel_62.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_62.setBackground(Color.BLACK);
	panel_62.setBounds(631, 91, 15, 10);
	frame.getContentPane().add(panel_62);

	Panel panel_63 = new Panel();
	panel_63.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_63.setBackground(Color.BLACK);
	panel_63.setBounds(646, 91, 15, 10);
	frame.getContentPane().add(panel_63);

	Panel panel_64 = new Panel();
	panel_64.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_64.setBackground(Color.BLACK);
	panel_64.setBounds(661, 91, 15, 10);
	frame.getContentPane().add(panel_64);

	Panel panel_65 = new Panel();
	panel_65.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_65.setBackground(Color.BLACK);
	panel_65.setBounds(676, 91, 15, 10);
	frame.getContentPane().add(panel_65);

	Panel panel_66 = new Panel();
	panel_66.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_66.setBackground(Color.BLACK);
	panel_66.setBounds(691, 91, 15, 10);
	frame.getContentPane().add(panel_66);

	Panel panel_67 = new Panel();
	panel_67.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_67.setBackground(Color.BLACK);
	panel_67.setBounds(706, 91, 15, 10);
	frame.getContentPane().add(panel_67);

	Panel panel_68 = new Panel();
	panel_68.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_68.setBackground(Color.BLACK);
	panel_68.setBounds(721, 91, 15, 10);
	frame.getContentPane().add(panel_68);

	Panel panel_69 = new Panel();
	panel_69.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_69.setBackground(Color.BLACK);
	panel_69.setBounds(736, 91, 15, 10);
	frame.getContentPane().add(panel_69);

	Panel panel_70 = new Panel();
	panel_70.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_70.setBackground(Color.BLACK);
	panel_70.setBounds(751, 91, 15, 10);
	frame.getContentPane().add(panel_70);

	Panel panel_71 = new Panel();
	panel_71.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_71.setBackground(Color.BLACK);
	panel_71.setBounds(766, 91, 15, 10);
	frame.getContentPane().add(panel_71);

	Panel panel_72 = new Panel();
	panel_72.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_72.setBackground(Color.BLACK);
	panel_72.setBounds(781, 91, 15, 10);
	frame.getContentPane().add(panel_72);

	Panel panel_73 = new Panel();
	panel_73.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_73.setBackground(Color.BLACK);
	panel_73.setBounds(796, 91, 15, 10);
	frame.getContentPane().add(panel_73);

	Panel panel_74 = new Panel();
	panel_74.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_74.setBackground(Color.BLACK);
	panel_74.setBounds(811, 91, 15, 10);
	frame.getContentPane().add(panel_74);

	Panel panel_75 = new Panel();
	panel_75.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_75.setBackground(Color.BLACK);
	panel_75.setBounds(826, 91, 15, 10);
	frame.getContentPane().add(panel_75);

	Panel panel_76 = new Panel();
	panel_76.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_76.setBackground(Color.BLACK);
	panel_76.setBounds(841, 91, 15, 10);
	frame.getContentPane().add(panel_76);

	Panel panel_77 = new Panel();
	panel_77.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_77.setBackground(Color.BLACK);
	panel_77.setBounds(856, 91, 15, 10);
	frame.getContentPane().add(panel_77);

	JLabel label_3 = new JLabel("7:30");
	label_3.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_3.setBounds(481, 53, 56, 16);
	frame.getContentPane().add(label_3);

	JLabel label_4 = new JLabel("20:00");
	label_4.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_4.setBounds(848, 50, 56, 16);
	frame.getContentPane().add(label_4);

	JLabel label_2 = new JLabel("08:00");
	label_2.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_2.setBounds(53, 53, 15, 16);
	frame.getContentPane().add(label_2);

	JLabel label_5 = new JLabel("08:30");
	label_5.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_5.setBounds(68, 53, 15, 16);
	frame.getContentPane().add(label_5);

	JLabel label_6 = new JLabel("09:00");
	label_6.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_6.setBounds(83, 53, 15, 16);
	frame.getContentPane().add(label_6);

	JLabel label_7 = new JLabel("09:30");
	label_7.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_7.setBounds(98, 53, 15, 16);
	frame.getContentPane().add(label_7);

	JLabel label_8 = new JLabel("10:00");
	label_8.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_8.setBounds(113, 53, 15, 16);
	frame.getContentPane().add(label_8);

	JLabel label_9 = new JLabel("10:30");
	label_9.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_9.setBounds(128, 53, 15, 16);
	frame.getContentPane().add(label_9);

	txtOffice = new JTextField();
	txtOffice.setText("OfficeID");
	txtOffice.setBounds(90, 673, 116, 22);
	frame.getContentPane().add(txtOffice);
	txtOffice.setColumns(10);

	JLabel lblop = new JLabel("1OP");
	lblop.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblop.setBounds(2, 70, 36, 15);
	frame.getContentPane().add(lblop);

	JLabel lblop_1 = new JLabel("2OP");
	lblop_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
	lblop_1.setBounds(2, 86, 36, 15);
	frame.getContentPane().add(lblop_1);

	JComboBox comboBox_2 = new JComboBox();
	comboBox_2.setBounds(755, 680, 185, 25);
	comboBox_2.addItem("Monday");
	comboBox_2.addItem("Tuesday");
	comboBox_2.addItem("Wednesday");
	comboBox_2.addItem("Thursday");
	comboBox_2.addItem("Friday");
	comboBox_2.addItem("Saturday");
	comboBox_2.addItem("Sunday");
	frame.getContentPane().add(comboBox_2);
	
	JComboBox comboBox_3 = new JComboBox();
	comboBox_3.setBounds(755, 719, 48, 24);
	comboBox_3.addItem("31");
	comboBox_3.addItem("30");
	comboBox_3.addItem("29");
	comboBox_3.addItem("28");
	frame.getContentPane().add(comboBox_3);
	
	JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setToolTipText("");
	comboBox_1.setBounds(523, 681, 206, 25);
	frame.getContentPane().add(comboBox_1);
	
	comboBox = new JComboBox();
	comboBox.setBounds(329, 684, 174, 22);
	frame.getContentPane().add(comboBox);

	JOptionPane.showMessageDialog(null, "Não quebres");
	JButton btnOK = new JButton("Ok");
	btnOK.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		if (FunctionsSQL.TillNumber(txtOffice.getText(), txtTill.getText(), frame)) {
		    
		    String OfficeID = txtOffice.getText();
		    FunctionsSQL.fillComboBox(OfficeID, comboBox);
		    comboBox_1.addItem("No Overlap,ThursOff");
		    comboBox_1.addItem("No Overlap,WedOFF");
		   if(Integer.parseInt(txtTill.getText())==2){
			comboBox_1.addItem("Overlap,Mon,Tue,Wed,ThursOFF");
			comboBox_1.addItem("Overlap,Mon,Tue,ThursOFF");
			comboBox_1.addItem("Overlap,Mon,ThursOFF");
			comboBox_1.addItem("Overlap,Mon,WedOFF");
			comboBox_1.addItem("Overlap,Mon,Fri,WedOFF");
			comboBox_1.addItem("Overlap,Mon,Tue,WedOFF");
			comboBox_1.addItem("Overlap,Mon,Tue,Fri,WedOFF");
			
		   }
		}
		return;
	    }

	});
	btnOK.setBounds(218, 710, 97, 25);
	frame.getContentPane().add(btnOK);

	txtTill = new JTextField();
	txtTill.setText("TillCount");
	txtTill.setColumns(10);
	txtTill.setBounds(90, 697, 116, 22);
	frame.getContentPane().add(txtTill);

	JButton btnRetry = new JButton("Retry");
	btnRetry.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		comboBox.removeAllItems();
	    }
	});
	btnRetry.setBounds(218, 672, 97, 25);
	frame.getContentPane().add(btnRetry);

	JButton btnCashier = new JButton("Cashier 1");
	btnCashier.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (lblop_1.getText() == (String) comboBox.getSelectedItem()) {
		    JOptionPane.showMessageDialog(frame, "that cashier is already choosen for one schedule");
		} else {
		    lblop.setText((String) comboBox.getSelectedItem());
		}

	    }
	});

	btnCashier.setBounds(323, 711, 97, 25);
	frame.getContentPane().add(btnCashier);

	JButton btnCashier_1 = new JButton("Cashier 2");
	btnCashier_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (lblop.getText() == (String) comboBox.getSelectedItem()) {
		    JOptionPane.showMessageDialog(frame, "that cashier is already choosen for one schedule");
		} else {
		    lblop_1.setText((String) comboBox.getSelectedItem());
		}
	    }
	});
	btnCashier_1.setBounds(413, 711, 97, 25);
	frame.getContentPane().add(btnCashier_1);
	
	JButton btnSelectTimeplate = new JButton("Select Timeplate");
	btnSelectTimeplate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    comboBox_1.getSelectedItem();
		}
	});
	btnSelectTimeplate.setBounds(555, 650, 129, 25);
	frame.getContentPane().add(btnSelectTimeplate);
	
	JButton btnFirstWeekdayOf = new JButton("Select Starting Weekday");
	btnFirstWeekdayOf.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    comboBox_2.getSelectedItem();
		}
	});
	btnFirstWeekdayOf.setBounds(755, 650, 185, 25);
	frame.getContentPane().add(btnFirstWeekdayOf);
	
	JButton btnSelectMonthDays = new JButton("Select Month Days");
	btnSelectMonthDays.setBounds(803, 718, 137, 24);
	frame.getContentPane().add(btnSelectMonthDays);
	
	txtOfficeOpeeningHours = new JTextField();
	txtOfficeOpeeningHours.setText("Office Opening Hours");
	txtOfficeOpeeningHours.setBounds(962, 683, 129, 22);
	frame.getContentPane().add(txtOfficeOpeeningHours);
	txtOfficeOpeeningHours.setColumns(10);
	
	txtOfficeClosingHours = new JTextField();
	txtOfficeClosingHours.setText("Office Closing Hours");
	txtOfficeClosingHours.setColumns(10);
	txtOfficeClosingHours.setBounds(962, 711, 129, 22);
	frame.getContentPane().add(txtOfficeClosingHours);
	
	JButton btnGenerateSchedule = new JButton("Generate Schedule");
	btnGenerateSchedule.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnGenerateSchedule.setBounds(1103, 683, 187, 36);
	frame.getContentPane().add(btnGenerateSchedule);
	
	JLabel label_10 = new JLabel("Monday");
	label_10.setBounds(1058, 30, 56, 16);
	frame.getContentPane().add(label_10);
	
	Panel panel_78 = new Panel();
	panel_78.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_78.setBackground(Color.BLACK);
	panel_78.setBounds(889, 75, 15, 10);
	frame.getContentPane().add(panel_78);
	
	Panel panel_79 = new Panel();
	panel_79.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_79.setBackground(Color.BLACK);
	panel_79.setBounds(904, 75, 15, 10);
	frame.getContentPane().add(panel_79);
	
	Panel panel_80 = new Panel();
	panel_80.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_80.setBackground(Color.BLACK);
	panel_80.setBounds(919, 75, 15, 10);
	frame.getContentPane().add(panel_80);
	
	Panel panel_81 = new Panel();
	panel_81.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_81.setBackground(Color.BLACK);
	panel_81.setBounds(934, 75, 15, 10);
	frame.getContentPane().add(panel_81);
	
	Panel panel_82 = new Panel();
	panel_82.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_82.setBackground(Color.BLACK);
	panel_82.setBounds(949, 75, 15, 10);
	frame.getContentPane().add(panel_82);
	
	Panel panel_83 = new Panel();
	panel_83.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_83.setBackground(Color.BLACK);
	panel_83.setBounds(964, 75, 15, 10);
	frame.getContentPane().add(panel_83);
	
	Panel panel_84 = new Panel();
	panel_84.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_84.setBackground(Color.BLACK);
	panel_84.setBounds(979, 75, 15, 10);
	frame.getContentPane().add(panel_84);
	
	Panel panel_85 = new Panel();
	panel_85.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_85.setBackground(Color.BLACK);
	panel_85.setBounds(994, 75, 15, 10);
	frame.getContentPane().add(panel_85);
	
	Panel panel_86 = new Panel();
	panel_86.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_86.setBackground(Color.BLACK);
	panel_86.setBounds(1009, 75, 15, 10);
	frame.getContentPane().add(panel_86);
	
	Panel panel_87 = new Panel();
	panel_87.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_87.setBackground(Color.BLACK);
	panel_87.setBounds(1024, 75, 15, 10);
	frame.getContentPane().add(panel_87);
	
	Panel panel_88 = new Panel();
	panel_88.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_88.setBackground(Color.BLACK);
	panel_88.setBounds(1039, 75, 15, 10);
	frame.getContentPane().add(panel_88);
	
	Panel panel_89 = new Panel();
	panel_89.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_89.setBackground(Color.BLACK);
	panel_89.setBounds(1054, 75, 15, 10);
	frame.getContentPane().add(panel_89);
	
	Panel panel_90 = new Panel();
	panel_90.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_90.setBackground(Color.BLACK);
	panel_90.setBounds(1069, 75, 15, 10);
	frame.getContentPane().add(panel_90);
	
	Panel panel_91 = new Panel();
	panel_91.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_91.setBackground(Color.BLACK);
	panel_91.setBounds(1084, 75, 15, 10);
	frame.getContentPane().add(panel_91);
	
	Panel panel_92 = new Panel();
	panel_92.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_92.setBackground(Color.BLACK);
	panel_92.setBounds(1099, 75, 15, 10);
	frame.getContentPane().add(panel_92);
	
	Panel panel_93 = new Panel();
	panel_93.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_93.setBackground(Color.BLACK);
	panel_93.setBounds(1114, 75, 15, 10);
	frame.getContentPane().add(panel_93);
	
	Panel panel_94 = new Panel();
	panel_94.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_94.setBackground(Color.BLACK);
	panel_94.setBounds(1129, 75, 15, 10);
	frame.getContentPane().add(panel_94);
	
	Panel panel_95 = new Panel();
	panel_95.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_95.setBackground(Color.BLACK);
	panel_95.setBounds(1144, 75, 15, 10);
	frame.getContentPane().add(panel_95);
	
	Panel panel_96 = new Panel();
	panel_96.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_96.setBackground(Color.BLACK);
	panel_96.setBounds(1159, 75, 15, 10);
	frame.getContentPane().add(panel_96);
	
	Panel panel_97 = new Panel();
	panel_97.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_97.setBackground(Color.BLACK);
	panel_97.setBounds(1174, 75, 15, 10);
	frame.getContentPane().add(panel_97);
	
	Panel panel_98 = new Panel();
	panel_98.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_98.setBackground(Color.BLACK);
	panel_98.setBounds(1189, 75, 15, 10);
	frame.getContentPane().add(panel_98);
	
	Panel panel_99 = new Panel();
	panel_99.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_99.setBackground(Color.BLACK);
	panel_99.setBounds(1204, 75, 15, 10);
	frame.getContentPane().add(panel_99);
	
	Panel panel_100 = new Panel();
	panel_100.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_100.setBackground(Color.BLACK);
	panel_100.setBounds(1219, 75, 15, 10);
	frame.getContentPane().add(panel_100);
	
	Panel panel_101 = new Panel();
	panel_101.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_101.setBackground(Color.BLACK);
	panel_101.setBounds(1234, 75, 15, 10);
	frame.getContentPane().add(panel_101);
	
	Panel panel_102 = new Panel();
	panel_102.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_102.setBackground(Color.BLACK);
	panel_102.setBounds(1249, 75, 15, 10);
	frame.getContentPane().add(panel_102);
	
	Panel panel_103 = new Panel();
	panel_103.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_103.setBackground(Color.BLACK);
	panel_103.setBounds(1264, 75, 15, 10);
	frame.getContentPane().add(panel_103);
	
	Panel panel_104 = new Panel();
	panel_104.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_104.setBackground(Color.BLACK);
	panel_104.setBounds(889, 91, 15, 10);
	frame.getContentPane().add(panel_104);
	
	Panel panel_105 = new Panel();
	panel_105.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_105.setBackground(Color.BLACK);
	panel_105.setBounds(904, 91, 15, 10);
	frame.getContentPane().add(panel_105);
	
	Panel panel_106 = new Panel();
	panel_106.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_106.setBackground(Color.BLACK);
	panel_106.setBounds(919, 91, 15, 10);
	frame.getContentPane().add(panel_106);
	
	Panel panel_107 = new Panel();
	panel_107.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_107.setBackground(Color.BLACK);
	panel_107.setBounds(934, 91, 15, 10);
	frame.getContentPane().add(panel_107);
	
	Panel panel_108 = new Panel();
	panel_108.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_108.setBackground(Color.BLACK);
	panel_108.setBounds(949, 91, 15, 10);
	frame.getContentPane().add(panel_108);
	
	Panel panel_109 = new Panel();
	panel_109.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_109.setBackground(Color.BLACK);
	panel_109.setBounds(964, 91, 15, 10);
	frame.getContentPane().add(panel_109);
	
	Panel panel_110 = new Panel();
	panel_110.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_110.setBackground(Color.BLACK);
	panel_110.setBounds(979, 91, 15, 10);
	frame.getContentPane().add(panel_110);
	
	Panel panel_111 = new Panel();
	panel_111.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_111.setBackground(Color.BLACK);
	panel_111.setBounds(994, 91, 15, 10);
	frame.getContentPane().add(panel_111);
	
	Panel panel_112 = new Panel();
	panel_112.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_112.setBackground(Color.BLACK);
	panel_112.setBounds(1009, 91, 15, 10);
	frame.getContentPane().add(panel_112);
	
	Panel panel_113 = new Panel();
	panel_113.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_113.setBackground(Color.BLACK);
	panel_113.setBounds(1024, 91, 15, 10);
	frame.getContentPane().add(panel_113);
	
	Panel panel_114 = new Panel();
	panel_114.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_114.setBackground(Color.BLACK);
	panel_114.setBounds(1039, 91, 15, 10);
	frame.getContentPane().add(panel_114);
	
	Panel panel_115 = new Panel();
	panel_115.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_115.setBackground(Color.BLACK);
	panel_115.setBounds(1054, 91, 15, 10);
	frame.getContentPane().add(panel_115);
	
	Panel panel_116 = new Panel();
	panel_116.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_116.setBackground(Color.BLACK);
	panel_116.setBounds(1069, 91, 15, 10);
	frame.getContentPane().add(panel_116);
	
	Panel panel_117 = new Panel();
	panel_117.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_117.setBackground(Color.BLACK);
	panel_117.setBounds(1084, 91, 15, 10);
	frame.getContentPane().add(panel_117);
	
	Panel panel_118 = new Panel();
	panel_118.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_118.setBackground(Color.BLACK);
	panel_118.setBounds(1099, 91, 15, 10);
	frame.getContentPane().add(panel_118);
	
	Panel panel_119 = new Panel();
	panel_119.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_119.setBackground(Color.BLACK);
	panel_119.setBounds(1114, 91, 15, 10);
	frame.getContentPane().add(panel_119);
	
	Panel panel_120 = new Panel();
	panel_120.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_120.setBackground(Color.BLACK);
	panel_120.setBounds(1129, 91, 15, 10);
	frame.getContentPane().add(panel_120);
	
	Panel panel_121 = new Panel();
	panel_121.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_121.setBackground(Color.BLACK);
	panel_121.setBounds(1144, 91, 15, 10);
	frame.getContentPane().add(panel_121);
	
	Panel panel_122 = new Panel();
	panel_122.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_122.setBackground(Color.BLACK);
	panel_122.setBounds(1159, 91, 15, 10);
	frame.getContentPane().add(panel_122);
	
	Panel panel_123 = new Panel();
	panel_123.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_123.setBackground(Color.BLACK);
	panel_123.setBounds(1174, 91, 15, 10);
	frame.getContentPane().add(panel_123);
	
	Panel panel_124 = new Panel();
	panel_124.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_124.setBackground(Color.BLACK);
	panel_124.setBounds(1189, 91, 15, 10);
	frame.getContentPane().add(panel_124);
	
	Panel panel_125 = new Panel();
	panel_125.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_125.setBackground(Color.BLACK);
	panel_125.setBounds(1204, 91, 15, 10);
	frame.getContentPane().add(panel_125);
	
	Panel panel_126 = new Panel();
	panel_126.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_126.setBackground(Color.BLACK);
	panel_126.setBounds(1219, 91, 15, 10);
	frame.getContentPane().add(panel_126);
	
	Panel panel_127 = new Panel();
	panel_127.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_127.setBackground(Color.BLACK);
	panel_127.setBounds(1234, 91, 15, 10);
	frame.getContentPane().add(panel_127);
	
	Panel panel_128 = new Panel();
	panel_128.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_128.setBackground(Color.BLACK);
	panel_128.setBounds(1249, 91, 15, 10);
	frame.getContentPane().add(panel_128);
	
	Panel panel_129 = new Panel();
	panel_129.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_129.setBackground(Color.BLACK);
	panel_129.setBounds(1264, 91, 15, 10);
	frame.getContentPane().add(panel_129);
	
	JLabel label_11 = new JLabel("07:30");
	label_11.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_11.setBounds(889, 53, 15, 16);
	frame.getContentPane().add(label_11);
	
	JLabel label_12 = new JLabel("08:00");
	label_12.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_12.setBounds(904, 53, 15, 16);
	frame.getContentPane().add(label_12);
	
	JLabel label_13 = new JLabel("08:30");
	label_13.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_13.setBounds(919, 53, 15, 16);
	frame.getContentPane().add(label_13);
	
	JLabel label_14 = new JLabel("09:00");
	label_14.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_14.setBounds(934, 53, 15, 16);
	frame.getContentPane().add(label_14);
	
	JLabel label_15 = new JLabel("09:30");
	label_15.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_15.setBounds(949, 53, 15, 16);
	frame.getContentPane().add(label_15);
	
	JLabel label_16 = new JLabel("10:00");
	label_16.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_16.setBounds(964, 53, 15, 16);
	frame.getContentPane().add(label_16);
	
	JLabel label_17 = new JLabel("10:30");
	label_17.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_17.setBounds(979, 53, 15, 16);
	frame.getContentPane().add(label_17);
	
	JLabel label_18 = new JLabel("Monday");
	label_18.setBounds(1472, 30, 56, 16);
	frame.getContentPane().add(label_18);
	
	Panel panel_130 = new Panel();
	panel_130.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_130.setBackground(Color.BLACK);
	panel_130.setBounds(1303, 75, 15, 10);
	frame.getContentPane().add(panel_130);
	
	Panel panel_131 = new Panel();
	panel_131.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_131.setBackground(Color.BLACK);
	panel_131.setBounds(1318, 75, 15, 10);
	frame.getContentPane().add(panel_131);
	
	Panel panel_132 = new Panel();
	panel_132.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_132.setBackground(Color.BLACK);
	panel_132.setBounds(1333, 75, 15, 10);
	frame.getContentPane().add(panel_132);
	
	Panel panel_133 = new Panel();
	panel_133.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_133.setBackground(Color.BLACK);
	panel_133.setBounds(1348, 75, 15, 10);
	frame.getContentPane().add(panel_133);
	
	Panel panel_134 = new Panel();
	panel_134.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_134.setBackground(Color.BLACK);
	panel_134.setBounds(1363, 75, 15, 10);
	frame.getContentPane().add(panel_134);
	
	Panel panel_135 = new Panel();
	panel_135.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_135.setBackground(Color.BLACK);
	panel_135.setBounds(1378, 75, 15, 10);
	frame.getContentPane().add(panel_135);
	
	Panel panel_136 = new Panel();
	panel_136.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_136.setBackground(Color.BLACK);
	panel_136.setBounds(1393, 75, 15, 10);
	frame.getContentPane().add(panel_136);
	
	Panel panel_137 = new Panel();
	panel_137.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_137.setBackground(Color.BLACK);
	panel_137.setBounds(1408, 75, 15, 10);
	frame.getContentPane().add(panel_137);
	
	Panel panel_138 = new Panel();
	panel_138.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_138.setBackground(Color.BLACK);
	panel_138.setBounds(1423, 75, 15, 10);
	frame.getContentPane().add(panel_138);
	
	Panel panel_139 = new Panel();
	panel_139.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_139.setBackground(Color.BLACK);
	panel_139.setBounds(1438, 75, 15, 10);
	frame.getContentPane().add(panel_139);
	
	Panel panel_140 = new Panel();
	panel_140.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_140.setBackground(Color.BLACK);
	panel_140.setBounds(1453, 75, 15, 10);
	frame.getContentPane().add(panel_140);
	
	Panel panel_141 = new Panel();
	panel_141.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_141.setBackground(Color.BLACK);
	panel_141.setBounds(1468, 75, 15, 10);
	frame.getContentPane().add(panel_141);
	
	Panel panel_142 = new Panel();
	panel_142.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_142.setBackground(Color.BLACK);
	panel_142.setBounds(1483, 75, 15, 10);
	frame.getContentPane().add(panel_142);
	
	Panel panel_143 = new Panel();
	panel_143.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_143.setBackground(Color.BLACK);
	panel_143.setBounds(1498, 75, 15, 10);
	frame.getContentPane().add(panel_143);
	
	Panel panel_144 = new Panel();
	panel_144.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_144.setBackground(Color.BLACK);
	panel_144.setBounds(1513, 75, 15, 10);
	frame.getContentPane().add(panel_144);
	
	Panel panel_145 = new Panel();
	panel_145.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_145.setBackground(Color.BLACK);
	panel_145.setBounds(1528, 75, 15, 10);
	frame.getContentPane().add(panel_145);
	
	Panel panel_146 = new Panel();
	panel_146.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_146.setBackground(Color.BLACK);
	panel_146.setBounds(1543, 75, 15, 10);
	frame.getContentPane().add(panel_146);
	
	Panel panel_147 = new Panel();
	panel_147.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_147.setBackground(Color.BLACK);
	panel_147.setBounds(1558, 75, 15, 10);
	frame.getContentPane().add(panel_147);
	
	Panel panel_148 = new Panel();
	panel_148.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_148.setBackground(Color.BLACK);
	panel_148.setBounds(1573, 75, 15, 10);
	frame.getContentPane().add(panel_148);
	
	Panel panel_149 = new Panel();
	panel_149.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_149.setBackground(Color.BLACK);
	panel_149.setBounds(1588, 75, 15, 10);
	frame.getContentPane().add(panel_149);
	
	Panel panel_150 = new Panel();
	panel_150.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_150.setBackground(Color.BLACK);
	panel_150.setBounds(1603, 75, 15, 10);
	frame.getContentPane().add(panel_150);
	
	Panel panel_151 = new Panel();
	panel_151.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_151.setBackground(Color.BLACK);
	panel_151.setBounds(1618, 75, 15, 10);
	frame.getContentPane().add(panel_151);
	
	Panel panel_152 = new Panel();
	panel_152.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_152.setBackground(Color.BLACK);
	panel_152.setBounds(1633, 75, 15, 10);
	frame.getContentPane().add(panel_152);
	
	Panel panel_153 = new Panel();
	panel_153.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_153.setBackground(Color.BLACK);
	panel_153.setBounds(1648, 75, 15, 10);
	frame.getContentPane().add(panel_153);
	
	Panel panel_154 = new Panel();
	panel_154.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_154.setBackground(Color.BLACK);
	panel_154.setBounds(1663, 75, 15, 10);
	frame.getContentPane().add(panel_154);
	
	Panel panel_155 = new Panel();
	panel_155.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_155.setBackground(Color.BLACK);
	panel_155.setBounds(1678, 75, 15, 10);
	frame.getContentPane().add(panel_155);
	
	Panel panel_156 = new Panel();
	panel_156.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_156.setBackground(Color.BLACK);
	panel_156.setBounds(1303, 91, 15, 10);
	frame.getContentPane().add(panel_156);
	
	Panel panel_157 = new Panel();
	panel_157.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_157.setBackground(Color.BLACK);
	panel_157.setBounds(1318, 91, 15, 10);
	frame.getContentPane().add(panel_157);
	
	Panel panel_158 = new Panel();
	panel_158.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_158.setBackground(Color.BLACK);
	panel_158.setBounds(1333, 91, 15, 10);
	frame.getContentPane().add(panel_158);
	
	Panel panel_159 = new Panel();
	panel_159.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_159.setBackground(Color.BLACK);
	panel_159.setBounds(1348, 91, 15, 10);
	frame.getContentPane().add(panel_159);
	
	Panel panel_160 = new Panel();
	panel_160.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_160.setBackground(Color.BLACK);
	panel_160.setBounds(1363, 91, 15, 10);
	frame.getContentPane().add(panel_160);
	
	Panel panel_161 = new Panel();
	panel_161.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_161.setBackground(Color.BLACK);
	panel_161.setBounds(1378, 91, 15, 10);
	frame.getContentPane().add(panel_161);
	
	Panel panel_162 = new Panel();
	panel_162.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_162.setBackground(Color.BLACK);
	panel_162.setBounds(1393, 91, 15, 10);
	frame.getContentPane().add(panel_162);
	
	Panel panel_163 = new Panel();
	panel_163.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_163.setBackground(Color.BLACK);
	panel_163.setBounds(1408, 91, 15, 10);
	frame.getContentPane().add(panel_163);
	
	Panel panel_164 = new Panel();
	panel_164.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_164.setBackground(Color.BLACK);
	panel_164.setBounds(1423, 91, 15, 10);
	frame.getContentPane().add(panel_164);
	
	Panel panel_165 = new Panel();
	panel_165.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_165.setBackground(Color.BLACK);
	panel_165.setBounds(1438, 91, 15, 10);
	frame.getContentPane().add(panel_165);
	
	Panel panel_166 = new Panel();
	panel_166.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_166.setBackground(Color.BLACK);
	panel_166.setBounds(1453, 91, 15, 10);
	frame.getContentPane().add(panel_166);
	
	Panel panel_167 = new Panel();
	panel_167.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_167.setBackground(Color.BLACK);
	panel_167.setBounds(1468, 91, 15, 10);
	frame.getContentPane().add(panel_167);
	
	Panel panel_168 = new Panel();
	panel_168.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_168.setBackground(Color.BLACK);
	panel_168.setBounds(1483, 91, 15, 10);
	frame.getContentPane().add(panel_168);
	
	Panel panel_169 = new Panel();
	panel_169.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_169.setBackground(Color.BLACK);
	panel_169.setBounds(1498, 91, 15, 10);
	frame.getContentPane().add(panel_169);
	
	Panel panel_170 = new Panel();
	panel_170.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_170.setBackground(Color.BLACK);
	panel_170.setBounds(1513, 91, 15, 10);
	frame.getContentPane().add(panel_170);
	
	Panel panel_171 = new Panel();
	panel_171.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_171.setBackground(Color.BLACK);
	panel_171.setBounds(1528, 91, 15, 10);
	frame.getContentPane().add(panel_171);
	
	Panel panel_172 = new Panel();
	panel_172.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_172.setBackground(Color.BLACK);
	panel_172.setBounds(1543, 91, 15, 10);
	frame.getContentPane().add(panel_172);
	
	Panel panel_173 = new Panel();
	panel_173.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_173.setBackground(Color.BLACK);
	panel_173.setBounds(1558, 91, 15, 10);
	frame.getContentPane().add(panel_173);
	
	Panel panel_174 = new Panel();
	panel_174.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_174.setBackground(Color.BLACK);
	panel_174.setBounds(1573, 91, 15, 10);
	frame.getContentPane().add(panel_174);
	
	Panel panel_175 = new Panel();
	panel_175.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_175.setBackground(Color.BLACK);
	panel_175.setBounds(1588, 91, 15, 10);
	frame.getContentPane().add(panel_175);
	
	Panel panel_176 = new Panel();
	panel_176.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_176.setBackground(Color.BLACK);
	panel_176.setBounds(1603, 91, 15, 10);
	frame.getContentPane().add(panel_176);
	
	Panel panel_177 = new Panel();
	panel_177.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_177.setBackground(Color.BLACK);
	panel_177.setBounds(1618, 91, 15, 10);
	frame.getContentPane().add(panel_177);
	
	Panel panel_178 = new Panel();
	panel_178.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_178.setBackground(Color.BLACK);
	panel_178.setBounds(1633, 91, 15, 10);
	frame.getContentPane().add(panel_178);
	
	Panel panel_179 = new Panel();
	panel_179.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_179.setBackground(Color.BLACK);
	panel_179.setBounds(1648, 91, 15, 10);
	frame.getContentPane().add(panel_179);
	
	Panel panel_180 = new Panel();
	panel_180.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_180.setBackground(Color.BLACK);
	panel_180.setBounds(1663, 91, 15, 10);
	frame.getContentPane().add(panel_180);
	
	Panel panel_181 = new Panel();
	panel_181.setFont(new Font("Dialog", Font.PLAIN, 5));
	panel_181.setBackground(Color.BLACK);
	panel_181.setBounds(1678, 91, 15, 10);
	frame.getContentPane().add(panel_181);
	
	JLabel label_19 = new JLabel("07:30");
	label_19.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_19.setBounds(1303, 53, 15, 16);
	frame.getContentPane().add(label_19);
	
	JLabel label_20 = new JLabel("08:00");
	label_20.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_20.setBounds(1318, 53, 15, 16);
	frame.getContentPane().add(label_20);
	
	JLabel label_21 = new JLabel("08:30");
	label_21.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_21.setBounds(1333, 53, 15, 16);
	frame.getContentPane().add(label_21);
	
	JLabel label_22 = new JLabel("09:00");
	label_22.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_22.setBounds(1348, 53, 15, 16);
	frame.getContentPane().add(label_22);
	
	JLabel label_23 = new JLabel("09:30");
	label_23.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_23.setBounds(1363, 53, 15, 16);
	frame.getContentPane().add(label_23);
	
	JLabel label_24 = new JLabel("10:00");
	label_24.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_24.setBounds(1378, 53, 15, 16);
	frame.getContentPane().add(label_24);
	
	JLabel label_25 = new JLabel("10:30");
	label_25.setFont(new Font("Tahoma", Font.PLAIN, 6));
	label_25.setBounds(1393, 53, 15, 16);
	frame.getContentPane().add(label_25);
	
	
	
	
	
	

	// FunctionsSQL.fillComboBox(txtOffice.getText(), comboBox);

	// JComboBox comboBox = new JComboBox();

    }
}
