package Crips;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DailyScheduleGen {
	static String dbc = "jdbc:mysql://localhost:3306/transactions";
	static String dbc_user = "root";
	static String dbc_password = "";
	

	static Scanner scanner = new Scanner(System.in);
	static String CreateUserQuery = "CREATE TABLE %s (Date DATE, DayType SMALLINT, EnterHour TIME, ExitHour TIME, LunchBreakStart TIME, LunchBreakEnd TIME);";
	//INSERT INTO schedule2018 (Date, DayType, EnterHour, ExitHour, LunchBreakStart, LunchBreakEnd) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');
	static String DayInsertQuery = "INSERT INTO %s VALUES ('%s', '%s', '%s', '%s', '%s', '%s');";
	
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
		//String[] Name = userInput("Enter new user First and Last name: ").split(" ");
		//String ScheduleName = userInput("Enter schedule name: ");
		Calendar tc; 
		
		String days = userInput(String.format("Please insert %s(%s) Holydays:", MonthName(0), 0));
		String[] holydays = days.split(",");
		
		int Month =  0;
		String DB = "schedule2018";
		
		try {
			int[] holydaysInt = ConvertStringList(holydays);
			
			for (int i = 1; i <= MonthLastDay(Month); i++)
			{
				String MonthDateLocal = ReturnDate(Month, i);
				
				for (int hd : holydaysInt)
				{
					if (i == hd)
					{
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
				
				//println(String.format("Day %s is a Workday", i));
			}
		}
		catch (java.lang.NumberFormatException exc)
		{
			println("Please type the days in a sequencial manner. Ex(1,5,10,30)");
		}
		
		String Halt = userInput("By order of the Jarl stop right there!");
		//println(String.format("This months last day is %s", MonthLastDay(i)));
        
        //System.out.println("Today            : " + sdf.format(today));  
        //System.out.println("Last Day of Month: " + ); 
		
		
	}
	public static int[] ConvertStringList(String[] StringList) {
		int[] List = new int[StringList.length];
		for (int i = 0; i < StringList.length; i++)
		{
			List[i] = Integer.parseInt(StringList[i]);;
		}
		return List;
	}
	public static int MonthLastDay(int Month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, Month);
		//println(String.format("Month %s(%s) maxDay(%s)", c.getTime(), Month, c.getActualMaximum(Calendar.DATE)));
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
	
	static String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static String MonthName (int month)
	{
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
