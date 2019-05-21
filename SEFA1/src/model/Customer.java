package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import menu.SuperMarketSystem;

public class Customer extends User {

	private CustomerCard card;
	private ArrayList<Sales> previousTransactions;
	private Sales sales;

	public Customer(String name, int id, String pwd, CustomerCard card) {
		super(name, id, pwd);
		this.card = card;
		sales = new Sales();
	}

	public void payment() {
		double usedPoints = 0;
		while (sales.getTotal() >= 5 && card.getBalance() >= 20) { // if the payment amount more than 5 and there are
																	// more than 20 point in the account, it will get
																	// the discount
			sales.deduct(5);
			card.deductLoyaltyPoints(20);
			usedPoints += 20;
		}
		System.out.println(usedPoints + " Loyalty Points used.");
		System.out.println("the amount you need to pay is " + sales.getTotal());
		sales.makePayment(sales.getTotal());
		System.out.println(sales.getPts() + " loyalty Points added to your account.");
		sales.claimPts(card);
		previousTransactions.add(sales);
		sales = new Sales();
	}

	public Sales getSales() {
		return sales;
	}

	public void purchase() {
		Scanner userInput1 = new Scanner(System.in);
		System.out.println("Enter productId you want to buy: ");
		String productID = userInput1.nextLine();

		if (SuperMarketSystem.products.containsKey(productID)) {
			System.out.println("Enter amount of product you want to buy: ");
			int amount = userInput1.nextInt();
			if (amount <= SuperMarketSystem.products.get(productID).getQuantity()) {
				while (amount > 0) {
					pickUp(SuperMarketSystem.products.get(productID));
					amount -= 1;
				}
				calAmount();
				payment();
			} else {
				System.out.println("There is not enough product. ");
			}

		} else {
			System.out.println("this productID is not exist");
		}

	}

	private double calAmount() {
		return sales.getTotal();
	}

	public void pickUp(Product product) {
		sales.addProduct(product);
	}

	private void pickUp(Product product, int quantity) {
		sales.addProduct(product, quantity);
	}

	public void listProductInformation() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** LIST OF PRODUCTS INFORMATION ***");
		System.out.println("------------------------------------------------------------------------\n");

		for (Map.Entry<String, Product> item : SuperMarketSystem.products.entrySet()) {
			System.out.println(item.toString());
		}
	}

	public void checkPrice() {
		boolean check = false;
		Scanner userInput1 = new Scanner(System.in);
		System.out.println("Enter productId you want to check price: ");
		String productID = userInput1.nextLine();
		for (int i = 0; i < SuperMarketSystem.products.size(); i++) {
			if (SuperMarketSystem.products.get(productID).getProductID().equals(productID)) {
				System.out.println("the price of " + SuperMarketSystem.products.get(i).getProductID() + " is "
						+ SuperMarketSystem.products.get(i).getPrice());
				check = true;
				break;
			}
		}
		if (check == false) {
			System.out.println("this product is not exist");
		}
		check = false;
	}
}
