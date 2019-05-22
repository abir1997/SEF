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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditCard == null) ? 0 : creditCard.hashCode());
		long temp;
		temp = Double.doubleToLongBits(loyaltyPts);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerCard other = (CustomerCard) obj;
		if (creditCard == null) {
			if (other.creditCard != null)
				return false;
		} else if (!creditCard.equals(other.creditCard))
			return false;
		if (Double.doubleToLongBits(loyaltyPts) != Double.doubleToLongBits(other.loyaltyPts))
			return false;
		return true;
	}
	
	
}
