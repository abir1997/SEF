package model;

public class CustomerCard {

	private double loyaltyPts;


	public CustomerCard(double loyaltyPts, String creditCard) {
		this.loyaltyPts = loyaltyPts;
	}

	public double getLoyaltyPts() {
		return loyaltyPts;
	}


	public void addLoyaltyPts(double i) {
		loyaltyPts += i;
	}

	public void deductLoyaltyPoints(double i) {
		this.loyaltyPts -= i;
	}
}
