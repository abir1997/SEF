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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((creditCard == null) ? 0 : creditCard.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((previousSales == null) ? 0 : previousSales.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (creditCard == null) {
			if (other.creditCard != null)
				return false;
		} else if (!creditCard.equals(other.creditCard))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (previousSales == null) {
			if (other.previousSales != null)
				return false;
		} else if (!previousSales.equals(other.previousSales))
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		return true;
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
	
//	public void purchaseMenu() {
//		Scanner userInput1 = new Scanner(System.in);
//		System.out.println("Enter productId you want to buy: ");
//		String productID = userInput1.nextLine();
//
//		if (SuperMarketSystem.products.containsKey(productID)) {
//			System.out.println("Enter amount of product you want to buy: ");
//			int amount = userInput1.nextInt();
//			if (amount <= SuperMarketSystem.products.get(productID).getQuantity()) {
//				purchase(productID, amount);
//			} else {
//				System.out.println("There is not enough product. ");
//			}
//
//		} else {
//			System.out.println("this productID is not exist");
//		}
//	}
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

//public void checkPrice() {
//	boolean check = false;
//	Scanner userInput1 = new Scanner(System.in);
//	System.out.println("Enter productId you want to check price: ");
//	String productID = userInput1.nextLine();
//	for (int i = 0; i < SuperMarketSystem.products.size(); i++) {
//		if (SuperMarketSystem.products.get(productID).getProductID().equals(productID)) {
//			System.out.println("the price of " + SuperMarketSystem.products.get(i).getProductID() + " is "
//					+ SuperMarketSystem.products.get(i).getPrice());
//			check = true;
//			break;
//		}
//	}
//	if (check == false) {
//		System.out.println("this product is not exist");
//	}
//	check = false;
//}
}
