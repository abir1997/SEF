package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.ProductNotFoundException;
import model.Customer;
import model.CustomerCard;
import model.Product;
import model.Sale;
import model.SalesLineItem;

public class SalesTest {

	private Sale sales;
	final private Product p1 = new Product("p1", "Orange", 50, 100, 100, 20);
	final private Product p2 = new Product("p2", "Mango", 30, 100, 100, 20);
	final private Product p3 = new Product("p3", "Pear", 20, 100, 100, 40);
	final private Product p4 = new Product("p4", "Horse", 20, 100, 100, 40);
	CustomerCard card = new CustomerCard(20,"XYZ");
	final Customer cust = new Customer("Abir", 1, "pwd", card);

	
	@Before
	public void beforTest() {
		
		sales = new Sale();
		SalesLineItem sl = new SalesLineItem(p1, 1);
		SalesLineItem sl1 = new SalesLineItem(p2, 2);
		SalesLineItem sl2 = new SalesLineItem(p3, 2);

		sales.getSaleLineItems().add(sl);
		sales.getSaleLineItems().add(sl1);
		sales.getSaleLineItems().add(sl2);
		// Total 5 items in cart.
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
		assertEquals(140,sales.calcTotalBaseCostWithDiscount());
	}
	

	@Test
	public void calcTotalBaseCostDiscountedTest() {
		//Test sale price is computed correctly based on sale line items (3)
		//20 + 40 + 80 + (11 * 40 * 85%) = 514 
		SalesLineItem sl3 = new SalesLineItem(p4, 11);
		sales.getSaleLineItems().add(sl3);
		p4.addDiscount(20, 18);
		p4.addDiscount(5, 5);
		p4.addDiscount(10, 15); //this discount should be applied
		p4.addDiscount(30, 30);
		p4.addDiscount(8, 8);

		//Test sale price is computed correctly for items offering discounts for bulk sale(5)
		assertEquals(514,sales.calcTotalBaseCostWithDiscount());
	}

	@Test
	public void removeProductTest() throws ProductNotFoundException {
		//reduce amount
		sales.removeProduct(p2);
		assertEquals(2, sales.getSaleLineItems().size());
		
		//removing product not in salesLineItem
		assertFalse(sales.removeProduct(p4));
		
	}
	
	@Test
	public void decreaseProductTest() {
		// decreasing a product qty
		sales.decreaseProduct(p3, 1);
		assertEquals(4,sales.totalItems());
	}


	@Test
	public void totalItemsTest() {
		assertEquals(5,sales.totalItems());
	}
	
	@Test
	public void checkSetQuantityTest() throws ProductNotFoundException {
		assertEquals(2, sales.checkQuantity(p3));
	}

	@Test
	public void removeAllProductsTest() {
		sales.removeAllProducts();
		assertEquals(0, sales.getSaleLineItems().size());
	}

	
}
