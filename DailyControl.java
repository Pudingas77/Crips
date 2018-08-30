package Crips;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DailyControl {
	static Scanner scanner = new Scanner(System.in);
	static String dbc = "jdbc:mysql://localhost:3306/transactions";
	static String dbc_user = "root";
	static String dbc_password = "";
	static String UserDBName = "test";

	public static Employee CurrentEmployee;

	public static void GetEmployeeInfo(String BadgeID) {
		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat
					.executeQuery(String.format("SELECT * FROM %s WHERE BadgeID = '%s';", UserDBName, BadgeID));

			while (myRs.next()) {
				if (FunctionsSQL.ExistsInDB(FunctionsSQL.SelectAllFromTest, "BadgeID", BadgeID) || BadgeID.isEmpty()) {
					CurrentEmployee.setBadgeID(myRs.getString("BadgeID"));
					CurrentEmployee.setOID(myRs.getInt("OfficeID"));
					CurrentEmployee.setLastName(myRs.getString("LastName"));
					CurrentEmployee.setName(myRs.getString("Name"));
					CurrentEmployee.setPassword(myRs.getString("Passwords"));

					CurrentEmployee.setM_HD(myRs.getInt("Month_HoursDone"));
					CurrentEmployee.setM_TD(myRs.getInt("Month_ToDoHours"));
					CurrentEmployee.setL_HD(myRs.getInt("LastMonth_HoursDone"));
					CurrentEmployee.setL_TD(myRs.getInt("LastMonth_ToDoHours"));
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void AddEmployeeHours(String BadgeID, int hoursToAdd) {
		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

			Statement myStat = myConn.createStatement();

			if (FunctionsSQL.ExistsInDB(FunctionsSQL.SelectAllFromTest, "BadgeID", BadgeID) || !BadgeID.isEmpty()) {
				ResultSet myRs = myStat
						.executeQuery(String.format("SELECT * FROM %s WHERE BadgeID = '%s';", UserDBName, BadgeID));

				int hoursDone = 0;
				int monthhoursdone = 0;

				while (myRs.next()) {
					monthhoursdone = myRs.getInt("Month_HoursDone");
				}

				hoursDone = monthhoursdone + hoursToAdd;

				if (myStat.executeUpdate(String.format("UPDATE %s SET Month_HoursDone = %s WHERE BadgeID = '%s';",
						UserDBName, hoursDone, BadgeID)) == 1) {
					println(String.format("Employee with BadgeID '%s' had '%s' hours done, now has '%s' (Added %s)",
							BadgeID, monthhoursdone, hoursDone, hoursToAdd));
				} else {
					println("Failed to AddEmployeeHours!");
				}
			} else {
				println(String.format("Employee with the BadgeID '%s' doesnt exist or is empty!", BadgeID));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void RemoveEmployeeHours(String BadgeID, int hoursToRemove) {
		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

			Statement myStat = myConn.createStatement();

			if (FunctionsSQL.ExistsInDB(FunctionsSQL.SelectAllFromTest, "BadgeID", BadgeID) || !BadgeID.isEmpty()) {
				ResultSet myRs = myStat
						.executeQuery(String.format("SELECT * FROM %s WHERE BadgeID = '%s';", UserDBName, BadgeID));

				int hoursDone = 0;
				int monthhoursdone = 0;

				while (myRs.next()) {
					monthhoursdone = myRs.getInt("Month_HoursDone");
				}

				hoursDone = monthhoursdone - hoursToRemove;

				if (myStat.executeUpdate(String.format("UPDATE %s SET Month_HoursDone = %s WHERE BadgeID = '%s';",
						UserDBName, hoursDone, BadgeID)) == 1) {
					println(String.format("Employee with BadgeID '%s' had '%s' hours done, now has '%s' (Removed %s)",
							BadgeID, monthhoursdone, hoursDone, hoursToRemove));
				} else {
					println("Failed to RemoveEmployeeHours!");
				}
			} else {
				println(String.format("Employee with the BadgeID '%s' doesnt exist or is empty!", BadgeID));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static Boolean EmployeeHasHoursDiff(String BadgeID, int hourDiff) {
		try {
			Connection myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);

			Statement myStat = myConn.createStatement();

			if (FunctionsSQL.ExistsInDB(FunctionsSQL.SelectAllFromTest, "BadgeID", BadgeID) || !BadgeID.isEmpty()) {
				ResultSet myRs = myStat
						.executeQuery(String.format("SELECT * FROM %s WHERE BadgeID = '%s';", UserDBName, BadgeID));

				int hoursDone = 0;

				int monthhoursdone = 0;
				int monthhourstodo = 0;

				while (myRs.next()) {
					monthhoursdone = myRs.getInt("Month_HoursDone");
					monthhourstodo = myRs.getInt("Month_HoursToDo");
				}

				if (monthhourstodo - monthhoursdone >= hourDiff) {
					// Hasnt met the objective yet.. can be used in the end month check to see if he
					// hasnt worked enough
					// either way, returns true if he has a hour differential
					return true;
				} else {
					return false;
				}
			} else {
				println(String.format("Employee with the BadgeID '%s' doesnt exist or is empty!", BadgeID));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return null;
	}

	public static String userInput(String statement) {
		System.out.println(statement);
		return scanner.nextLine();
	}

	public static void println(String line) {
		System.out.println(line);
	}
}
