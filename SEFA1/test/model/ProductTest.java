package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void replenishQuantityTest() {
		Product product = new Product("1", 0, 100);
		
		product.replenishQuantity(0);
		
		assertEquals(0, product.getQuantity());
		
		product.replenishQuantity(100);
		assertEquals(100, product.getQuantity());
	}

}
