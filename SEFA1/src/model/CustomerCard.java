package model;

public class CustomerCard {

	private double loyaltyPts;
	private String creditCard;

	public CustomerCard(double loyaltyPts, String creditCard) {
		this.loyaltyPts = loyaltyPts;
		this.creditCard = creditCard;
	}

	public double getLoyaltyPts() {
		return loyaltyPts;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void addLoyaltyPts(double i) {
		loyaltyPts += i;
	}

	public void deductLoyaltyPoints(double i) {
		this.loyaltyPts -= i;
	}

	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
}
