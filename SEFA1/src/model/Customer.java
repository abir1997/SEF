package model;

import java.util.ArrayList;

public class Customer extends User{

	private CustomerCard card;
	private ArrayList<Sales> previousTransactions;
	private Sales sales;
	
	public Customer(String name, int id, String pwd) {
		super(name, id, pwd);
		sales = new Sales();
	}
	
	public void payment() {
		double usedPts = 0;
		while(sales)
	}
}
