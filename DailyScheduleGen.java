package Crips;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;
import java.util.Scanner;
 // És o rei ja derreti o cerebro
public class DailyScheduleGen {
	static String dbc = "jdbc:mysql://localhost:3306/transactions";
	static String dbc_user = "root";
	static String dbc_password = "";
	static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	static Scanner scanner = new Scanner(System.in);
	static String CreateUserQuery = "CREATE TABLE %s (Date DATE, DayType SMALLINT, EnterHour TIME, ExitHour TIME, LunchBreakStart TIME, LunchBreakEnd TIME);";

	public static void main(String[] args) {
		//String[] Name = userInput("Enter new user First and Last name: ").split(" ");
		//String ScheduleName = userInput("Enter schedule name: ");
		Calendar tc; 
		//MonthLastDay(4);
		
		String days = userInput(String.format("Please insert %s(%s) Holydays:", MonthName(0), 0));
		String[] holydays = days.split(",");
		
		try {
			int[] holydaysInt = ConvertStringList(holydays);
			
			for (int i = 1; i <= MonthLastDay(0); i++)
			{
				for (int hd : holydaysInt)
				{
					if (i == hd)
					{
						println(String.format("Day %s is a 		Holyday", i));
						i++;
					}
				}
				println(String.format("Day %s is a Workday", i));
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
