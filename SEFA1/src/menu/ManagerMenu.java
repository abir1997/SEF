package menu;

import java.util.Scanner;

import model.Manager;
import system.Util;

public class ManagerMenu {
	public static void managerMenu(Manager mgr) {
		String optionSelected = "";
		Scanner userInput = new Scanner(System.in);
		while (!optionSelected.equalsIgnoreCase("8")) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** MANAGER FUNCTION ***");
			System.out.println("------------------------------------------------------------------------\n");

			System.out.printf("%-30s %s\n", "Replenish Product Quantity", "1");
			System.out.printf("%-30s %s\n", "List Supplier Details", "2");
			System.out.printf("%-30s %s\n", "Override Product", "3");
			System.out.printf("%-30s %s\n", "Apply Discounts", "4");
			System.out.printf("%-30s %s\n", "Generate Sales Report", "5");
			System.out.printf("%-30s %s\n", "Generate Supply Report", "6");
			System.out.printf("%-30s %s\n", "List Top Products", "7");
			System.out.printf("%-30s %s\n", "Return to Login Screen", "8");
			System.out.printf("\nEnter selection:");

			optionSelected = userInput.nextLine();

			if (optionSelected.equalsIgnoreCase("1")) {

			} else if (optionSelected.equalsIgnoreCase("2")) {

			} else if (optionSelected.equalsIgnoreCase("3")) {

			} else if (optionSelected.equalsIgnoreCase("4")) {

			} else if (optionSelected.equalsIgnoreCase("5")) {

			} else if (optionSelected.equalsIgnoreCase("6")) {

			} else if (optionSelected.equalsIgnoreCase("7")) {

			} else if (optionSelected.equalsIgnoreCase("8")) {

				System.out.println("\nReturning to login sceen...\n");
			} else {
				System.out.println("\nInvalid input");
			}
		}
		Util.close(userInput);

	}
}
