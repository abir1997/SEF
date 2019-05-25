package menu;

import static enums.MenuOptions.WM_ADD_PRODUCTS;
import static enums.MenuOptions.WM_LIST_PRODUCTS;
import static enums.MenuOptions.WM_REMOVE_PRODUCTS;
import static enums.MenuOptions.WM_REPLENISH_PRODUCT_QUANTITY;
import static enums.MenuOptions.WM_RETURN_TO_LOGIN_SCREEN;

import java.util.Scanner;

import dataAccess.ProductDataAccess;
import enums.MenuOptions;
import model.Product;
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
			System.out.printf("%-30s %s\n", WM_ADD_PRODUCTS.getTxt(), WM_ADD_PRODUCTS.getKey());
			System.out.printf("%-30s %s\n", WM_LIST_PRODUCTS.getTxt(), WM_LIST_PRODUCTS.getKey());
			System.out.printf("%-30s %s\n", WM_REMOVE_PRODUCTS.getTxt(), WM_REMOVE_PRODUCTS.getKey());
			System.out.printf("%-30s %s\n", WM_REPLENISH_PRODUCT_QUANTITY.getTxt(), WM_REPLENISH_PRODUCT_QUANTITY.getKey());
			System.out.printf("%-30s %s\n", WM_RETURN_TO_LOGIN_SCREEN.getTxt(), WM_RETURN_TO_LOGIN_SCREEN.getKey());
			System.out.printf("\nEnter selection:");

			// This takes the user's input and will take them to the letter
			// option they chose
			optionSelected = userInput.nextLine();
			boolean found = false;

			if (WM_ADD_PRODUCTS.getKey().equalsIgnoreCase(optionSelected)) {
				System.out.println("\n------------------------------------------------------------------------");
				System.out.println("*** ADD PRODUCT ***");
				System.out.println("------------------------------------------------------------------------\n");

				System.out.println("Enter product ID: ");
				String productID = userInput.nextLine();

				if (ProductDataAccess.products.containsKey(productID)) {
					found = true;
					System.out.println("Error - Product:  " + productID + " already exists in the system!");
				}

				if (found == false) {

					System.out.println("Enter product quantity:");
					int quantity = userInput.nextInt();

					System.out.println("Enter product price:");
					double price = userInput.nextDouble();

					wStaff.addProduct(new Product(productID, quantity, price));

					System.out.println("New Product: " + productID + " sucessfully added to the system!\n");
				}

			} else if (MenuOptions.WM_LIST_PRODUCTS.getKey().equalsIgnoreCase(optionSelected)) {
				SuperMarketMenus.listProductsInformation();
				
			} else if (WM_REMOVE_PRODUCTS.getKey().equalsIgnoreCase(optionSelected)) {
				System.out.println("\n------------------------------------------------------------------------");
				System.out.println("*** REMOVE PRODUCT ***");
				System.out.println("------------------------------------------------------------------------\n");

				found = false;
				System.out.println("Enter productID: ");
				String productID = userInput.nextLine();

				if (ProductDataAccess.removeProduct(productID)) {
					System.out.println(productID + " sucessfully removed!");
				}else {
					System.out.println("Product not found");
				}

				if (found == false) {
					System.out.println(productID + " is not in the system!");
				}

			} else if (WM_REPLENISH_PRODUCT_QUANTITY.getKey().equalsIgnoreCase(optionSelected)) {
				System.out.println("\n------------------------------------------------------------------------");
				System.out.println("*** REPLENISH PRODUCT ***");
				System.out.println("------------------------------------------------------------------------\n");
				System.out.println("Enter productID: ");
				String productID = userInput.nextLine();

				System.out.println("Enter replenish quantity: ");
				int quantity = userInput.nextInt();

				while (quantity <= 0) {
					System.out.println("Please enter quantity again! It has to be greater than 0");
					System.out.println("Enter replenish quantity: ");
					quantity = userInput.nextInt();
				}

				// For loop is used to check if the product ID already exists
				// in the system
				if (ProductDataAccess.replenishProductQuantity(productID,quantity)) {
					System.out.println(productID + " has succesfully been replinished by " + quantity + " stocks");
				} else if (!ProductDataAccess.products.containsKey(productID)) {
					System.out.println("Product is not found");
					break;
				}

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
