package menu;

import static enums.MenuOptions.WM_LIST_PRODUCTS;
import static enums.MenuOptions.WM_REPLENISH_PRODUCT_QUANTITY;
import static enums.MenuOptions.WM_RETURN_TO_LOGIN_SCREEN;

import java.util.Scanner;

import enums.MenuOptions;
import model.WareHouseStaff;
import system.Util;

public class WareHouseStaffMenu {
	public static void wareHouseStaffMenu(WareHouseStaff wStaff) {
		String optionSelected = "";
		Scanner userInput = new Scanner(System.in);
		
		while (!MenuOptions.WM_RETURN_TO_LOGIN_SCREEN.getKey().equalsIgnoreCase(optionSelected)) {

			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** WAREHOUSESTAFF FUNCTIONS ***");
			System.out.println("------------------------------------------------------------------------\n");
			System.out.printf("%-30s %s\n", WM_LIST_PRODUCTS.getTxt(), WM_LIST_PRODUCTS.getKey());
			System.out.printf("%-30s %s\n", WM_REPLENISH_PRODUCT_QUANTITY.getTxt(), WM_REPLENISH_PRODUCT_QUANTITY.getKey());
			System.out.printf("%-30s %s\n", WM_RETURN_TO_LOGIN_SCREEN.getTxt(), WM_RETURN_TO_LOGIN_SCREEN.getKey());
			System.out.printf("\nEnter selection:");

			// This takes the user's input and will take them to the letter
			// option they chose
			optionSelected = userInput.nextLine();
			boolean found = false;

			if (MenuOptions.WM_LIST_PRODUCTS.getKey().equalsIgnoreCase(optionSelected)) {
				SuperMarketMenus.listProductsInformation();
			} else if (WM_REPLENISH_PRODUCT_QUANTITY.getKey().equalsIgnoreCase(optionSelected)) {
				SuperMarketMenus.replenishProduct();
			} else if (WM_RETURN_TO_LOGIN_SCREEN.getKey().equalsIgnoreCase(optionSelected)) {

				System.out.println("\nReturning to login sceen...\n");
				// returns to main menu
			} else {
				System.out.println("Invalid input");

			}
		}
		Util.close(userInput);
	}


}
