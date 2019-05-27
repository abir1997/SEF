package system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {

	public static int readPositiveInt(Scanner userInput) {
		boolean success = false;
		int intNum = -1;
		while (!success)
			try {
				intNum = userInput.nextInt();
				if (intNum >= 0)
					success = true;
				else {
					success = false;
					System.out.println("Invalid positive Integer, please try again");
				}
			} catch (Exception e) {
				System.out.println("Invalid positive Integer, please try again");
			} finally {
				userInput.nextLine();
			}

		return intNum;
	}

	public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static LocalDate readDate(Scanner userInput) {
		boolean success = false;
		LocalDate localDate = null;
		while (!success)
			try {
				String dateStr = userInput.nextLine();
				localDate = LocalDate.parse(dateStr, DATE_FORMATTER); 
				success = true;
			} catch (Exception e) {
				System.out.println("Invalid Date Entered, needs to follow the following format: dd-MM-yyyy");
			} 

		return localDate;
	}

	public static double readPositiveDouble(Scanner userInput) {
		boolean success = false;
		double doubleNum = -1;
		while (!success)
			try {
				doubleNum = userInput.nextDouble();
				if (doubleNum >= 0)
					success = true;
				else {
					success = false;
					System.out.println("Invalid positive Integer, please try again");
				}
			} catch (Exception e) {
				System.out.println("Invalid positive Double, please try again");
			} finally {
				userInput.nextLine();
			}

		return doubleNum;
	}

}
