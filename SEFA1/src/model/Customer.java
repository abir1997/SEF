package model;

import java.util.ArrayList;

public class Customer extends User{

	private CustomerCard card;
	private ArrayList<Sales> previousTransactions;
	private Sales sales;
	
	public Customer(String name, int id, String pwd, CustomerCard card) {
		super(name, id, pwd);
		this.card = card;
		sales = new Sales();
	}
	
	public void payment() {
		double usedPts = 0;
		while(sales)
	}

	public Sales getSales() {
		return sales;
	}
}
