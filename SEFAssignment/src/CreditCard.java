
public class CreditCard {

	
	
	private double loyaltyPoints;
	private String creditCardID;
	
	public  CreditCard (double loyaltyPoints,String creditCardID )
	{	
		this.loyaltyPoints = loyaltyPoints;
		this.creditCardID = creditCardID;	
	}
	
	public double getBalance() {
		
		return this.loyaltyPoints;
		
	}
	public String getCreditCardID() {
		
		return this.creditCardID;
	}
	
	
	public void addLoyaltyPoints(double amount) {
		this.loyaltyPoints+= amount;
	}
	
	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}
	
	public void deductLoyaltyPoints(double amount) {
		this.loyaltyPoints-= amount;
	}
	
}
