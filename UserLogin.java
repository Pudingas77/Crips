package please;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserLogin {
	
	// New Push 09:34
	
	static String dbc = "jdbc:mysql://localhost:3306/transactions";
	static String dbc_user = "root";
	static String dbc_password = "";
	static String office = new String();
	static Scanner scanner = new Scanner(System.in);
	static boolean BadgeIDcorrect;

	public static void main(String BadgeID, String Password) {
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
					if ((myRs.getString("Passwords")).equals(Password)) {
						JOptionPane.showMessageDialog(null, "Succefully Logged In");
						JOptionPane.showMessageDialog(null,
								"Your name is " + myRs.getString("Name") + " " + myRs.getString("LastName"));
						office = myRs.getString("Office");
						JOptionPane.showMessageDialog(null,
								"Your working office is: " + office + " Your colleagues are: ");

						BadgeIDcorrect = true;
					} else {
						JOptionPane.showMessageDialog(null, "Wrong password please try again");
						BadgeIDcorrect = true;
						return;
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

			if (BadgeIDcorrect = false) {
				JOptionPane.showMessageDialog(null, "That BadgeID doesn't exist, Please register First");
				return;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public static String userInput(String statement) {
		System.out.println(statement);
		return scanner.nextLine();
	}

	public static void println(String line) {
		System.out.println(line);
	}
}
