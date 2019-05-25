package menu;

import java.util.Scanner;

import dataAccess.ProductDataAccess;
import dataAccess.UserDataAccess;
import model.Customer;
import model.Product;
import model.SalesStaff;
import system.Util;

public class SalesStaffMenu {
	
	public static void salesStaffMenu(SalesStaff sStaff) {
		String optionSelected = "";
		Scanner userInput = new Scanner(System.in);
		while (!optionSelected.equalsIgnoreCase("3")) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** SALESSTAFF FUNCTIONS ***");
			System.out.println("------------------------------------------------------------------------\n");

			System.out.printf("%-30s %s\n", "Remove Item", "1");
			System.out.printf("%-30s %s\n", "Cancel Order", "2");
			System.out.printf("%-30s %s\n", "Return to Login Screen", "3");
			System.out.printf("\nEnter selection:");

			// This takes the user's input and will take them to the letter
			// option they chose

			optionSelected = userInput.nextLine();
			Customer customer;

			if (optionSelected.equalsIgnoreCase("1")) {
				System.out.println("Please enter the id of Customer");
				int id = userInput.nextInt();
				customer = null;
				if (UserDataAccess.users.get(id) instanceof Customer) {
					customer = (Customer) UserDataAccess.users.get(id);

				}

				if (customer != null) {
					System.out.printf("Customer %s Found!", customer.getName());

					while (true) {
						System.out.println("Please enter the product to remove or type exit to quit");
						String pId = userInput.nextLine();
						Product product = null;
						String message = "Product Not Found!";

						product = ProductDataAccess.products.get(pId);
						if (!customer.getCart().getSaleLineItems().contains(product)) {
							message = "Product not found in customer's cart!";
							product = null;
							break;
						}

						if (product != null) {

							customer.getCart().removeProduct(product);
							System.out.printf("Product %s Found! and removed", product.toString());							
						
						} else if (id == 0) {
							break;
						} else {
							System.out.println(message);
						}
					}
				} else {
					System.out.println("Customer Not Found!");
				}

			} else if (optionSelected.equalsIgnoreCase("2")) {
				System.out.println("Please enter the name of Customer");
				String customerSelected = userInput.nextLine();
				customer = null;
				for (int i = 0; i < UserDataAccess.users.size(); i++) {
					if (UserDataAccess.users.get(i) instanceof Customer) {
						if (UserDataAccess.users.get(i).getName().equals(customerSelected)) {
							customer = (Customer) UserDataAccess.users.get(i);
							break;
						}
					}
				}

				if (customer != null) {
					System.out.printf("Customer %s Found! Cancelling transaction%n", customer.getName());
					customer.emptyCart();
				} else {
					System.out.println("Customer Not Found!");
				}
			} else if (optionSelected.equalsIgnoreCase("3")) {
				System.out.println("\nReturning to login sceen...\n");
			} else {
				System.out.println("\nInvalid input");

			}
		}
		Util.close(userInput);
	}
}
