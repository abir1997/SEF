package menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.*;

public class SuperMarketSystem {

	public static Map<Integer, Product> products = new HashMap<>();
	public static Map<Integer, User> users = new HashMap<>();
	private boolean on = true;
	double result;
	private User loggedInUser = null;

	public void loginScreen() {

		String optionSelected = "";

		while (!optionSelected.equalsIgnoreCase("3")) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** SUPER MARKET SUPPORT SYSTEM ***");
			System.out.println("------------------------------------------------------------------------\n");

			System.out.println("Welcome to A-TEAM self-checkout system, please select your option:\n");

			System.out.printf("%-30s %s\n", "OPTION", "SELECTION");
			System.out.println("------------------------------------------------------------------------");
			System.out.printf("%-30s %s\n", "Login", "1");
			System.out.printf("%-30s %s\n", "Register", "2");
			System.out.printf("%-30s %s\n", "Exit System", "3");
			System.out.printf("\nEnter selection:");

			// This takes the user's input and will take them to the letter
			// option they chose
			Scanner userInput = new Scanner(System.in);
			optionSelected = userInput.nextLine();

			if (optionSelected.equalsIgnoreCase("1")) {
				userLogin();

			} else if (optionSelected.equalsIgnoreCase("2")) {
				registerScreen();

			} else if (optionSelected.equalsIgnoreCase("3")) {
				System.out.println("\nSaving system data...");
				System.out.println("Data saved!");
				System.out.println("Good bye!");

				// writes data to the text file when exiting
				saveUserData();
				saveProductData();
				// stops the program
				System.exit(0);
			} else {
				System.out.println("\nInvalid input");

			}
		}
	}

	private void saveProductData() {
		// TODO Auto-generated method stub

	}

	private void saveUserData() {
		// TODO Auto-generated method stub

	}

	private void registerScreen() {
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
			Scanner userInput = new Scanner(System.in);
			optionSelected = userInput.nextLine();

			if (optionSelected.equalsIgnoreCase("1")) {
				registerCustomer();

			} else if (optionSelected.equalsIgnoreCase("2")) {
				registerSalesStaff();

			} else if (optionSelected.equalsIgnoreCase("3")) {
				registerWareHouseStaff();

			} else if (optionSelected.equalsIgnoreCase("4")) {
				registerManager();

			} else if (optionSelected.equalsIgnoreCase("5")) {

				System.out.println("\nReturning to login sceen...\n");
				// returns to main menu
				loginScreen();
			} else {
				System.out.println("\nInvalid input");

			}
		}
	}

	private void registerManager() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** MANAGER REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a manager account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = userInput.nextInt();

		// For loop is used to check if the email already exists
		// in the system
		if (users.containsKey(id)) {
			System.out.println("Error - id:  " + id + " already exists in the system!");
			return;
		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		Manager manager = new Manager(name, id, password);
		users.put(id, manager);

		System.out.println("New Manager: " + id + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	private void registerWareHouseStaff() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** WAREHOUSESTAFF REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a warehousestaff account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = userInput.nextInt();

		if (users.containsKey(id)) {
			System.out.println("Error - Id:  " + id + " already exists in the system!");
			return;
		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		WareHouseStaff wareHouseStaff = new WareHouseStaff(name, id, password);
		users.put(id, wareHouseStaff);

		System.out.println("New WareHouseStaff: " + id + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	private void registerSalesStaff() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** SALESSTAFF REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a SalesStaff account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter email: ");
		System.out.println("Enter id: ");
		int id = userInput.nextInt();

		if (users.containsKey(id)) {
			System.out.println("Error - Id:  " + id + " already exists in the system!");
			return;
		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		SalesStaff salesStaff = new SalesStaff(name, id, password);
		users.put(id, salesStaff);

		System.out.println("New SalesStaff: " + id + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	private void registerCustomer() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** CUSTOMER REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a customer account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter Id: ");
		int id = userInput.nextInt();

		// For loop is used to check if the email already exists
		// in the system
		if (users.containsKey(id)) {
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
		users.put(id, customer);

		System.out.println("New customer: " + id + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	private void userLogin() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** LOGIN SCREEN ***");
		System.out.println("------------------------------------------------------------------------\n");
		System.out.println("Please enter your login details: \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = userInput.nextInt();
		System.out.println("Enter password: ");
		String password = userInput.nextLine();

		if (users.get(id).getPwd().equals(password)) {

			if (users.get(id) instanceof Customer) {
				System.out.print("You have successfully logged in as a Customer");
				loggedInUser = users.get(id);
				customerMenuFunctions();
				return;
			}

			else if (users.get(id) instanceof WareHouseStaff) {
				System.out.print("You have successfully logged in as a WareHouseStaff");
				loggedInUser = users.get(id);
				wareHouseStaffMenuFunctions();
				return;
			} else if (users.get(id) instanceof SalesStaff) {
				System.out.print("You have successfully logged in as a SalesStaff");
				salesStaffMenuFunctions();
				return;
			} else if (users.get(id) instanceof Manager) {
				System.out.print("You have successfully logged in as a Manager");
				managerMenuFunctions();
				return;
			}

		}

		System.out.println("Invalid email or password! Please try again.");
		return;

	}

	private void managerMenuFunctions() {
		String optionSelected = "";
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

			// TODO
			Scanner userInput = new Scanner(System.in);
			optionSelected = userInput.nextLine();

			if (optionSelected.equalsIgnoreCase("1")) {

			} else if (optionSelected.equalsIgnoreCase("2")) {

			} else if (optionSelected.equalsIgnoreCase("3")) {

			} else if (optionSelected.equalsIgnoreCase("4")) {

			} else if (optionSelected.equalsIgnoreCase("5")) {

			} else if (optionSelected.equalsIgnoreCase("6")) {

			} else if (optionSelected.equalsIgnoreCase("7")) {

			} else if (optionSelected.equalsIgnoreCase("8")) {

				on = false;
				System.out.println("\nReturning to login sceen...\n");
				// returns to main menu
				loginScreen();
			} else {
				System.out.println("\nInvalid input");

			}
		}
	}

	private void salesStaffMenuFunctions() {
		String optionSelected = "";
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
			Scanner userInput = new Scanner(System.in);
			optionSelected = userInput.nextLine();
			Customer customer;

			if (optionSelected.equalsIgnoreCase("1")) {
				System.out.println("Please enter the id of Customer");
				int id = userInput.nextInt();
				customer = null;
				if (users.get(id) instanceof Customer) {
					customer = (Customer) users.get(id);
					
				}

				if (customer != null) {
					System.out.printf("Customer %s Found!", customer.getName());

					while (true) {
						System.out.println("Please enter the product to remove or type exit to quit");
						int pId = userInput.nextInt();
						Product product = null;
						String message = "Product Not Found!";

						product = products.get(pId);
						if (!customer.getSales().getAllProducts().contains(product)) {
							message = "Product not found in customer's cart!";
							product = null;
							break;
						}
						

						if (product != null) {
							System.out.printf("Product %s Found! ", product.toString());
							while (true) {
								System.out.println("Please enter the amount to remove or 0 to quit (default:1)");
								String amount = userInput.nextLine();
								if (amount.isEmpty()) {
									if (!customer.getSales().removeProduct(product)) {
										System.out.printf("Not enough quantity to remove! Remaining quantity :%d%n",
												customer.getSales().checkQuantity(product));
										continue;
									}
								} else if (Integer.parseInt(amount) == 0) {
									break;
								} else {
									if (!customer.getSales().removeProduct(product, Integer.parseInt(amount))) {
										System.out.printf("Not enough quantity to remove! Remaining quantity :%d%n",
												customer.getSales().checkQuantity(product));
										continue;
									}
								}
								System.out.printf("Product successfully removed! Remaining quantity :%d%n",
										customer.getSales().checkQuantity(product));
								break;
							}
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
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i) instanceof Customer) {
						if (users.get(i).getName().equals(customerSelected)) {
							customer = (Customer) users.get(i);
							break;
						}
					}
				}

				if (customer != null) {
					System.out.printf("Customer %s Found! Cancelling transaction%n", customer.getName());
					customer.getSales().removeAllProduct();
				} else {
					System.out.println("Customer Not Found!");
				}
			} else if (optionSelected.equalsIgnoreCase("3")) {

				System.out.println("\nReturning to login sceen...\n");
				// returns to main menu
				loginScreen();
			} else {
				System.out.println("\nInvalid input");

			}
		}
	}

	private void wareHouseStaffMenuFunctions() {
		String optionSelected = "";

		while (!optionSelected.equalsIgnoreCase("6")) {

			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** WAREHOUSESTAFF FUNCTIONS ***");
			System.out.println("------------------------------------------------------------------------\n");
			System.out.printf("%-30s %s\n", "Add Products", "1");
			System.out.printf("%-30s %s\n", "List Products", "2");
			System.out.printf("%-30s %s\n", "Remove Products", "3");
			System.out.printf("%-30s %s\n", "Replenish Product Quantity", "4");
			System.out.printf("%-30s %s\n", "Return to Login Screen", "5");
			System.out.printf("\nEnter selection:");

			// This takes the user's input and will take them to the letter
			// option they chose
			Scanner userInput = new Scanner(System.in);
			optionSelected = userInput.nextLine();
			boolean found = false;

			if (optionSelected.equalsIgnoreCase("1")) {
				System.out.println("\n------------------------------------------------------------------------");
				System.out.println("*** ADD PRODUCT ***");
				System.out.println("------------------------------------------------------------------------\n");

				Scanner userInput1 = new Scanner(System.in);
				System.out.println("Enter product ID: ");
				String productID = userInput1.nextLine();

				// For loop is used to check if the product ID already exists
				// in the system
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getProductID().equals(productID)) {
						found = true;
						System.out.println("Error - Product:  " + productID + " already exists in the system!");
						break;
					}

				}

				if (found == false) {

					System.out.println("Enter product quantity:");
					int quantity = userInput.nextInt();

					System.out.println("Enter product price:");
					double price = userInput.nextDouble();

					((WareHouseStaff) loggedInUser).addProduct(new Product(productID, quantity, price));

					System.out.println("New Product: " + productID + " sucessfully added to the system!");
					saveProductData();
					System.out.println();
				}

			} else if (optionSelected.equalsIgnoreCase("2")) {
				((WareHouseStaff) loggedInUser).listProductInformation();

			} else if (optionSelected.equalsIgnoreCase("3")) {
				System.out.println("\n------------------------------------------------------------------------");
				System.out.println("*** REMOVE PRODUCT ***");
				System.out.println("------------------------------------------------------------------------\n");
				Scanner userInput1 = new Scanner(System.in);
				boolean found3 = false;
				System.out.println("Enter productID: ");
				String productID = userInput1.nextLine();

				// For loop is used to check if the product ID already exists
				// in the system
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getProductID().equals(productID)) {
						found3 = true;
						((WareHouseStaff) loggedInUser).removeProduct(products.get(i));
						System.out.println(productID + " sucessfully removed!");
						break;
					}

				}

				if (found3 == false) {
					System.out.println(productID + " is not in the system!");
				}

			} else if (optionSelected.equalsIgnoreCase("4")) {
				System.out.println("\n------------------------------------------------------------------------");
				System.out.println("*** REPLENISH PRODUCT ***");
				System.out.println("------------------------------------------------------------------------\n");
				boolean found1 = false;
				Scanner userInput2 = new Scanner(System.in);
				System.out.println("Enter productID: ");
				String productID = userInput2.nextLine();
				

				
				System.out.println("Enter replenish quantity: ");
				int quantity = userInput2.nextInt();
				
				while(quantity <= 0)
				{
					System.out.println("Please enter quantity again! It has to be greater than 0");
					System.out.println("Enter replenish quantity: ");
					quantity = userInput2.nextInt();
				}

				// For loop is used to check if the product ID already exists
				// in the system
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getProductID().equals(productID)) {
						found1 = true;
						((WareHouseStaff) loggedInUser).replenishQuantity(products.get(i), quantity);
						System.out.println(productID + " has succesfully been replinished by " + quantity + " stocks");
						break;
					}

				}
				if (found1 == false) {
					System.out.println(productID + " is not in the system!");

				}

			} else if (optionSelected.equalsIgnoreCase("5")) {

				System.out.println("\nReturning to login sceen...\n");
				// returns to main menu
				loginScreen();
			} else {
				System.out.println("Invalid input");

			}
		}
	}

	private void customerMenuFunctions() {
		// TODO Auto-generated method stub

	}

}
