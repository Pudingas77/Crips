package Crips;

import javax.swing.JOptionPane;

public class Employee {
    static String BadgeID1 = new String();
    static int OfficeID1;
    
    public static void Employe(String BadgeID) {
	BadgeID1 = BadgeID;
	

    }
   static int [] ze = {20,21}; 
   
    public static void Shifts(){
	for(int counter = 0; counter < 2;){
	    OfficeID1=FunctionsSQL.OfficeID(BadgeID1);
	    
	   if(ze[counter]==(OfficeID1)){
	       FunctionsSQL.Shifts(2, OfficeID1);
		
	    }
	    counter++;
	    
	}
	JOptionPane.showMessageDialog(null, "zequita");
	
    }
    

    public static String getBadgeID() {
	return BadgeID1;
    }

    public static int getOfficeID() {
	return OfficeID1;
    }

}
