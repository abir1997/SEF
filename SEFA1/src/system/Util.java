package system;

import java.util.Scanner;

public class Util {

	public static int readPositiveInt(Scanner userInput) {
		boolean success = false;
		int intNum = -1;
		while (!success)
			try {
				intNum = userInput.nextInt();
				success = true;
				if (intNum >= 0)
					success = true;
			} catch (Exception e) {
				System.out.println("Invalid positive Integer, please try again");
			} finally {
				userInput.nextLine();
			}

		return intNum;
	}

	public static double readPositiveDouble(Scanner userInput) {
		boolean success = false;
		double doubleNum = -1;
		while (!success)
			try {
				doubleNum = userInput.nextDouble();
				if (doubleNum >= 0)
					success = true;
			} catch (Exception e) {
				System.out.println("Invalid positive Double, please try again");
			} finally {
				userInput.nextLine();
			}

		return doubleNum;
	}

}
