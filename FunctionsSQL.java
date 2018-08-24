package Crips;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class FunctionsSQL {
    static String dbc = "jdbc:mysql://localhost:3306/transactions";
    static String dbc_user = "root";
    static String dbc_password = "";
    static String DeleteUserQuery = "DELETE FROM test WHERE  BadgeID ='%s';";
    static String CreateUserQuery = "INSERT INTO test VALUES (default,'%s', '%s','%s','%s','%s')";
    static String SelectAllFromTest = "SELECT * from test";
    static String RegisterOfficeQuery = "INSERT INTO offices VALUES (default,'%s')";
    static String DeleteOfficeQuery = "DELETE FROM offices WHERE  Code ='%s';";
    static String VacationRequestQuery = "INSERT INTO vacationmessagestore VALUES ('%s', '%s')";
    static String SelectAllFromRequest = "Select * from vacationmessagestore";
    // static String ModifyUserQuery = "UPDATE `transactions`.`test` SET `%s` =
    // '%s', WHERE `test`.`BadgeID` =`%s`;'";
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
			office = myRs.getString("OfficeID");

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

		if (myRs2.getString("OfficeID").equals(office)) {

		    JOptionPane.showMessageDialog(null,
			    (myRs2.getString("Name") + " " + (myRs2.getString("LastName"))));

		}
	    }

	    if (BadgeIDcorrect == false) {
		JOptionPane.showMessageDialog(null, "BadgeID or Password Incorrect", "Login Error",
			JOptionPane.ERROR_MESSAGE);
		return false;
	    }
	    myConn.close();
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

    // Modifyierrrrr
    public static void Modify(String BadgeID, String Name, String LastName, String OfficeID) {

	try {
	    String query = "Update test set  Name='" + Name + "',Lastname='" + LastName + "', OfficeID='" + OfficeID
		    + "' where BadgeID = '" + BadgeID + "' ";
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
	    Statement myStat = myConn.createStatement();
	    ResultSet myRs = myStat.executeQuery(SelectAllFromTest);
	    while (myRs.next()) {
		if (myRs.getString("BadgeID").equals(BadgeID)) {
		    myStat.execute(query);
		    JOptionPane.showMessageDialog(null, "Update Succesfull");
		    myConn.close();
		}
	    }

	} catch (Exception exc) {
	    exc.printStackTrace();
	}

    }

    public static void NewPassword(String BadgeID, String Password, String Password1) {

	try {
	    String query = "Update test set  Password='" + Password + "' where BadgeID = '" + BadgeID + "' ";
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
	    Statement myStat = myConn.createStatement();
	    ResultSet myRs = myStat.executeQuery(SelectAllFromTest);
	    while (myRs.next()) {
		if (Password == Password1) {
		    if (myRs.getString("BadgeID").equals(BadgeID)) {
			myStat.execute(query);
			JOptionPane.showMessageDialog(null, "Update Succesfull");
			myConn.close();
			return;
		    }
		}
	    }
	    JOptionPane.showMessageDialog(null, "BadgeID not Found!");
	} catch (Exception exc) {
	    exc.printStackTrace();
	}

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

		    if (ExistsInDB(SelectAllFromOffices, "Code", Office) || Office.isEmpty()) {
			if (myStat.executeUpdate(
				String.format(CreateUserQuery, ID, Office, Name, LastName, Password)) == 1) {
			    JOptionPane.showMessageDialog(null,
				    "Successfuly Created User '" + Name + " " + LastName + "' (" + ID + ")");
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

    public static void EmployersData(JTable table) {

	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

	    Statement myStat = myConn.createStatement();
	    String query = "Select BadgeID, OfficeID, Name, LastName from test";
	    PreparedStatement pst = myConn.prepareStatement(query);
	    ResultSet rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception exc) {
	    exc.printStackTrace();
	}

    }

    // Office Register
    public static boolean RegisterOffice(String Office) {
	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
	    Statement myStat = myConn.createStatement();
	    ResultSet myRs = myStat.executeQuery(SelectAllFromTest);

	    while (myRs.next()) {

		if (ExistsInDB(SelectAllFromOffices, "Name Office", Office) || Office.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "That Office already exists in DB! or is empty");
		    return false;

		} else {

		    if (myStat.executeUpdate(String.format(RegisterOfficeQuery, Office)) == 1) {
			JOptionPane.showMessageDialog(null, "New Office Created with the name" + Office);
			return true;
		    }

		    JOptionPane.showMessageDialog(null, "Failed to create new Office! Please retry");

		    return false;

		}
	    }
	} catch (Exception exc) {
	    exc.printStackTrace();
	}
	return false;
    }

    public static void DeleteOffice(String OfficeID) {

	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

	    Statement myStat = myConn.createStatement();
	    System.out.println((String.format(DeleteOfficeQuery, OfficeID)));
	    if (myStat.executeUpdate(String.format(DeleteOfficeQuery, OfficeID)) == 1) {
		JOptionPane.showMessageDialog(null, "Successfuly Deleted Office with Office ID " + OfficeID);

	    } else {
		JOptionPane.showMessageDialog(null, String.format("Couldnt find Office with OfficeID(%s)", OfficeID));
		return;
	    }

	} catch (Exception exc) {
	    exc.printStackTrace();
	}

    }

    // See stored MessagesVacation!
    public static void MessageStore(JTable table) {

	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

	    Statement myStat = myConn.createStatement();
	    String query = "SELECT * from `vacationmessagestore`";
	    PreparedStatement pst = myConn.prepareStatement(query);
	    ResultSet rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception exc) {
	    exc.printStackTrace();
	}

    }

    // Request Vacation BETA!!!! MEGA BETA!
    public static void RequestVacation(String BadgeID, String Message) {
	// BadgeID = Employee.getBadgeID();
	try {
	    Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
	    Statement myStat = myConn.createStatement();
	    ResultSet myRs = myStat.executeQuery(SelectAllFromTest);

	    while (myRs.next()) {

		if (ExistsInDB(SelectAllFromRequest, "BadgeID", BadgeID) || BadgeID.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "You Already Requested Vacation wait for HeadOffice Aprovval");
		    return;

		} else {

		    // Insert If To check if vacation days are valid;
		    if (myStat.executeUpdate(String.format(VacationRequestQuery, BadgeID)) == 1)
			JOptionPane.showMessageDialog(null,
				"Request sent wait for HeadOffice for Aprovval" + "\n" + "Message");

		}

		JOptionPane.showMessageDialog(null, "Failed to create new user! Please retry");

	    }

	} catch (Exception exc) {
	    exc.printStackTrace();
	}
    }

    // Auxiliar Functions
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
