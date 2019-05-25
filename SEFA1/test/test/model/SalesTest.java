package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dataAccess.ProductDataAccess;
import model.CustomerCard;
import model.Product;
import model.Sale;
import model.SalesLineItem;

public class SalesTest {

	private Sale sales;
	final Product p1 = new Product("p1", 100, 100);
	final Product p2 = new Product("p2", 200, 50);
	final Product p3 = new Product("p3", 400, 25);

	@Before
	public void beforTest() {
		ProductDataAccess.products.clear();
		ProductDataAccess.products.put("p1",p1 );
		ProductDataAccess.products.put("p2",p2 );
		ProductDataAccess.products.put("p3",p3 );
		
		sales = new Sale();
		sales.addToCart(p1, 2);
		sales.addToCart(p2, 4);
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
		assertEquals(2, sales.getAllSaleLineItems().size());

		//reduce amount to 0 and remove the product
		sales.removeProduct(p1);
		assertEquals(1, sales.getAllSaleLineItems().size());
	}


	@Test
	public void removeProductTest2() {
		//reduce amount to 0 and remove the product
		sales.removeProduct(p1,2 );
		assertEquals(1, sales.getAllSaleLineItems().size());

	}
	
	@Test
	public void checkQuantityTest() {
		assertEquals(2, sales.checkQuantity(p1));
	}

	@Test
	public void removeAllProductTest() {
		sales.removeAllProduct();
		assertEquals(0, sales.getAllSaleLineItems().size());
	}

	@Test
	public void addProductTest() {
		sales.removeAllProduct();
		sales.addProduct(p1);
		assertEquals(1, sales.getAllSaleLineItems().size());

		//adding of the same product just adds to amount
		sales.addProduct(p1);
		assertEquals(1, sales.getAllSaleLineItems().size());

	}
	
	
	@Test
	public void addProduct2Test() {
		sales.addProduct(p3, 8);
		assertEquals(3, sales.getAllSaleLineItems().size());
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
