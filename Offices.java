package Crips;

import java.util.Date;

public class Offices {
    private static final boolean NoOverlapThursday = false;
    private static final boolean NoOverlapWednesday = false;

    public Offices(int OfficeID, int NumberTill) {
	int type = FunctionsSQL.OfficeCount(OfficeID);
	if (type == 1) {
	    // Only one worker
	    if (NumberTill == 1) {

	    } else {
		System.out.println("You can not have more then 1 Till in a office that only has one employee");
	    }
	} else if (type == 2) {
	    // 2 workers
	    if (NumberTill == 1) {
		System.out.println("Please choose what type of schedule you want to implement.");
		System.out.println("\n" + "No Overlap with ThursdayOff or No Overlap with WednesdayOff");
		if (NoOverlapThursday == true) {
		    System.out.println("You choose the No Overlap Thursday" + "\n"
			    + "Please insert number of entering hour for first employee");
		   
		}
		if (NoOverlapWednesday == true) {

		}
	    }

	} else if (type == 3) {
	    // 3 workers
	}

    }
}
