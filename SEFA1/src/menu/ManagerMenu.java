package menu;

import java.util.Scanner;

import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import exception.ProductNotFoundException;

import static enums.MenuOptions.*;
import model.Manager;
import model.Product;
import system.Util;

public class ManagerMenu {
	public static void managerMenu(Manager mgr) {
		String optionSelected = "";
		Scanner userInput = new Scanner(System.in);
		while (!optionSelected.equalsIgnoreCase("8")) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** MANAGER FUNCTION ***");
			System.out.println("------------------------------------------------------------------------\n");

		
			System.out.printf("%-30s %s\n", MM_LIST_PRODCUT.getTxt(), MM_LIST_PRODCUT.getKey());
			System.out.printf("%-30s %s\n", MM_ADD_PRODUCT.getTxt(), MM_ADD_PRODUCT.getKey());
			System.out.printf("%-30s %s\n", MM_UPDATE_PRODUCT.getTxt(), MM_UPDATE_PRODUCT.getKey());
			System.out.printf("%-30s %s\n", MM_REMOVE_PRODUCT.getTxt(), MM_REMOVE_PRODUCT.getKey());
			
			System.out.printf("%-30s %s\n", MM_REPLENISH_PRODUCT_QUANTITY.getTxt(), MM_REPLENISH_PRODUCT_QUANTITY.getKey());
			System.out.printf("%-30s %s\n", MM_LIST_SUPPLIER_DETAILS.getTxt(), MM_LIST_SUPPLIER_DETAILS.getKey());
			System.out.printf("%-30s %s\n", MM_OVERRIDE_PRODUCT.getTxt(), MM_OVERRIDE_PRODUCT.getKey());
			System.out.printf("%-30s %s\n", MM_APPLY_DISCOUNTS.getTxt(), MM_APPLY_DISCOUNTS.getKey());
			System.out.printf("%-30s %s\n", MM_GENERATE_SALES_REPORT.getTxt(), MM_GENERATE_SALES_REPORT.getKey());
			System.out.printf("%-30s %s\n", MM_GENERATE_SUPPLY_REPORT.getTxt(), MM_GENERATE_SUPPLY_REPORT.getKey());
			System.out.printf("%-30s %s\n", MM_LIST_TOP_PRODUCTS.getTxt(), MM_LIST_TOP_PRODUCTS.getKey());
			System.out.printf("%-30s %s\n", MM_RETURN_TO_LOGIN_SCREEN.getTxt(), MM_RETURN_TO_LOGIN_SCREEN.getKey());
			System.out.printf("\nEnter selection:");

			optionSelected = userInput.nextLine();

			if (MM_LIST_PRODCUT.getKey().equalsIgnoreCase(optionSelected)) {
				SuperMarketMenus.listProductsInformation();
			} else if (MM_ADD_PRODUCT.getKey().equalsIgnoreCase(optionSelected)) {
				addProduct();
			} else if (MM_UPDATE_PRODUCT.getKey().equalsIgnoreCase(optionSelected)) {
				updateProduct();
			} else if (MM_REMOVE_PRODUCT.getKey().equalsIgnoreCase(optionSelected)) {
				removeProduct();
			} else if (MM_REPLENISH_PRODUCT_QUANTITY.getKey().equalsIgnoreCase(optionSelected)) {
				SuperMarketMenus.replenishProduct();
			} else if (MM_LIST_SUPPLIER_DETAILS.getTxt().equalsIgnoreCase(optionSelected)) {
				boolean includeProducts = false;
				System.out.println(SupplierDataAccess.listSupplierDetails(includeProducts));
			} else if (MM_OVERRIDE_PRODUCT.getTxt().equalsIgnoreCase(optionSelected)) {

			} else if (MM_APPLY_DISCOUNTS.getTxt().equalsIgnoreCase(optionSelected)) {

			} else if (MM_GENERATE_SALES_REPORT.getTxt().equalsIgnoreCase(optionSelected)) {

			} else if (MM_GENERATE_SUPPLY_REPORT.getTxt().equalsIgnoreCase(optionSelected)) {

			} else if (MM_LIST_TOP_PRODUCTS.getTxt().equalsIgnoreCase(optionSelected)) {

			} else if (MM_RETURN_TO_LOGIN_SCREEN.getTxt().equalsIgnoreCase(optionSelected)) {

				System.out.println("\nReturning to login sceen...\n");
			} else {
				System.out.println("\nInvalid input");
			}
		}
		Util.close(userInput);

	}
	
	
//	
	public static void removeProduct() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** REMOVE PRODUCT ***");
		System.out.println("------------------------------------------------------------------------\n");
		boolean found = false;
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
		Util.close(userInput);
	} 

	public static void addProduct() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** ADD PRODUCT ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Enter product ID: ");
		String productID = userInput.nextLine();
		boolean found = false;
		if (ProductDataAccess.products.containsKey(productID)) {
			found = true;
			System.out.println("Error - Product:  " + productID + " already exists in the system!");
		}

		if (found == false) {

			System.out.println("Enter product quantity:");
			int quantity = userInput.nextInt();

			System.out.println("Enter replenish Level:");
			int replenishLvl = userInput.nextInt();

			System.out.println("Enter order Quantity:");
			int orderQty = userInput.nextInt();

			System.out.println("Enter product price:");
			double price = userInput.nextDouble();

			ProductDataAccess.addProduct(new Product(productID, quantity, replenishLvl, orderQty, price));

			System.out.println("New Product: " + productID + " sucessfully added to the system!\n");
		}
		Util.close(userInput);
	}
	
	public static void updateProduct() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** UPDATE PRODUCT ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Enter product ID: ");
		String productID = userInput.nextLine();
		boolean found = true;
		if (!ProductDataAccess.products.containsKey(productID)) {
			found = false;
			System.out.println("Error - Product:  " + productID + " does not exist in the system!");
		}

		if (found == true) {

			System.out.println("Enter product quantity:");
			int quantity = userInput.nextInt();

			System.out.println("Enter replenish Level:");
			int replenishLvl = userInput.nextInt();

			System.out.println("Enter order Quantity:");
			int orderQty = userInput.nextInt();

			System.out.println("Enter product price:");
			double price = userInput.nextDouble();

			try {
				ProductDataAccess.updateProduct(productID, quantity, replenishLvl, orderQty, price);
				System.out.println("New Product: " + productID + " sucessfully added to the system!\n");
			} catch (ProductNotFoundException e) {
				System.out.println("Error - Product:  " + productID + " does not exist in the system!");
			}
		}
		Util.close(userInput);
	}

}
