package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import menu.SuperMarketSystem;
import model.Customer;
import model.CustomerCard;
import model.Product;
import system.DataAccess;

public class CustomerTest {

	private Customer customer;
	final Product p1 = new Product("p1", 100, 100);
	final Product p2 = new Product("p2", 200, 50);
	final Product p3 = new Product("p3", 400, 25);
	final Product p4 = new Product("p4", 800, 12);
	
	@Before
	public void beforTest() {
		SuperMarketSystem.products.put("p1", p1);
		SuperMarketSystem.products.put("p2", p2);
		SuperMarketSystem.products.put("p3", p3);
		SuperMarketSystem.products.put("p4", p4);
		
		CustomerCard creditCard = new CustomerCard(100, "CreditCard"); 
		customer = new Customer("C1",1,"pass",creditCard);
		
		customer.pickUp(p1);
		customer.pickUp(p2);
		customer.pickUp(p2);
	}
	
	@Test
	public void purchaseTest() {
		int p1Qty = DataAccess.calcAProductsQty("p1");		
		int p2Qty = DataAccess.calcAProductsQty("p2");
		int p3Qty = DataAccess.calcAProductsQty("p3");
		int p4Qty = DataAccess.calcAProductsQty("p4");
		customer.purchase("p1",1);
		assertEquals(p1Qty -1 , DataAccess.calcAProductsQty("p1"));
		customer.purchase("p2",2);
		assertEquals(p2Qty -2 , DataAccess.calcAProductsQty("p2"));
		assertEquals(p3Qty, DataAccess.calcAProductsQty("p3"));
		assertEquals(p4Qty, DataAccess.calcAProductsQty("p4"));
	}
}
