import static org.junit.Assert.*;

import org.junit.*;

public class SalesLineItemTest {
	
	SalesLineItem test;
	Product testProduct = new Product("testProduct", 10, 10.50);
	
	@Before
	public void init(){
		test = new SalesLineItem(testProduct, 5);
	}
	
	@Test
	public void getProductNameTest() {
		assertEquals("testProduct", test.getProduct().getProductID());
		assertEquals(5, test.getQuantity());
	}



	@Test
	public void manipulateQuantityTest(){
		test.setQuantity(10);
		assertEquals(10, test.getQuantity());
		test.addQuantity();
		assertEquals(11, test.getQuantity());
	}

	@Test
	public void calculateSubtotalTest(){
		test.addQuantity(5);
		assertEquals(105, test.getSubtotal(), 0);
		test.addQuantity(10);
		assertEquals(210, test.getSubtotal(), 0);
	}
}
