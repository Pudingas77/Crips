package Crips;

public class Employee {
	static String BadgeID = UserLogin.getA();
	static String OfficeID;
	public void setBadgeID(String badgeID) {
	    BadgeID = badgeID;
	}
	public static String getBadgeID() {
	    return BadgeID;
	}

	
}
