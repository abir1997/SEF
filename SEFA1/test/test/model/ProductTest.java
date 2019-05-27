package test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Product;

public class ProductTest {

	@Test
	public void replenishQuantityTest() {
		//Test replenishing stock increases stock level by the specified amount (2)
		Product product = new Product("1", "Coke", 50, 50, 50, 200);
		
		product.replenishQuantity(0);
		
		assertEquals(50, product.getWarehouseQuantity());
		
		product.replenishQuantity(100);
		// 100 + 50
		assertEquals(150, product.getWarehouseQuantity());
	}

}
