import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesTest {
	Sales test;
	Product testProduct1 = new Product("test", 10, 10.50);
	Product testProduct2 = new Product("test1", 5, 7.35);
	Product testProduct3 = new Product("test2", 8, 15.80);
	CreditCard card = new CreditCard(10, "1");
	
	@Before
	public void init(){
		SuperMarketSystem.products.clear();
		SuperMarketSystem.products.add(testProduct1);
		SuperMarketSystem.products.add(testProduct2);
		SuperMarketSystem.products.add(testProduct3);
		test = new Sales();
	}
	
	@Test
	public void insertProductTest() {
		test.addProduct(testProduct1);
		assertEquals(1, test.getAllProducts().size());
		test.addProduct(testProduct1, 10);
		assertEquals(1, test.getAllProducts().size());
		test.addProduct(testProduct2);
		assertEquals(2, test.getAllProducts().size());
	}
	
	@Test
	public void removeProductTest() {
		test.addProduct(testProduct1);
		test.addProduct(testProduct2);
		assertEquals(2, test.getAllProducts().size());
		assertTrue(test.removeProduct(testProduct1));
		assertEquals(1, test.getAllProducts().size());
		assertFalse(test.removeProduct(testProduct1));
		test.addProduct(testProduct2, 2);
		test.removeProduct(testProduct2);
		assertEquals(1, test.getAllProducts().size());
		assertFalse(test.removeProduct(testProduct2,3));
		test.removeProduct(testProduct2, 2);
		assertEquals(0, test.getAllProducts().size());
		assertFalse(test.removeProduct(testProduct3));
	}
	
	@Test
	public void makePaymentTest() {
		test.addProduct(testProduct1);
		test.addProduct(testProduct2);
		assertEquals(2, test.getAllProducts().size());
		test.makePayment(test.getTotal());
		assertEquals(1.79,test.getPoints(),0);
		assertEquals(10,card.getLoyaltyPoints(),0);
		test.claimPoints(card);
		assertEquals(11.79,card.getLoyaltyPoints(),0);
		assertEquals(0,test.getPoints(),0);
	}
	
	@Test
	public void quantityTest() {
		assertEquals(10, SuperMarketSystem.products.get(0).getQuantity());
		test.addProduct(testProduct1, 5);
		test.makePayment(test.getTotal());
		assertEquals(5, SuperMarketSystem.products.get(0).getQuantity());
		test.addProduct(testProduct1, 6);
		assertFalse(test.makePayment(test.getTotal()));
		assertEquals(5, SuperMarketSystem.products.get(0).getQuantity());		
	}

}
