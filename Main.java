package Crips;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	Login_System.main();
	}

	public static String userInput(String statement) {
		System.out.println(statement);
		return scanner.nextLine();
	}
}
