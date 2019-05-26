package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import model.Customer;
import model.CustomerCard;
import model.Product;

public class CustomerTest {

	private Customer customer;
	final Product p1 = new Product("p1", "Dew", 100, 100, 100, 200);
	final Product p2 = new Product("p2", "Coke", 100, 100, 100, 200);
	final Product p3 = new Product("p3", "Fizz", 100, 100, 100, 200);
	final Product p4 = new Product("p4", "Apple", 100, 100, 100, 200);
	final Product p5 = new Product("p5", "Jar", 100, 100, 100, 200);
	CustomerCard card = new CustomerCard(100, "CreditCard");
	
	@Before
	public void beforTest() {
		ProductDataAccess.products.put("p1", p1);
		ProductDataAccess.products.put("p2", p2);
		ProductDataAccess.products.put("p3", p3);
		ProductDataAccess.products.put("p4", p4);
		 
		// Customer created with a 100 loyalty points.
		customer = new Customer("C1",1,"pass",card);
		
		customer.addToCart("p1",1);
		customer.addToCart("p2",1);
		customer.addToCart("p3",1);
	}
	
	@Test
	public void addToCartTest() {
		assertTrue(customer.addToCart("p1", 2));
		
		// Adding product over warehouse qty
		assertFalse(customer.addToCart("p1", 5000));
		// Adding product not in map
		assertFalse(customer.addToCart("p5", 2));
	}
	
	@Test
	//TODO Not sure about this test
	public void checkOutTest() {
		double n = (card.getLoyaltyPts()/20);
		double discount = 5 * n;
		assertEquals(customer.checkout(),600-discount);
	}
	
//	@Test
//	public void purchaseTest() {
//		int p1Qty = SupplierDataAccess.getProductsQty("p1");		
//		int p2Qty = SupplierDataAccess.getProductsQty("p2");
//		int p3Qty = SupplierDataAccess.getProductsQty("p3");
//		int p4Qty = SupplierDataAccess.getProductsQty("p4");
//		customer.purchase("p1",1);
//		assertEquals(p1Qty -1 , SupplierDataAccess.getProductsQty("p1"));
//		customer.purchase("p2",2);
//		assertEquals(p2Qty -2 , SupplierDataAccess.getProductsQty("p2"));
//		assertEquals(p3Qty, SupplierDataAccess.getProductsQty("p3"));
//		assertEquals(p4Qty, SupplierDataAccess.getProductsQty("p4"));
//	}
}
