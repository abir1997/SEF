import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesStaffTest {
	CreditCard card = new CreditCard(10, "1");
	SalesStaff staff = new SalesStaff("Jeff", "s@test.com", "test", "0475627462");
	Customer customer = new Customer("Jack", "c@test.com", "test", "04716283732", card);
	Product testProduct1 = new Product("test", 15, 10.50);
	Product testProduct2 = new Product("test1", 10, 7.35);
	
	@Before
	public void init(){
		customer.pickUp(testProduct1, 10);
		customer.pickUp(testProduct2, 5);
	}
	
	@Test
	public void removeProductTest() {
		assertEquals(10, customer.getSales().checkQuantity(testProduct1));
		staff.removeProduct(customer, testProduct1);
		assertEquals(9, customer.getSales().checkQuantity(testProduct1));
		assertFalse(staff.removeProduct(customer, testProduct1, 10));
		assertEquals(9, customer.getSales().checkQuantity(testProduct1));
	}
	
	@Test
	public void cancelTransactionTest(){
		assertEquals(2, customer.getSales().getAllProducts().size());
		staff.cancelTransaction(customer);
		assertEquals(0, customer.getSales().getAllProducts().size());
	}

}
