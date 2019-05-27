package menu;

import static enums.MenuOptions.CM_CHECKOUT;
import static enums.MenuOptions.CM_CHECK_DISCOUNTS;
import static enums.MenuOptions.CM_CHECK_PRICE;
import static enums.MenuOptions.CM_LIST_PRODUCTS;
import static enums.MenuOptions.CM_PURCHASE_PRODUCT;
import static enums.MenuOptions.CM_RETURN_TO_LOGIN_SCREEN;

import java.util.Scanner;

import dataAccess.ProductDataAccess;
import model.Customer;
import model.Discount;
import model.Product;
import qrCode.AppFrame;
import qrCode.CreateQR;
import system.Util;

public class CustomerMenu {
	
	private static Scanner userInput = new Scanner(System.in);
	public static void customerMenu(Customer customer) {
		String optionSelected = "";
		
		
		while (!CM_RETURN_TO_LOGIN_SCREEN.getKey().equalsIgnoreCase(optionSelected)) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** CUSTOMER FUNCTIONS ***");
			System.out.println("------------------------------------------------------------------------\n");

			System.out.printf("%-30s %s\n", CM_PURCHASE_PRODUCT.getTxt(), CM_PURCHASE_PRODUCT.getKey());
			System.out.printf("%-30s %s\n", CM_LIST_PRODUCTS.getTxt(), CM_LIST_PRODUCTS.getKey());
			System.out.printf("%-30s %s\n", CM_CHECK_PRICE.getTxt(), CM_CHECK_PRICE.getKey());
			System.out.printf("%-30s %s\n", CM_CHECK_DISCOUNTS.getTxt(), CM_CHECK_DISCOUNTS.getKey());
			System.out.printf("%-30s %s\n", CM_CHECKOUT.getTxt(), CM_CHECKOUT.getKey());
			
			System.out.printf("%-30s %s\n", CM_RETURN_TO_LOGIN_SCREEN.getTxt(), CM_RETURN_TO_LOGIN_SCREEN.getKey());
			System.out.printf("\nEnter selection:");


			optionSelected = userInput.nextLine();
			// This takes the user's input and will take them to the letter
			// option they chose
			if (CM_PURCHASE_PRODUCT.getKey().equalsIgnoreCase(optionSelected)) {
				purchaseMenu(customer);
			}
			 else if (CM_LIST_PRODUCTS.getKey().equalsIgnoreCase(optionSelected)) {
				 SuperMarketMenus.listProductsInformation();

			} else if (CM_CHECK_PRICE.getKey().equalsIgnoreCase(optionSelected)) {
				checkPrice();

			} else if (CM_CHECK_DISCOUNTS.getKey().equalsIgnoreCase(optionSelected)) {
				checkDiscounts();
			} else if (CM_CHECKOUT.getKey().equalsIgnoreCase(optionSelected)) {
				double paid = customer.checkout();
				System.out.printf("\nCheck out successful, paid: $%7.2f\n\n", paid );
			}
			else if (CM_RETURN_TO_LOGIN_SCREEN.getKey().equalsIgnoreCase(optionSelected)) {
				System.out.println("\nReturning to login sceen...\n");

			} else {
				System.out.println("\nInvalid input");

			}
		}
	}
	
	
	private static void checkPrice() {
		System.out.println("Enter productId you want to check price: ");
		String productID = userInput.nextLine();
		try {
		double price = ProductDataAccess.getProductPrice(productID);
			System.out.println("the price of " + productID + " is " + price);
			CreateQR qr = new CreateQR("https://shop.coles.com.au/a/a-national/product/arnotts-biscuits-shapes-savoury");
			new AppFrame();
			
		}
		catch (Exception e) {
			System.out.println("this product does not exist");
		} 
	}
	
	private static void checkDiscounts() {
		System.out.println("Enter productId you want to check Discount: ");
		String productID = userInput.nextLine();
		try {
			Product prd = ProductDataAccess.getProduct(productID);
			System.out.println("Available Discounts of " + productID + " are: \n" );
			for (Discount discount :prd.getDiscounts()) {
				System.out.println(discount);
			}
		}
		catch (Exception e) {
			System.out.println("this product does not exist");
		}
	}
	
	private static void purchaseMenu(Customer customer) {
		System.out.println("Enter productId you want to buy: ");
		String productID = userInput.nextLine();

		if (ProductDataAccess.products.containsKey(productID)) {
			System.out.println("Enter amount of product you want to buy: ");
			int amount = Util.readPositiveInt(userInput);

			if (amount <= ProductDataAccess.products.get(productID).getWarehouseQuantity()) {
				customer.addToCart(productID, amount);
			} else {
				System.out.println("There is not enough product. ");
			}

		} else {
			System.out.println("this productID is not exist");
		}
	}

}
