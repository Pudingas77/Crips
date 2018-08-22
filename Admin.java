package Crips;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Admin extends Employee {
	static String dbc;
	static String dbc_user;
	static String dbc_password = "";
	static String DeleteUserQuery = "DELETE FROM test WHERE  BadgeID='%s';";
	public static void DeleteUser(String BadgeID) {
		// SO PARA ADMINS
		//String ID = userInput("Enter existing user Badge ID: ");

		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

			Statement myStat = myConn.createStatement();

			if (myStat.executeUpdate(String.format(DeleteUserQuery, BadgeID)) == 1) {
				JOptionPane.showMessageDialog(null,"Successfuly Deleted User with Badge ID " + "(" + BadgeID + ")");

			} else {
				JOptionPane.showMessageDialog(null,String.format("Couldnt find user with Badge ID(%s)", BadgeID));
				return;
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	public static String getDbc() {
		return dbc;
	}
	public static void setDbc(String dbc) {
		Admin.dbc = dbc;
	}
	public static String getDbc_user() {
		return dbc_user;
	}
	public static void setDbc_user(String dbc_user) {
		Admin.dbc_user = dbc_user;
	}
	public static String getDbc_password() {
		return dbc_password;
	}
	public static void setDbc_password(String dbc_password) {
		Admin.dbc_password = dbc_password;
	}
	public static String getDeleteUserQuery() {
		return DeleteUserQuery;
	}
	public static void setDeleteUserQuery(String deleteUserQuery) {
		DeleteUserQuery = deleteUserQuery;
	}
	

	
}
