package Crips;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserLogin {

    // New Push 09:34

    static String dbc = Admin.getDbc();
    static String dbc_user = "root";
    static String dbc_password = "";
    static String office = new String();
    static String AdminOffice = "97";
    static Scanner scanner = new Scanner(System.in);
    static boolean BadgeIDcorrect = false;
    static String a;

    public static boolean UserLogin(String BadgeID, String Password) {
	a=BadgeID;
	/*
	 * String Username1 = userInput("Enter your Username: "); String
	 * Password = userInput("Enter your Password: ");
	 */

	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

	    Statement myStat = myConn.createStatement();

	    ResultSet myRs = myStat.executeQuery("select * from test");
	    while (myRs.next()) {
		if ((myRs.getString("BadgeID")).equals(BadgeID)) {
		    BadgeIDcorrect = true;

		    if ((myRs.getString("Passwords")).equals(Password)) {

			JOptionPane.showMessageDialog(null, "Succefully Logged In");
			JOptionPane.showMessageDialog(null,
				"Your name is " + myRs.getString("Name") + " " + myRs.getString("LastName"));
			office = myRs.getString("Office");
			

			if (!IsAdmin()) {
			    JOptionPane.showMessageDialog(null,
				    "Your working office is:  " + office + " Your colleagues are: ");

			}
			return true;
		    } else {
			JOptionPane.showMessageDialog(null, "Wrong password please try again", "Login Error",
				JOptionPane.ERROR_MESSAGE);

			return false;
		    }

		}

	    }
	    ResultSet myRs2 = myStat.executeQuery("select * from test");
	    while (myRs2.next()) {
		if (myRs2.getString("Office").equals(office)) {

		    JOptionPane.showMessageDialog(null,
			    (myRs2.getString("Name") + " " + (myRs2.getString("LastName"))));

		}
	    }

	    if (BadgeIDcorrect == false) {
		JOptionPane.showMessageDialog(null, "That BadgeID doesn't exist, Please register First");
		return false;
	    }
	} catch (Exception exc) {
	    exc.printStackTrace();
	}

	return false;

    }

    public static String getA() {
        return a;
    }

    public static boolean IsAdmin() {
	if (office.equals(AdminOffice)) {
	    return true;
	}
	return false;

    }

    public static String userInput(String statement) {
	System.out.println(statement);
	return scanner.nextLine();
    }
    

    public static void println(String line) {
	System.out.println(line);
    }
}
