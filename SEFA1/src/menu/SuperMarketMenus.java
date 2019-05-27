package menu;

import java.util.Scanner;

import dataAccess.DataStoreFactory;
import dataAccess.ProductDataAccess;
import dataAccess.UserDataAccess;
import model.Customer;
import model.CustomerCard;
import model.Manager;
import model.Product;
import model.SalesStaff;
import model.User;
import model.WareHouseStaff;
import system.Util;

public class SuperMarketMenus {

	private User loggedInUser = null;
	private static Scanner userInput = new Scanner(System.in);
	
	public void mainMenu() {
		String optionSelected = "";
		while (!optionSelected.equalsIgnoreCase("3")) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** SUPER MARKET SUPPORT SYSTEM ***");
			System.out.println("------------------------------------------------------------------------\n");

			System.out.println("Welcome to LALA self-checkout system, please select your option:\n");

			System.out.printf("%-30s %s\n", "OPTION", "SELECTION");
			System.out.println("------------------------------------------------------------------------");
			System.out.printf("%-30s %s\n", "Login", "1");
			System.out.printf("%-30s %s\n", "Register", "2");
			System.out.printf("%-30s %s\n", "Exit System", "3");
			System.out.printf("\nEnter selection:");

			// This takes the user's input and will take them to the letter
			// option they chose
			
			optionSelected = userInput.nextLine();

			if (optionSelected.equalsIgnoreCase("1")) {
				userLoginMenu();

			} else if (optionSelected.equalsIgnoreCase("2")) {
				registerMenu();

			} else if (optionSelected.equalsIgnoreCase("3")) {
				System.out.println("\nSaving system data...");
				System.out.println("Data saved!");
				System.out.println("Good bye!");

				// writes data to the text file when exiting
				DataStoreFactory.getDataStore().saveData();
				// stops the program
				System.exit(0);
			} else {
				System.out.println("\nInvalid input");

			}
		}
	}


	
	private void registerMenu() {
		String optionSelected = "";

		while (!optionSelected.equalsIgnoreCase("5")) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** REGISTRATION SCREEN ***");
			System.out.println("------------------------------------------------------------------------\n");

			System.out.println("Select which account you want to register as: \n");

			System.out.printf("%-30s %s\n", "Customer", "1");
			System.out.printf("%-30s %s\n", "SalesStaff", "2");
			System.out.printf("%-30s %s\n", "WareHouseStaff", "3");
			System.out.printf("%-30s %s\n", "Manager", "4");
			System.out.printf("%-30s %s\n", "Return to Login Screen", "5");
			System.out.printf("\nEnter selection:");

			// This takes the user's input and will take them to the letter
			// option they chose
			optionSelected = userInput.nextLine();

			if (optionSelected.equalsIgnoreCase("1")) {
				registerCustomerMenu();

			} else if (optionSelected.equalsIgnoreCase("2")) {
				registerSalesStaffMenu();

			} else if (optionSelected.equalsIgnoreCase("3")) {
				registerWareHouseStaffMenu();

			} else if (optionSelected.equalsIgnoreCase("4")) {
				registerManagerMenu();

			} else if (optionSelected.equalsIgnoreCase("5")) {

				System.out.println("\nReturning to login sceen...\n");
				// returns to main menu
				mainMenu();
			} else {
				System.out.println("\nInvalid input");
			}
		}
	}

	private void registerManagerMenu() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** MANAGER REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a manager account! \n");

		System.out.println("Enter id: ");
		int id = Util.readPositiveInt(userInput);

		// For loop is used to check if the email already exists
		// in the system
		if (UserDataAccess.users.containsKey(id)) {
			System.out.println("Error - id:  " + id + " already exists in the system!");
			return;
		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		Manager manager = new Manager(name, id, password);
		UserDataAccess.users.put(id, manager);

		System.out.println("New Manager: " + id + " sucessfully added to the system!\n");
	}

	private void registerWareHouseStaffMenu() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** WAREHOUSESTAFF REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a warehousestaff account! \n");

		System.out.println("Enter id: ");
		int id = Util.readPositiveInt(userInput);
		if (UserDataAccess.users.containsKey(id)) {
			System.out.println("Error - Id:  " + id + " already exists in the system!");
			return;
		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		WareHouseStaff wareHouseStaff = new WareHouseStaff(name, id, password);
		UserDataAccess.users.put(id, wareHouseStaff);

		System.out.println("New WareHouseStaff: " + id + " sucessfully added to the system!\n");
	}

	private void registerSalesStaffMenu() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** SALESSTAFF REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a SalesStaff account! \n");


		System.out.println("Enter id: ");
		int id = Util.readPositiveInt(userInput);

		if (UserDataAccess.users.containsKey(id)) {
			System.out.println("Error - Id:  " + id + " already exists in the system!");
			return;
		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		SalesStaff salesStaff = new SalesStaff(name, id, password);
		UserDataAccess.users.put(id, salesStaff);

		System.out.println("New SalesStaff: " + id + " sucessfully added to the system!");
		System.out.println();
	}

	private void registerCustomerMenu() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** CUSTOMER REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a customer account! \n");

		System.out.println("Enter Id: ");
		int id = Util.readPositiveInt(userInput);

		// For loop is used to check if the email already exists
		// in the system
		if (UserDataAccess.users.containsKey(id)) {
			System.out.println("Error - Id:  " + id + " already exists in the system!");
			return;
		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		System.out.println("Enter CustomerCard:");
		String card = userInput.nextLine();

		Customer customer = new Customer(name, id, password, new CustomerCard(0.0, card));
		UserDataAccess.users.put(id, customer);

		System.out.println("New customer: " + id + " sucessfully added to the system!\n");
	}

	private void userLoginMenu() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** LOGIN SCREEN ***");
		System.out.println("------------------------------------------------------------------------\n");
		System.out.println("Please enter your login details: \n");

		System.out.println("Enter id: ");
		int id = Util.readPositiveInt(userInput);
		System.out.println("Enter password: ");
		String password = userInput.nextLine();
		if (UserDataAccess.users.get(id).getPwd().equals(password)) {

			if (UserDataAccess.users.get(id) instanceof Customer) {
				System.out.print("You have successfully logged in as a Customer");
				loggedInUser = UserDataAccess.users.get(id);
				CustomerMenu.customerMenu(((Customer) loggedInUser));
				return;
			}
			else if (UserDataAccess.users.get(id) instanceof WareHouseStaff) {
				System.out.print("You have successfully logged in as a WareHouseStaff");
				loggedInUser = UserDataAccess.users.get(id);
				WareHouseStaffMenu.wareHouseStaffMenu((WareHouseStaff)loggedInUser);
				return;
			} else if (UserDataAccess.users.get(id) instanceof SalesStaff) {
				System.out.print("You have successfully logged in as a SalesStaff");
				SalesStaffMenu.salesStaffMenu((SalesStaff)loggedInUser);
				return;
			} else if (UserDataAccess.users.get(id) instanceof Manager) {
				System.out.print("You have successfully logged in as a Manager");
				ManagerMenu.managerMenu((Manager)loggedInUser);
				return;
			}
		}

		System.out.println("Invalid email or password! Please try again.");
	}



	static void replenishProduct() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** REPLENISH PRODUCT ***");
		System.out.println("------------------------------------------------------------------------\n");
		System.out.println("Enter productID: ");
		String productID = userInput.nextLine();
	
		System.out.println("Enter replenish quantity: ");
		int quantity = Util.readPositiveInt(userInput);
	
		while (quantity <= 0) {
			System.out.println("Please enter quantity again! It has to be greater than 0");
			System.out.println("Enter replenish quantity: ");
			quantity = Util.readPositiveInt(userInput);
		}
	
		if (ProductDataAccess.replenishProductQuantity(productID,quantity)) {
			System.out.println(productID + " has succesfully been replinished by " + quantity + " stocks");
		} else if (!ProductDataAccess.products.containsKey(productID)) {
			System.out.println("Product is not found");
		}
	}

	public static void listProductsInformation() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** LIST OF PRODUCTS INFORMATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		for (Product product: ProductDataAccess.getAllProducts()) {
			System.out.println(product);
			System.out.println();
		}
	}

}
