package Crips;

public class Employee {
    static String BadgeID1 = new String();
    static String OfficeID1 = new String();;
    
    public static void Employe(String BadgeID, String OfficeID) {
	BadgeID1 = BadgeID;
	OfficeID1 = OfficeID;

    }
    

    public static String getBadgeID() {
	return BadgeID1;
    }

    public static String getOfficeID() {
	return OfficeID1;
    }

}
