package menu;

import static enums.MenuOptions.MM_ADD_PRODUCT;
import static enums.MenuOptions.MM_AUTO_REPLENISH_PURCHASE_ORDER;
import static enums.MenuOptions.MM_GENERATE_SALES_REPORT;
import static enums.MenuOptions.MM_GENERATE_SUPPLY_REPORT;
import static enums.MenuOptions.MM_LIST_PRODCUT;
import static enums.MenuOptions.MM_LIST_SUPPLIER_DETAILS;
import static enums.MenuOptions.MM_LIST_TOP_PRODUCTS;
import static enums.MenuOptions.MM_OFFER_DISCOUNTS;
import static enums.MenuOptions.MM_REMOVE_PRODUCT;
import static enums.MenuOptions.MM_REPLENISH_PRODUCT_QUANTITY;
import static enums.MenuOptions.MM_RETURN_TO_LOGIN_SCREEN;
import static enums.MenuOptions.MM_UPDATE_PRODUCT;

import java.util.Scanner;
import java.util.Set;

import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import exception.ProductNotFoundException;
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
			System.out.printf("%-30s %s\n", MM_OFFER_DISCOUNTS.getTxt(), MM_OFFER_DISCOUNTS.getKey());
			System.out.printf("%-30s %s\n", MM_AUTO_REPLENISH_PURCHASE_ORDER.getTxt(), MM_AUTO_REPLENISH_PURCHASE_ORDER.getKey());
			
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
			} else if (MM_OFFER_DISCOUNTS.getTxt().equalsIgnoreCase(optionSelected)) {
				addBulkDiscount();
			} else if (MM_AUTO_REPLENISH_PURCHASE_ORDER.getTxt().equalsIgnoreCase(optionSelected)) { 
				autoReplenishPurchaseOrder();
			}else if (MM_GENERATE_SALES_REPORT.getTxt().equalsIgnoreCase(optionSelected)) {
				
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
	
	private static void autoReplenishPurchaseOrder() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** Purchase Order for the following low stock items will be submitted  ***");
		System.out.println("------------------------------------------------------------------------\n");
		Set<Product> replenishableProducts = ProductDataAccess.listProductsBelowReplenish();
		for (Product product : replenishableProducts) {
			System.out.printf("%s %s\n", product.getProductId(), product.getName(), product.getOrderQty(), product.getReplenishLevel(), product.getWarehouseQuantity());
		}
	}

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
		if (ProductDataAccess.products.containsKey(productID)) {
			System.out.println("Error - Product:  " + productID + " already exists in the system!");
		}
		else {
			
			System.out.println("Enter product Name: ");
			String name = userInput.nextLine();

			System.out.println("Enter product quantity:");
			int quantity = userInput.nextInt();

			System.out.println("Enter replenish Level:");
			int replenishLvl = userInput.nextInt();

			System.out.println("Enter order Quantity:");
			int orderQty = userInput.nextInt();

			System.out.println("Enter product price:");
			double price = userInput.nextDouble();

			ProductDataAccess.addProduct(new Product(productID, name, quantity, replenishLvl, orderQty, price));

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
		if (!ProductDataAccess.products.containsKey(productID)) {
			System.out.println("Error - Product:  " + productID + " does not exist in the system!");
		}
		else {

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

	// method to offer specific discount percentages (4)
	public static void addBulkDiscount() {
		System.out.println("Please enter a percentage amount to set the discount to:" + "\n" + "15%" + "\n" + "20%"
				+ "\n" + "Custom Discount");
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter product ID: ");
		String productId = userInput.nextLine();

		if (!ProductDataAccess.products.containsKey(productId)) {
			System.out.println("Error - Product:  " + productId + " does not exist in the system!");
		}
		else {
			System.out.println("Enter product quantity for bulk discount:");
			int qty = userInput.nextInt();

			System.out.println("Enter discount percentage :");
			int percentage = userInput.nextInt();

			if (percentage > 100 || percentage < 0) {
				System.out.println("Error: Percentage is not valid amount");
			} else {
				Product product;
				try {
					product = ProductDataAccess.getProduct(productId);
					product.addDiscount(qty, percentage);
					System.out.println("productId:" + productId+ " You have selected: " + percentage + "% discount for this quantity:" + qty);
				} catch (ProductNotFoundException e) {
					System.out.println("Error - Product:  " + productId + " does not exist in the system!");
				}
			}
		}
		Util.close(userInput);
	}
}
