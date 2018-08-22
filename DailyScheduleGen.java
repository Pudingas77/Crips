package Crips;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class DailyScheduleGen {
	static String dbc = "jdbc:mysql://localhost:3306/transactions";
	static String dbc_user = "root";
	static String dbc_password = "";

	static Scanner scanner = new Scanner(System.in);
	static String CreateUserQuery = "CREATE TABLE %s (Date DATE, DayType SMALLINT, EnterHour TIME, ExitHour TIME, LunchBreakStart TIME, LunchBreakEnd TIME);";
	// INSERT INTO schedule2018 (Date, DayType, EnterHour, ExitHour,
	// LunchBreakStart, LunchBreakEnd) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');
	static String DayInsertQuery = "INSERT INTO %s VALUES ('%s', '%s', '%s', '%s', '%s', '%s');";
	static String WeeklySchedule_INSERT = "INSERT INTO weeklyschedules VALUES (default, '%s', '%s', '%s');";

	static String Workday = "INSERT INTO %s  VALUES ('%s', '0', '09:00:00', '17:00:00', '12:00:00', '13:00:00');";
	static String Holyday = "INSERT INTO %s  VALUES ('%s', '1', '00:00:00', '00:00:00', '00:00:00', '00:00:00');";
	static String ExtraWorkday = "INSERT INTO %s  VALUES ('%s', '2', '%s', '%s', '00:00:00', '00:00:00');";

	//////////////////////////////////////////
	// Day Types /////////////////////////////
	//////////////////////////////////////////
	// Workday: 0 ////////////////////////////
	// Holyday: 1 ////////////////////////////
	// Extra-Work: 2 /////////////////////////
	//////////////////////////////////////////
	
	static Connection myConn;
	static Statement myStat;

	public static void main(String[] args) {
		// String[] Name = userInput("Enter new user First and Last name: ").split(" ");
		// String ScheduleName = userInput("Enter schedule name: ");
		//Calendar tc;
		// OfficeImport();
		// AddNewSchedule();
		//DBReformat();


		try {
			myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
			myStat = myConn.createStatement();
			
			ResultSet myRs = myStat.executeQuery(String.format("SELECT * FROM weeklyschedules WHERE ID = %s;", 1));
			
			String LV = null;
			
			while (myRs.next()) {
				LV = myRs.getString("LV");
				String[] LV_Split = LV.split("-");
				
				AssignToCalendar(LV_Split[0], "Entering Time in Weekdays is %s");
				AssignToCalendar(LV_Split[1], "Exit Time in Weekdays is %s");
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void BackupFunc() {
		String days = userInput(String.format("Please insert %s(%s) Holydays:", MonthName(0), 0));
		String[] holydays = days.split(",");

		int Month = 0;
		String DB = "schedule2018";

		try {
			int[] holydaysInt = ConvertStringList(holydays);

			for (int i = 1; i <= MonthLastDay(Month); i++) {
				String MonthDateLocal = ReturnDate(Month, i);

				for (int hd : holydaysInt) {
					if (i == hd) {
						try {
							myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
							myStat = myConn.createStatement();

							if (myStat.executeUpdate(String.format(Holyday, DB, MonthDateLocal)) == 1) {
								println(String.format("Day %s is a Holyday", MonthDateLocal));
							}

						} catch (Exception exc) {
							exc.printStackTrace();
						}

						i++;
					}
				}
				try {
					myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
					myStat = myConn.createStatement();

					if (myStat.executeUpdate(String.format(Workday, DB, MonthDateLocal)) == 1) {
						println(String.format("Day %s is a Workday", MonthDateLocal));
					}

				} catch (Exception exc) {
					exc.printStackTrace();
				}

				// println(String.format("Day %s is a Workday", i));
			}
		} catch (java.lang.NumberFormatException exc) {
			println("Please type the days in a sequencial manner. Ex(1,5,10,30)");
		}

		userInput("By order of the Jarl stop right there!");
		// println(String.format("This months last day is %s", MonthLastDay(i)));

		// System.out.println("Today : " + sdf.format(today));
		// System.out.println("Last Day of Month: " + );

	}

	public static String ReturnTimeFormatted(String Time) {
		return Time.concat(":00");
	}
	
	public static void AssignToCalendar (String Time, String Text) {
		Calendar c = GregorianCalendar.getInstance();
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(Time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.setTime(date);
		//c.set(Calendar.MONTH, 0);
		//c.set(Calendar.DATE, 12);
				
		
		println("Time " + Time);
		
		String[] SplitTime = Time.split(":");

		//c.set(Calendar.SECOND, Integer.parseInt(SplitTime[2]));
		//println("Seconds " + Integer.parseInt(SplitTime[2]));
        //c.set(Calendar.MINUTE, Integer.parseInt(SplitTime[1]));
        //println("Minutes " + Integer.parseInt(SplitTime[1]));
        //c.set(Calendar.HOUR, Integer.parseInt(SplitTime[0]));
        //println("Hours " + Integer.parseInt(SplitTime[0]));
        
        
        println(String.format(Text, c.getTime()));
	}
	
	public static void DBReformat() {
		int RowCount = 0;
		try {
			myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
			myStat = myConn.createStatement();
			
			ResultSet myRs = myStat.executeQuery("SELECT * FROM weeklyschedules");
			while (myRs.next())
			{
				RowCount++;
			}
			RowCount++;

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		try {
			for (int i = 0; i <= RowCount; i++)
			{
				myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
				myStat = myConn.createStatement();
				
				ResultSet myRs1 = myStat.executeQuery(String.format("SELECT * FROM weeklyschedules WHERE ID = %s;", i));
				
				String LV = null;
				String S = null;
				String D = null;
				
				while (myRs1.next()) {
					LV = myRs1.getString("LV");
					String[] LV_Split = LV.split("-");
					
					LV_Split[0] = ReturnTimeFormatted(LV_Split[0]);
					LV_Split[1] = ReturnTimeFormatted(LV_Split[1]);
					LV = LV_Split[0] + "-" + LV_Split[1];
					
					S = myRs1.getString("S");
					String[] S_Split = S.split("-");
					
					S_Split[0] = ReturnTimeFormatted(S_Split[0]);
					S_Split[1] = ReturnTimeFormatted(S_Split[1]);
					S = S_Split[0] + "-" + S_Split[1];
					
					D = myRs1.getString("D");
					String[] D_Split = D.split("-");
					
					D_Split[0] = ReturnTimeFormatted(D_Split[0]);
					D_Split[1] = ReturnTimeFormatted(D_Split[1]);
					D = D_Split[0] + "-" + D_Split[1];
				}
				myStat.executeUpdate(String.format("UPDATE weeklyschedules SET LV = '%s', S = '%s', D = '%s' WHERE ID = %s;", LV, S, D, i));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void AddNewSchedule() {
		String[] LVSD = userInput("Insert Schedule").split(","); // LS = Segunda a Sexta // S = Sabado // D = Domingo

		try {
			myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
			myStat = myConn.createStatement();

			if (myStat.executeUpdate(String.format(WeeklySchedule_INSERT, LVSD[0], LVSD[1], LVSD[2])) == 1) {
				println(String.format("Successfuly Imported New Weekly Schedule"));
			}

			println(LVSD[0] + LVSD[1] + LVSD[2]);

		} catch (Exception exc) {
			exc.printStackTrace();
		}

		AddNewSchedule();
	}

	public static void OfficeImport() {
		// THIS FUNCTION DOESNT CHECK EXISTANCE
		String Offices = userInput(
				"Insert Single Office or Office List (using ',' separator, ex: 'Office 1,Office 2,Office 3'");
		String[] OfficeList = Offices.split(",");

		try {
			myConn = DriverManager.getConnection(dbc, dbc_user, dbc_password);
			myStat = myConn.createStatement();

			for (int i = 0; i < OfficeList.length; i++) {
				if (myStat.executeUpdate(
						String.format("INSERT INTO offices VALUES (default, '%s');", OfficeList[i])) == 1) {
					println(String.format("Successfuly Imported '%s'", OfficeList[i]));
				}
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static int[] ConvertStringList(String[] StringList) {
		int[] List = new int[StringList.length];
		for (int i = 0; i < StringList.length; i++) {
			List[i] = Integer.parseInt(StringList[i]);
			;
		}
		return List;
	}

	public static int MonthLastDay(int Month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, Month);
		// println(String.format("Month %s(%s) maxDay(%s)", c.getTime(), Month,
		// c.getActualMaximum(Calendar.DATE)));
		return c.getActualMaximum(Calendar.DATE);
	}

	public static String ReturnDate(int Month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, Month);
		c.set(Calendar.DATE, day);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Time = sdf.format(c.getTime());
		return Time;
	}

	static String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	public static String MonthName(int month) {
		return monthNames[month];
	}

	public static String userInput(String statement) {
		System.out.println(statement);
		return scanner.nextLine();
	}

	public static void println(String line) {
		System.out.println(line);
	}
}
