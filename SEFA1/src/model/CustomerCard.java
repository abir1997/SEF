package model;

import java.io.Serializable;

public class CustomerCard implements Serializable{

	private static final long serialVersionUID = -8451023219931180667L;
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
