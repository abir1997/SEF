// Peter Class

import java.awt.List;
import java.util.*;

public class Customer extends User{
private CreditCard card;
private ArrayList<Sales> previousTransactions;
private Sales sales;

	
	public Customer(String name, String email, String password, String phone, CreditCard creditCard)
	{
		super(name, email, password, phone);
		this.card = creditCard;
		previousTransactions = new ArrayList<Sales>();
		sales = new Sales();
	}
	
	public String getName()
	{
		return super.getName();
	}
	
	public String getEmail()
	{
		return super.getEmail();
	}
	public String getPassword()
	{
		return super.getPassword();
	}
	public String getPhone()
	{
		return super.getPhone();
	}
	
	
	public String getDetails() {

	return super.getDetails();

	}
	
	public CreditCard getCard(){
		return card;
	}
	
public String saveGetDetails() {
		String firstLine = name;
		String secondLine = email;
		String thirdLine = password;
		String fourthLine = phone;
		Double fifthLine =card.getLoyaltyPoints();
		String sixthLine = card.getCreditCardID();
		
		return ("CUSTOMER" + ":" + super.saveGetDetails() + ":" + fifthLine  + ":" + sixthLine);
}

//this is a method to calculate the price customer should pay and the point they could get in this payment
public void payment(){
	double usedPoints = 0;
	while(sales.getTotal()>=5 && card.getBalance()>=20){	    //if the payment amount more than 5 and there are more than 20 point in the account, it will get the discount 
	sales.deduct(5);
	card.deductLoyaltyPoints(20);
	usedPoints += 20;
	}
	System.out.println( usedPoints + " Loyalty Points used.");
	System.out.println("the amount you need to pay is "+ sales.getTotal());
	sales.makePayment(sales.getTotal());
	System.out.println( sales.getPoints() +" loyalty Points added to your account.");
	sales.claimPoints(card);
	previousTransactions.add(sales);
	sales = new Sales();
}

//this is a method to add product into the shopping cart
public void pickUp(Product product){	
	sales.addProduct(product);
}

public void pickUp(Product product, int quantity){	
	sales.addProduct(product, quantity);
}

public Sales getSales(){
	return sales;
}

//this is a method to calculate the price of the product in the shopping cart
public double calAmount (){
	return sales.getTotal();
}

public double checkCreditPoint(){
	return card.getBalance();
}

public void listProductInformation() {

	System.out.println("\n------------------------------------------------------------------------");
	System.out.println("*** LIST OF PRODUCTS INFORMATION ***");
	System.out.println("------------------------------------------------------------------------\n");

	for (int i = 0; i < SuperMarketSystem.products.size(); i++) {
		System.out.println(SuperMarketSystem.products.get(i).getDetails());
	}

}

	
public Collection<Sales> getPreviousTransacitons(){
	return Collections.unmodifiableList(previousTransactions);
}

public void purchase(){
	
	Scanner userInput1 = new Scanner(System.in);
	System.out.println("Enter productId you want to buy: ");
	String Productid = userInput1.nextLine();
	

	for (int i = 0; i < SuperMarketSystem.products.size(); i++) {

		if (SuperMarketSystem.products.get(i).getProductID().equals(Productid)) {
			System.out.println("Enter amount of product you want to buy: ");
			int amount = userInput1.nextInt();
			if (amount <= SuperMarketSystem.products.get(i).getQuantity()) {						
				while (amount > 0) {
					pickUp(SuperMarketSystem.products.get(i));
					amount -= 1;
				}
				calAmount();
				payment();
				break;
			} else {
				System.out.println("There is not enough product. ");
				break;
			}

		}
		else{System.out.println("this productID is not exist");
		break;}
	}

	
}
boolean check;
public void checkPrice(){
	Scanner userInput1 = new Scanner(System.in);
	System.out.println("Enter productId you want to check price: ");
	String Productid = userInput1.nextLine();
	for (int i = 0; i < SuperMarketSystem.products.size(); i++) {
		if (SuperMarketSystem.products.get(i).getProductID().equals(Productid)) {
			System.out.println(
					"the price of " +SuperMarketSystem. products.get(i).getProductID() + " is " + SuperMarketSystem.products.get(i).getPrice());
		    check=true;
			break;
		}
	}
	if(check==false){
	System.out.println("this product is not exist");
	}
	check=false;
}

}
