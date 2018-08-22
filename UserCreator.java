package Crips;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserCreator {
	// JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	// JOptionPane.showMessageDialog(frame, "Cancer");

	static String dbc = "jdbc:mysql://localhost:3306/transactions";
	static String dbc_user = "root";
	static String dbc_password = "";

	// NEW COMMENT!!

	static String CreateUserQuery = "INSERT INTO test VALUES (default,'%s', '%s','%s','%s','%s')";

	static String SelectAllFromTest = "SELECT * from test";
	static String SelectAllFromOffices = "SELECT * from offices";

	public static Boolean ExistsInDB(String Query, String DataBaseField, String Field) {
		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat.executeQuery(Query);

			while (myRs.next()) {
				if ((myRs.getString(DataBaseField).equals(Field))) {
					return true;
				}
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {

	}

	public static boolean CreateUser(String ID, String Office, String Name, String LastName, String Password) {
		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat.executeQuery(SelectAllFromTest);

			while (myRs.next()) {

				if (ExistsInDB(SelectAllFromTest, "BadgeID", ID) || ID.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Badge ID already exists or is empty! Please try a new Badge ID instead");
					return false;

				} else {

					if (ExistsInDB(SelectAllFromOffices, "ID", Office)) {
						if (myStat.executeUpdate(
								String.format(CreateUserQuery, ID, Office, Name, LastName, Password)) == 1) {
							JOptionPane.showMessageDialog(null,
									"Successfuly Created User '" + Name + LastName + "' (" + ID + ")");
							return true;
						}

						JOptionPane.showMessageDialog(null, "Failed to create new user! Please retry");

						return false;
					} else {
						JOptionPane.showMessageDialog(null, "Office ID doesnt exist!");

						return false;
					}

				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}

}