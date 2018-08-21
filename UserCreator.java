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

	static Scanner scanner = new Scanner(System.in);
	static String CreateUserQuery = "INSERT INTO test VALUES (default,'%s', '%s','%s','%s','%s')";
	static String DeleteUserQuery = "DELETE FROM test WHERE  BadgeID='%s';";
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

	

	public static void DeleteUser() {
		//SO PARA ADMINS
		String ID = userInput("Enter existing user Badge ID: ");

		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

			Statement myStat = myConn.createStatement();

			if (myStat.executeUpdate(String.format(DeleteUserQuery, ID)) == 1) {
				println("Successfuly Deleted User with Badge ID " + "(" + ID + ")");
				
			} else {
				println(String.format("Couldnt find user with Badge ID(%s)", ID));
				DeleteUser();
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static boolean CreateUser(String ID, String Office, String Name, String Password) {
		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat.executeQuery(SelectAllFromTest);

			while (myRs.next()) {

				if (ID == "" || ExistsInDB(SelectAllFromTest, "BadgeID", ID)) {
					JOptionPane.showMessageDialog(null, "Badge ID already exists or is null! Please try a new Badge ID instead");
					return false;

				} else {

					if (ExistsInDB(SelectAllFromOffices, "ID", Office)) {

						if (myStat
								.executeUpdate(String.format(CreateUserQuery, ID, Office, Name, " ", Password)) == 1) {
							JOptionPane.showMessageDialog(null, "Successfuly Created User '" + Name + "' (" + ID + ")");
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

	public static String userInput(String statement) {
		System.out.println(statement);
		return scanner.nextLine();
	}

	public static void println(String line) {
		System.out.println(line);
	}
}