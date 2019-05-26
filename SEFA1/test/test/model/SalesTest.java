package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.ProductNotFoundException;
import model.CustomerCard;
import model.Product;
import model.Sale;

public class SalesTest {

	private Sale sales;
	final Product p1 = new Product("p1", "Orange", 50, 100, 100, 20);
	final Product p2 = new Product("p2", "Mango", 30, 100, 100, 20);
	final Product p3 = new Product("p3", "Pear", 20, 100, 100, 40);
	final Product p4 = new Product("p4", "Horse", 20, 100, 100, 40);
	CustomerCard card = new CustomerCard(20,"XYZ");


	
	@Before
	public void beforTest() {
		
	}
	
//	@Test
//	public void claimPtsTest() {
//		CustomerCard card = new CustomerCard(1000, "ABC123");
//		sales.claimPts(card);
//
//		assertEquals(1000, card.getLoyaltyPts());
//	}
	
	@Test
	public void calcTotalBaseCostTest() {
		//20 + 40 + 80 = 140
		assertEquals(140,sales.calcTotalBaseCost());
	}
	
	//Test Maximum discounts are automatically given based on current loyalty points at 
	//the end of transaction
	@Test
	public void calcCheckoutCostTest() {
		//$5 discount for every 20pts
		int n = (int) (card.getLoyaltyPts()/20);
		int discount = 5 * n;
		assertEquals(60-discount,sales.calcCheckoutCost());
	}
	
//	@Test
//	public void makePaymentTest() {
//		//		products available
//		assertTrue(sales.makePayment(200));
//
//		//		not enough products available
//		sales.addProduct(p1, 1000);
//		assertFalse(sales.makePayment(100));
//	}
	

	@Test
	public void removeProductTest() {
		
		//reduce amount to 1
		sales.removeProduct(p2);
		assertEquals(4, sales.getSaleLineItems().size());
		
		//removing product not in salesLineItem
		assertFalse(sales.removeProduct(p4));
		
	}


//	@Test
//	public void removeProductTest2() {
//		//reduce amount to 0 and remove the product
//		sales.removeProduct(p1,2 );
//		assertEquals(1, sales.getSaleLineItems().size());
//
//	}
	
	@Test
	public void checkQuantityTest() throws ProductNotFoundException {
		assertEquals(2, sales.checkQuantity(p3));
	}


	
	
//	@Test
//	public void addProduct2Test() {
//		sales.addProduct(p3, 8);
//		assertEquals(3, sales.getSaleLineItems().size());
//	}
//	
//	
//	@Test
//	public void deductTest() {
//		double total = sales.getTotal();
//		sales.deduct(10);
//		assertEquals(total - 10, sales.getTotal());
//	}
//	
//	
//	@Test
//	public void discountTest() {
//		double total = sales.getTotal();
//		sales.discount(10);
//		assertEquals(total - (total * 10 / 100), sales.getTotal());
//
//	}
	
}
