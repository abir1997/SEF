package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import menu.SuperMarketSystem;
import model.CustomerCard;
import model.Product;
import model.Sales;
import model.SalesLineItem;

public class SalesTest {

	private Sales sales;
	final Product p1 = new Product("p1", 100, 100);
	final Product p2 = new Product("p2", 200, 50);
	final Product p3 = new Product("p3", 400, 25);

	@Before
	public void beforTest() {
		SuperMarketSystem.products.put("p1",p1 );
		SuperMarketSystem.products.put("p2",p2 );
		SuperMarketSystem.products.put("p3",p3 );
		
		sales = new Sales();
		sales.addProduct(p1, 2);
		sales.addProduct(p2, 4);
	}
	
	@Test
	public void claimPtsTest() {
		CustomerCard card = new CustomerCard(1000, "ABC123");
		sales.claimPts(card);


		assertEquals(1000, card.getLoyaltyPts());
	}
	
	@Test
	public void makePaymentTest() {
		//		products available
		assertTrue(sales.makePayment(200));

		//		not enough products available
		sales.addProduct(p1, 1000);
		assertFalse(sales.makePayment(100));
	}
	

	@Test
	public void removeProductTest() {
		
		//reduce amount to 1
		sales.removeProduct(p1);
		assertEquals(2, sales.getAllProducts().size());

		//reduce amount to 0 and remove the product
		sales.removeProduct(p1);
		assertEquals(1, sales.getAllProducts().size());
	}


	@Test
	public void removeProductTest2() {
		//reduce amount to 0 and remove the product
		sales.removeProduct(p1,2 );
		assertEquals(1, sales.getAllProducts().size());

	}
	
	@Test
	public void checkQuantityTest() {
		assertEquals(2, sales.checkQuantity(p1));
	}

	@Test
	public void removeAllProductTest() {
		sales.removeAllProduct();
		assertEquals(0, sales.getAllProducts().size());
	}

	@Test
	public void addProductTest() {
		sales.removeAllProduct();
		sales.addProduct(p1);
		assertEquals(1, sales.getAllProducts().size());

		//adding of the same product just adds to amount
		sales.addProduct(p1);
		assertEquals(1, sales.getAllProducts().size());

	}
	
	
	@Test
	public void addProduct2Test() {
		sales.addProduct(p3, 8);
		assertEquals(3, sales.getAllProducts().size());
	}
	
	
	@Test
	public void deductTest() {
		double total = sales.getTotal();
		sales.deduct(10);
		assertEquals(total - 10, sales.getTotal());
	}
	
	
	@Test
	public void discountTest() {
		double total = sales.getTotal();
		sales.discount(10);
		assertEquals(total - (total * 10 / 100), sales.getTotal());

	}
	
}
