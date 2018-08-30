package Crips;

import javax.swing.JOptionPane;

public class Employee {
	// static String BadgeID1 = new String();
	// static int OfficeID1;

	static String BID = new String(); // Badge ID
	static int OID; // Office ID
	static String Name;
	static String LastName;
	static String Password;

	public static void setOID(int oID) {
		OID = oID;
	}

	public static void setName(String name) {
		Name = name;
	}

	public static void setLastName(String lastName) {
		LastName = lastName;
	}

	public static void setPassword(String password) {
		Password = password;
	}

	public static void setM_HD(int m_HD) {
		M_HD = m_HD;
	}

	public static void setM_TD(int m_TD) {
		M_TD = m_TD;
	}

	public static void setL_HD(int l_HD) {
		L_HD = l_HD;
	}

	public static void setL_TD(int l_TD) {
		L_TD = l_TD;
	}

	public static void setZe(int[] ze) {
		Employee.ze = ze;
	}

	public static String getBID() {
		return BID;
	}

	public static int getOID() {
		return OID;
	}

	public static String getName() {
		return Name;
	}

	public static String getLastName() {
		return LastName;
	}

	public static String getPassword() {
		return Password;
	}

	public static int getM_HD() {
		return M_HD;
	}

	public static int getM_TD() {
		return M_TD;
	}

	public static int getL_HD() {
		return L_HD;
	}

	public static int getL_TD() {
		return L_TD;
	}

	public static int[] getZe() {
		return ze;
	}

	static int M_HD;
	static int M_TD;
	static int L_HD;
	static int L_TD;

	public void Employe(String BadgeID) {
		BID = BadgeID;
	}

	static int[] ze = { 20, 21 };

	public static void Shifts() {
		for (int counter = 0; counter < 2;) {
			OID = FunctionsSQL.OfficeID(BID);

			if (ze[counter] == (OID)) {
				FunctionsSQL.Shifts(2, OID);

			}
			counter++;

		}
		JOptionPane.showMessageDialog(null, "zequita");

	}

	public static void setBadgeID(String badgeID) {
		BID = badgeID;
	}
	
	public static String getBadgeID() {
		return BID;
	}

	public static int getOfficeID() {
		return OID;
	}

}
