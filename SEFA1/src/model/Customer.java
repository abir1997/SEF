package model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

	private CustomerCard card;
	private CreditCard creditCard;
	private List<Sale> previousSales = new ArrayList<Sale>();
	private Sale sale;
	private String postCode;

	public Customer(String name, int id, String pwd, CustomerCard card) {
		super(name, id, pwd);
		this.card = card;
		sale = new Sale();
	}

	
	public Sale getSale() {
		return sale;
	}

	public CustomerCard getCard() {
		return card;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void emptyCart() {
		sale.emptyCart();
	}


	public void addToCart(String productID, int amount) {
		throw new RuntimeException("Not implemented");
		
	}
	

//	public void payment() {
//	double usedPoints = 0;
//	while (sale.getTotal() >= 5 && card.getBalance() >= 20) { // if the payment amount more than 5 and there are
//																// more than 20 point in the account, it will get
//																// the discount
//		sale.deduct(5);
//		card.deductLoyaltyPoints(20);
//		usedPoints += 20;
//	}
//	System.out.println(usedPoints + " Loyalty Points used.");
//	System.out.println("the amount you need to pay is " + sale.getTotal());
//	sale.makePayment(sale.getTotal());
//	System.out.println(sale.getPts() + " loyalty Points added to your account.");
//	sale.claimPts(card);
//	previousSales.add(sale);
//	sale = new Sale();
//}
	

//
//	public void purchase(String productID, int amount) {
//		while (amount > 0) {
//			pickUp(SuperMarketSystem.products.get(productID));
//			amount -= 1;
//		}
//		calAmount();
//		payment();
//	}

//	private double calAmount() {
//	return sale.getTotal();
//}

//public void pickUp(Product product) {
//	sale.addProduct(product);
//}

//private void pickUp(Product product, int quantity) {
//	sale.addProduct(product, quantity);
//}


}
