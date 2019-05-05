import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	Product product;

	@Before
	public void setUp() {
		product = new Product("Coke1", 10, 3.50);
	}

	@Test
	public void getProductIDTest() {
		assertEquals("Coke1", product.getProductID());
	}

	@Test
	public void setProductIDTest() {
		assertNotEquals("Fanta1", product.getProductID());
		product.setProductID("Fanta1");
		assertEquals("Fanta1", product.getProductID());
	}

	@Test
	public void getQuantityTest() {
		assertEquals(10, product.getQuantity());
	}

	@Test
	public void setQuantityTest() {
		assertNotEquals("11", product.getProductID());
		product.setQuantity(11);
		assertEquals(11, product.getQuantity());
	}




	@Test
	public void getPriceTest() {
		assertEquals(3.50, product.getPrice(), 0);
	}
	
	@Test
	public void setPriceTest() {
		assertNotEquals(2.75, product.getPrice(), 0);
		product.setPrice(2.75);
		assertEquals(2.75, product.getPrice(), 0);
	}
	
	@Test
	public void replenishQuantity()
	{
		assertEquals(10, product.getQuantity());
		product.replenishQuantity(20);
		assertEquals(30, product.getQuantity());
	   
	}

}
