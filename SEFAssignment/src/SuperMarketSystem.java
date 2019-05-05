
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarketSystem {
	/*
	 * Login Details
	 * 
	 * Customer Email: customer@gmail.com Password: customer
	 * 
	 * WareHouseStaff Email: warehousestaff@gmail.com Password: warehousestaff
	 * 
	 * SalesStaff Email: salestaff@gmail.com Password: salesstaff
	 * 
	 * Manager Email: manager@gmail.com Password: manager
	 * 
	 */

	// An ArrayList is used because the size is unknown, this will store
	// product objects
	public static ArrayList<Product> products = new ArrayList<>();
	public static ArrayList<User> users = new ArrayList<>();

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

	public void userLogin() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** LOGIN SCREEN ***");
		System.out.println("------------------------------------------------------------------------\n");
		System.out.println("Please enter your login details: \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter email: ");
		String email = userInput.nextLine();
		System.out.println("Enter password: ");
		String password = userInput.nextLine();

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)) {

				if (users.get(i) instanceof Customer) {
					System.out.print("You have successfully logged in as a Customer");
					loggedInUser = users.get(i);
					customerMenuFunctions();
					return;
				}

				if (users.get(i) instanceof WareHouseStaff) {
					System.out.print("You have successfully logged in as a WareHouseStaff");
					loggedInUser = users.get(i);
					wareHouseStaffMenuFunctions();
					return;
				}
				if (users.get(i) instanceof SalesStaff) {
					System.out.print("You have successfully logged in as a SalesStaff");
					salesStaffMenuFunctions();
					return;
				}
				if (users.get(i) instanceof Manager) {
					System.out.print("You have successfully logged in as a Manager");
					managerMenuFunctions();
					return;
				}

			}

		}
		System.out.println("Invalid email or password! Please try again.");
		return;

	}

	public void registerScreen() {

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

	public void registerCustomer() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** CUSTOMER REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a customer account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter email: ");
		String email = userInput.nextLine();

		// For loop is used to check if the email already exists
		// in the system
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)) {
				System.out.println("Error - Email:  " + email + " already exists in the system!");
				return;
			}

		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		System.out.println("Enter phone:");
		String phone = userInput.nextLine();

		System.out.println("Enter CreditCard:");
		String creditCard = userInput.nextLine();

		// Creates a customer object, and adds it to the users arraylist
		// ArrayList
		Customer customer = new Customer(name, email, password, phone, new CreditCard(0.0, creditCard));
		users.add(customer);

		System.out.println("New customer: " + email + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	public void registerWareHouseStaff() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** WAREHOUSESTAFF REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a warehousestaff account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter email: ");
		String email = userInput.nextLine();

		// For loop is used to check if the email already exists
		// in the system
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)) {
				System.out.println("Error - Email:  " + email + " already exists in the system!");
				return;
			}

		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		System.out.println("Enter phone number:");
		String phone = userInput.nextLine();

		WareHouseStaff wareHouseStaff = new WareHouseStaff(name, email, password, phone);
		users.add(wareHouseStaff);

		System.out.println("New WareHouseStaff: " + email + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	public void registerSalesStaff() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** SALESSTAFF REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a SalesStaff account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter email: ");
		String email = userInput.nextLine();

		// For loop is used to check if the email already exists
		// in the system
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)) {
				System.out.println("Error - Email:  " + email + " already exists in the system!");
				return;
			}

		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		System.out.println("Enter phone:");
		String phone = userInput.nextLine();

		SalesStaff salesStaff = new SalesStaff(name, email, password, phone);
		users.add(salesStaff);

		System.out.println("New SalesStaff: " + email + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	public void registerManager() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** MANAGER REGISTRATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Fill in your details to create a manager account! \n");

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter email: ");
		String email = userInput.nextLine();

		// For loop is used to check if the email already exists
		// in the system
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)) {
				System.out.println("Error - Email:  " + email + " already exists in the system!");
				return;
			}

		}

		System.out.println("Enter password:");
		String password = userInput.nextLine();

		System.out.println("Enter name:");
		String name = userInput.nextLine();

		System.out.println("Enter phone:");
		String phone = userInput.nextLine();

		Manager salesStaff = new Manager(name, email, password, phone);
		users.add(salesStaff);

		System.out.println("New Manager: " + email + " sucessfully added to the system!");
		System.out.println();
		saveUserData();
	}

	// This method creates a menu for the customer functions
	public void customerMenuFunctions() {

		String optionSelected = "";

		while (!optionSelected.equalsIgnoreCase("4")) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("*** CUSTOMER FUNCTIONS ***");
			System.out.println("------------------------------------------------------------------------\n");

			System.out.printf("%-30s %s\n", "Purchase Product", "1");
			System.out.printf("%-30s %s\n", "List Product", "2");
			System.out.printf("%-30s %s\n", "Check Price", "3");
			System.out.printf("%-30s %s\n", "Return to Login Screen", "4");
			System.out.printf("\nEnter selection:");
			Scanner userInput = new Scanner(System.in);

			optionSelected = userInput.nextLine();
			// This takes the user's input and will take them to the letter
			// option they chose

			if (optionSelected.equalsIgnoreCase("1")) {
				((Customer) loggedInUser).purchase();
				}
			 else if (optionSelected.equalsIgnoreCase("2")) {
				((Customer) loggedInUser).listProductInformation();

			} else if (optionSelected.equalsIgnoreCase("3")) {
				((Customer) loggedInUser).checkPrice();

			} else if (optionSelected.equalsIgnoreCase("4")) {
			

				// On is set to false in order to stop the while-loop

				System.out.println("\nReturning to login sceen...\n");
				// returns to main menu
				loginScreen();
			} else {
				System.out.println("\nInvalid input");

			}
		}
	}

	// This method creates a menu list where the user selects their option by
	// entering a letter, and it will take them to that option.
	public void managerMenuFunctions() {

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

			// This takes the user's input and will take them to the letter
			// option they chose
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

	// This method creates a menu list where the user selects their option by
	// entering a letter, and it will take them to that option.
	public void salesStaffMenuFunctions() {
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
				System.out.println("Please enter the name of Customer");
				String customerSelected = userInput.nextLine();
				customer = null;
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i) instanceof Customer) {
						if (users.get(i).getName().equalsIgnoreCase(customerSelected)) {
							customer = (Customer) users.get(i);
							break;
						}
					}
				}

				if (customer != null) {
					System.out.printf("Customer %s Found!", customer.name);
					
					while(true){
						System.out.println("Please enter the product to remove or type exit to quit");
						String productName = userInput.nextLine();
						Product product = null;
						String message = "Product Not Found!";
						
						for (int i = 0; i < products.size(); i++) {
							if (products.get(i).getProductID().equalsIgnoreCase(productName)) {
								product = products.get(i);
								if(!customer.getSales().getAllProducts().contains(product)){
									message = "Product not found in customer's cart!";
									product = null;
								}
								break;
							}
						}
						if (product != null) {
							System.out.printf("Product %s Found! ", productName);
							while(true){
								System.out.println("Please enter the amount to remove or 0 to quit (default:1)");
								String amount = userInput.nextLine();
								if (amount.isEmpty()) {
									if(!customer.getSales().removeProduct(product)){
										System.out.printf("Not enough quantity to remove! Remaining quantity :%d%n",customer.getSales().checkQuantity(product));
										continue;
									}
								}else if(Integer.parseInt(amount) == 0){
									break;
								}else{
									if(!customer.getSales().removeProduct(product, Integer.parseInt(amount))){
										System.out.printf("Not enough quantity to remove! Remaining quantity :%d%n",customer.getSales().checkQuantity(product));
										continue;
									}
								}
								System.out.printf("Product successfully removed! Remaining quantity :%d%n",customer.getSales().checkQuantity(product));
								break;
							}
						}else if(productName.equals("exit")){
							break;
						}else{
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
					System.out.printf("Customer %s Found! Cancelling transaction%n", customer.name);
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

	// This method creates a menu list where the user selects their option by
	// entering a letter, and it will take them to that option.
	public void wareHouseStaffMenuFunctions() {
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

	public void listWareHouseStaffInformation() {

		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** LIST OF WAREHOUSESTAFF INFORMATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) instanceof WareHouseStaff) {
				System.out.println(users.get(i).getDetails());
				return;
			}
		}

	}

	public void saveProductData() {
		try {

			PrintWriter outputStream = new PrintWriter(new FileOutputStream(new File("ProductData.txt"), false));

			for (int j = 0; j < products.size(); j++) {
				outputStream.println(products.get(j).saveGetDetails());

			}
			outputStream.flush();

			outputStream.close();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	// this method reads from the text file on start up, and recreates the
	// objects
	public void readProductData() {

		try {
			// when the program is run, it will load the text file
			// "ProductData.txt", however if it fails to find the text file, it
			// will catch an error and try to search for a backup file and load
			// that instead, if that also fails, it will prompt the user if they
			// want to load sample data hard coded in the program
			Scanner input = new Scanner("ProductData.txt");
			File file = new File(input.nextLine());
			input = new Scanner(file);

			System.out.println("ProductData.txt file successfully loaded \n");

			// A while-loop is used to read every single line in the text file
			// until there is no more lines
			while (input.hasNextLine()) {
				// This takes the string of each line in the text file and
				// stores it in the String array productInformation

				String line = input.nextLine();
				// A delimiter ":" is used so that it stores lines separated by
				// a colon into the correct String
				String[] productInformation = line.split(":");

				// This checks if the first word in the text file is a PRODUCT,
				// if it is "PRODUCT", then it will create a product object

				if (productInformation[0].equals("PRODUCT")) {

					// This stores the information in the text-file into the
					// productionInformation array which is then used to create
					// the
					// exact object the last time the program exited
					String productID = productInformation[1];
					String quantity = productInformation[2];
					String price = productInformation[3];

					// create product object
					products.add(new Product(productID, Integer.parseInt(quantity), Double.parseDouble(price)));

				}
			}

			input.close();

			// As stated above, if the file "ProductData.txt"
			// is not found, the user will be prompt to enter (Y/N) on
			// whether they want to store sample data hard coded in the
			// program
		} catch (FileNotFoundException ExceptionNoFile) {
			Scanner noFileFound = new Scanner(System.in);
			System.out.println("No ProductData.text file was found");
			System.out.println("Do you want to load the program with sample data? (Y/N)");

			String userYesOrNo = noFileFound.nextLine();

			// If the user enters "Y", hard coded sample data will be loaded
			// into the vehicles ArrayList and return to the main menu
			if (userYesOrNo.equalsIgnoreCase("Y") || userYesOrNo.equalsIgnoreCase("yes")) {
				products.add(new Product("Apple", 25, 23.34));
				products.add(new Product("Pizza", 4, 10.50));
				products.add(new Product("Chips", 120, 3.20));

				System.out.println("Sample data succesfully loaded \n");

				// if the user enters "N", then no sample data will be
				// loaded and the program will return to the main menu
			} else if (userYesOrNo.equalsIgnoreCase("N") || userYesOrNo.equalsIgnoreCase("no")) {
				System.out.println("No sample data loaded \n");

				// if the user enters something other than (Y/N) or yes or
				// no, the user will receive a message stating invalid
				// option and no sample data will be loaded
			} else {
				System.out.println("Invalid option. Sample data will not be loaded \n");
			}

		}
	}

	public void saveUserData() {
		try {

			PrintWriter outputStream = new PrintWriter(new FileOutputStream(new File("UserData.txt"), false));

			for (int j = 0; j < users.size(); j++) {
				outputStream.println(users.get(j).saveGetDetails());

			}
			outputStream.flush();

			outputStream.close();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

//	public void readUserData() {
//
//		try {
//
//			Scanner input = new Scanner("UserData.txt");
//			File file = new File(input.nextLine());
//			input = new Scanner(file);
//
//			System.out.println("UserData.txt file successfully loaded \n");
//
//			while (input.hasNextLine()) {
//
//				String line = input.nextLine();
//				// A delimiter ":" is used so that it stores lines separated by
//				// a colon into the correct String
//				String[] userInformation = line.split(":");
//
//				// This checks if the first word in the text file is a PRODUCT,
//				// if it is "PRODUCT", then it will create a product object
//
//				if (userInformation[0].equals("CUSTOMER")) {
//
//					// This stores the information in the text-file into the
//					// productionInformation array which is then used to create
//					// the
//					// exact object the last time the program exited
//					String name = userInformation[1];
//					String email = userInformation[2];
//					String password = userInformation[3];
//					String phone = userInformation[4];
//					String creditCardID = userInformation[6];
//					String LoyaltyPoints = userInformation[5];
//
//					// create customer object
//					users.add(new Customer(name, email, password, phone,
//							new CreditCard(Double.parseDouble(LoyaltyPoints), creditCardID)));
//
//				} else if (userInformation[0].equals("WAREHOUSESTAFF")) {
//
//					String name = userInformation[1];
//					String email = userInformation[2];
//					String password = userInformation[3];
//					String phone = userInformation[4];
//
//					// create warehousestaff object
//					users.add(new WareHouseStaff(name, email, password, phone));
//
//				} else if (userInformation[0].equals("SALESSTAFF")) {
//
//					String name = userInformation[1];
//					String email = userInformation[2];
//					String password = userInformation[3];
//					String phone = userInformation[4];
//
//					// create salesstaff object
//					users.add(new SalesStaff(name, email, password, phone));
//
//				} else if (userInformation[0].equals("MANAGER")) {
//
//					String name = userInformation[1];
//					String email = userInformation[2];
//					String password = userInformation[3];
//					String phone = userInformation[4];
//
//					// create manager object
//					users.add(new Manager(name, email, password, phone));
//
//				}
//			}
//
//			input.close();
//
//		} catch (FileNotFoundException ExceptionNoFile) {
//			Scanner noFileFound = new Scanner(System.in);
//			System.out.println("No UserData.text file was found");
//			System.out.println("Do you want to load the program with sample data? (Y/N)");
//
//			String userYesOrNo = noFileFound.nextLine();
//
//			if (userYesOrNo.equalsIgnoreCase("Y") || userYesOrNo.equalsIgnoreCase("yes")) {
//				users.add(new Customer("Customer", "customer@gmail.com", "customer", "0479364758",
//						new CreditCard(0, "123")));
//				users.add(new WareHouseStaff("WareHouseStaff", "warehousestaff@gmail.com", "warehousestaff",
//						"0498263842"));
//				users.add(new SalesStaff("SalesStaff", "salesstaff@gmail.com", "salesstaff", "0473927465"));
//				users.add(new Manager("Manager", "manager@gmail.com", "manager", "0475860345"));
//
//				System.out.println("Sample data succesfully loaded \n");
//
//				// if the user enters "N", then no sample data will be
//				// loaded and the program will return to the main menu
//			} else if (userYesOrNo.equalsIgnoreCase("N") || userYesOrNo.equalsIgnoreCase("no")) {
//				System.out.println("No sample data loaded \n");
//
//				// if the user enters something other than (Y/N) or yes or
//				// no, the user will receive a message stating invalid
//				// option and no sample data will be loaded
//			} else {
//				System.out.println("Invalid option. Sample data will not be loaded \n");
//			}
//
//		}
//	}
}
