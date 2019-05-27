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
import static enums.MenuOptions.MM_REPORT_FAST_SELLING_PRODUCTS;
import static enums.MenuOptions.MM_RETURN_TO_LOGIN_SCREEN;
import static enums.MenuOptions.MM_UPDATE_PRODUCT;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import dataAccess.UserDataAccess;
import exception.ProductNotFoundException;
import main.Const;
import model.Customer;
import model.Manager;
import model.Product;
import model.ProductSale;
import model.Sale;
import model.SalesLineItem;
import system.Util;

public class ManagerMenu {
	private static Scanner userInput = new Scanner(System.in);

	public static void managerMenu(Manager mgr) {
		String optionSelected = "";
		
		while (!optionSelected.equalsIgnoreCase(MM_RETURN_TO_LOGIN_SCREEN.getKey())) {
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
			System.out.printf("%-30s %s\n", MM_REPORT_FAST_SELLING_PRODUCTS.getTxt(), MM_REPORT_FAST_SELLING_PRODUCTS.getKey());
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
			} else if (MM_LIST_SUPPLIER_DETAILS.getKey().equalsIgnoreCase(optionSelected)) {
				boolean includeProducts = false;
				System.out.println(SupplierDataAccess.listSupplierDetails(includeProducts));
			} else if (MM_OFFER_DISCOUNTS.getKey().equalsIgnoreCase(optionSelected)) {
				addBulkDiscount();
			} else if (MM_AUTO_REPLENISH_PURCHASE_ORDER.getKey().equalsIgnoreCase(optionSelected)) {
				autoReplenishPurchaseOrder();
			}else if (MM_GENERATE_SALES_REPORT.getKey().equalsIgnoreCase(optionSelected)) {
				generateSalesReport();
			} else if (MM_GENERATE_SUPPLY_REPORT.getKey().equalsIgnoreCase(optionSelected)) {
				
			} else if (MM_LIST_TOP_PRODUCTS.getKey().equalsIgnoreCase(optionSelected)) {
				
			} else if (MM_REPORT_FAST_SELLING_PRODUCTS.getKey().equalsIgnoreCase(optionSelected)) {
				generateFastSellingProductsReport();
			} else if (MM_RETURN_TO_LOGIN_SCREEN.getKey().equalsIgnoreCase(optionSelected)) {

				System.out.println("\nReturning to login sceen...\n");
//				new SuperMarketMenus().mainMenu();
			} else {
				System.out.println("\nInvalid input");
			}
		}
	}
	
	private static void generateSalesReport() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** Generate Sales Report  ***");
		System.out.println("------------------------------------------------------------------------\n");
		
		System.out.println("Enter start date: (dd-MM-yyyy)");
		LocalDate startDate = Util.readDate(userInput);

		System.out.println("Enter end date: (dd-MM-yyyy)");
		LocalDate endDate = Util.readDate(userInput);
		
		Map<String, ProductSale> aggregatedProducts = listProductsForSalesReport(startDate, endDate);
		
		System.out.println("*** PRODUCTS IN GIVEN PERIOD ***");
		for (ProductSale productSale : aggregatedProducts.values()) {
			System.out.printf("%10s: name: %30s, Total volume: %6d, Total Value: %8.2f\n",
					productSale.getProduct().getProductId(), productSale.getProduct().getName(),
					productSale.getTotalVolume(), productSale.getTotalValue());
		}
	}

	private static Map<String, ProductSale> listProductsForSalesReport(LocalDate startDate, LocalDate endDate) {
		// create the set of sales in for the given period
		Map<String, ProductSale> aggregatedProducts = new HashMap<>();
		
		Set<Customer> customers = UserDataAccess.getAllCustomers();

		//Created an aggregated hashMap for product's sales
		for (Customer customer : customers) {
			for (Sale sale : customer.getPreviousSales()) {
				if (startDate.isBefore(sale.getDateTime().toLocalDate())
						&& endDate.isAfter(sale.getDateTime().toLocalDate())) {
					for (SalesLineItem sli : sale.getSaleLineItems()) {
						
						String productId = sli.getProduct().getProductId();
						if (!aggregatedProducts.containsKey(productId)) {
							aggregatedProducts.put(productId, new ProductSale(sli.getProduct(), sli.getQuantity(),
									sli.getProduct().getPrice() * sli.getQuantity()));
						} else {
							ProductSale productSale = aggregatedProducts.get(productId);
							productSale.addTotalVolume(sli.getQuantity());
							productSale.addTotalValue(sli.getProduct().getPrice() * sli.getQuantity());
						}
					}
				}
			}
		}
		return aggregatedProducts;
	}
	private static void autoReplenishPurchaseOrder() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** Purchase Order for the following low stock items will be submitted  ***");
		System.out.println("------------------------------------------------------------------------\n");
		Set<Product> replenishableProducts = ProductDataAccess.findProductsBelowReplenish();
		for (Product product : replenishableProducts) {
			System.out.printf("%s %s\n", product.getProductId(), product.getName(), product.getOrderQty(), product.getReplenishLevel(), product.getWarehouseQuantity());
		}
	}

	public static void removeProduct() {
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
	} 

	public static void addProduct() {
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
			int quantity = Util.readPositiveInt(userInput);

			System.out.println("Enter replenish Level:");
			int replenishLvl = Util.readPositiveInt(userInput);

			System.out.println("Enter order Quantity:");
			int orderQty = Util.readPositiveInt(userInput);

			System.out.println("Enter product price:");
			double price = Util.readPositiveDouble(userInput);

			ProductDataAccess.addProduct(new Product(productID, name, quantity, replenishLvl, orderQty, price));

			System.out.println("New Product: " + productID + " sucessfully added to the system!\n");
		}
	}
	
	public static void updateProduct() {
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
			int quantity = Util.readPositiveInt(userInput);

			System.out.println("Enter replenish Level:");
			int replenishLvl = Util.readPositiveInt(userInput);

			System.out.println("Enter order Quantity:");
			int orderQty = Util.readPositiveInt(userInput);

			System.out.println("Enter product price:");
			double price = Util.readPositiveDouble(userInput);

			try {
				ProductDataAccess.updateProduct(productID, quantity, replenishLvl, orderQty, price);
				System.out.println("New Product: " + productID + " sucessfully added to the system!\n");
			} catch (ProductNotFoundException e) {
				System.out.println("Error - Product:  " + productID + " does not exist in the system!");
			}
		}
	}

	// method to offer specific discount percentages (4)
	public static void addBulkDiscount() {
		System.out.println("Please enter a percentage amount to set the discount to:" + "\n" + "15%" + "\n" + "20%"
				+ "\n" + "Custom Discount");
			
		System.out.println("Enter product ID: ");
		String productId = userInput.nextLine();

		if (!ProductDataAccess.products.containsKey(productId)) {
			System.out.println("Error - Product:  " + productId + " does not exist in the system!");
		}
		else {
			System.out.println("Enter product quantity for bulk discount:");
			int qty = Util.readPositiveInt(userInput);

			System.out.println("Enter discount percentage :");
			int percentage = Util.readPositiveInt(userInput);

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
	}
	
	/**
	 * Look for the sales in the past two weeks and report on top 10 selling products in volume and 10 top selling in value separately 
	 */
	public static void generateFastSellingProductsReport() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** FAST SELLING PRODUCTS ***");
		System.out.println("------------------------------------------------------------------------\n");
		Map<String, ProductSale> recentProducts = aggregatedSoldProducts();

		System.out.println("*** TOP 10 PRODUCTS BY VOLUME ***");
		List<ProductSale> productSaleSet = new ArrayList<>();
		productSaleSet.addAll(recentProducts.values());
		Collections.sort(productSaleSet, ProductSale.VOLUME_COMPARATOR);
		
		int count = 0;
		for (ProductSale productSale : productSaleSet) {
			if (count >= Const.TOP_SELLING_REPORT_NUMBER ) {
				break;
			}
			System.out.printf("%10s: name: %30s, Total volume: %6d, Total Value: %8.2f\n",
					productSale.getProduct().getProductId(), productSale.getProduct().getName(),
					productSale.getTotalVolume(), productSale.getTotalValue());
			count++;
		}
		
		
		System.out.println("\n*** TOP 10 PRODUCTS BY VALUE ***");
		productSaleSet.clear();
		productSaleSet.addAll(recentProducts.values());
		Collections.sort(productSaleSet, ProductSale.VALUE_COMPARATOR);
		count = 0;
		for (ProductSale productSale : productSaleSet) {
			if (count >= Const.TOP_SELLING_REPORT_NUMBER ) {
				break;
			}
			System.out.printf("%10s: name: %30s, Total volume: %6d, Total Value: %8.2f\n",
					productSale.getProduct().getProductId(), productSale.getProduct().getName(),
					productSale.getTotalVolume(), productSale.getTotalValue());
			count++;
		}
	}

	private static Map<String, ProductSale> aggregatedSoldProducts() {
		Set<Customer> customers = UserDataAccess.getAllCustomers();

		// create the set of sales in recent times
		Map<String, ProductSale> recentProducts = new HashMap<>();

		//Created an aggregated hashMap for product's sales
		for (Customer customer : customers) {
			for (Sale sale : customer.getPreviousSales()) {
				if (LocalDateTime.now().minusDays(Const.TOP_SELLING_REPORT_DAYS).isBefore(sale.getDateTime())) {
					for (SalesLineItem sli: sale.getSaleLineItems()) {
						
						String productId = sli.getProduct().getProductId();
						if (!recentProducts.containsKey(productId)) {
							recentProducts.put(productId, new ProductSale(sli.getProduct(), sli.getQuantity(),
									sli.getProduct().getPrice() * sli.getQuantity()));
						} else {
							ProductSale productSale = recentProducts.get(productId);
							productSale.addTotalVolume(sli.getQuantity());
							productSale.addTotalValue(sli.getProduct().getPrice() * sli.getQuantity());
						}
					}
				}
			}
		}
		return recentProducts;
	}
}