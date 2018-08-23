package Crips;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FunctionsSQL {
    static String dbc = "jdbc:mysql://localhost:3306/transactions";
    static String dbc_user = "root";
    static String dbc_password = "";
    static String DeleteUserQuery = "DELETE FROM test WHERE  BadgeID ='%s';";
    static String CreateUserQuery = "INSERT INTO test VALUES (default,'%s', '%s','%s','%s','%s')";
    static String SelectAllFromTest = "SELECT * from test";
//    static String ModifyUserQuery = "UPDATE `transactions`.`test` SET `%s` = '%s', WHERE `test`.`BadgeID` =`%s`;'";
    static String SelectAllFromOffices = "SELECT * from offices";
    static String office;

    // ADMINS ONLY
    // ADMIN DELETER
    public static void DeleteUser(String BadgeID) {

	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

	    Statement myStat = myConn.createStatement();
	    System.out.println((String.format(DeleteUserQuery, BadgeID)));
	    if (myStat.executeUpdate(String.format(DeleteUserQuery, BadgeID)) == 1) {
		JOptionPane.showMessageDialog(null, "Successfuly Deleted User with Badge ID " + "(" + BadgeID + ")");

	    } else {
		JOptionPane.showMessageDialog(null, String.format("Couldnt find user with Badge ID(%s)", BadgeID));
		return;
	    }

	} catch (Exception exc) {
	    exc.printStackTrace();
	}

    }

    // USER LOGIN
    public static boolean UserLogin(String BadgeID, String Password) {
	boolean BadgeIDcorrect = false;

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

			if (!FunctionsSQL.IsAdmin()) {
			    JOptionPane.showMessageDialog(null, "Your working office is:  " + office);
			    JOptionPane.showMessageDialog(null, "People in this office are: ");

			}

		    } else {
			JOptionPane.showMessageDialog(null, "BadgeID or Password Incorrect", "Login Error",
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
		JOptionPane.showMessageDialog(null, "BadgeID or Password Incorrect", "Login Error",
			JOptionPane.ERROR_MESSAGE);
		return false;
	    }
	} catch (Exception exc) {
	    exc.printStackTrace();
	}
	return true;

    }

    // DATABASE EXIST CHECKER
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
//MODIFYYYYYYYYYYYYYYYY
    public static void ModifyUser(String BadgeID, String WhatToModify, String Modified) {
	    String ModifyUserQuery = "update users set num_points = ? where first_name = ?";
	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
	    Statement myStat = myConn.prepareStatement("Update test SET Office = ? WHERE BadgeID = ?");
	    ResultSet myRs = myStat.executeQuery(SelectAllFromTest);
	   
	   

	    if (ExistsInDB(SelectAllFromTest, "BadgeID", BadgeID)) {
		JOptionPane.showMessageDialog(null, "Corrects");
		if(myStat.executeUpdate(String.format(ModifyUserQuery,BadgeID, WhatToModify, Modified ))==1);
		JOptionPane.showMessageDialog(null, "Corrects");
		myStat.executeUpdate(String.format(ModifyUserQuery,BadgeID, WhatToModify, Modified));
		JOptionPane.showMessageDialog(null, "Vai DB");
		return;
	    }
	}

	catch (Exception exc) {
	    exc.printStackTrace();
	}

	return;

    }

    // Register
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

		    if (ExistsInDB(SelectAllFromOffices, "ID", Office) || Office.isEmpty()) {
			if (myStat.executeUpdate(String.format(CreateUserQuery, ID, Office, Name, LastName, Password)) == 1) {
			    JOptionPane.showMessageDialog(null,
				    "Successfuly Created User '" + Name + LastName + "' (" + ID + ")");
			    return true;
			}

			JOptionPane.showMessageDialog(null, "Failed to create new user! Please retry");

			return false;
		    } else {
			JOptionPane.showMessageDialog(null, "Office ID doesnt exist! or is empty!");

			return false;
		    }

		}
	    }
	} catch (Exception exc) {
	    exc.printStackTrace();
	}
	return false;
    }

    // Auxiliar Function
    public static boolean IsAdmin() {
	if (office.equals(Admin.AdminOffice)) {
	    return true;
	}
	return false;

    }

    public static String getDbc() {
	return dbc;
    }

    public static String getDbc_user() {
	return dbc_user;
    }

    public static String getDbc_password() {
	return dbc_password;
    }

}
