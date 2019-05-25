package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import model.Product;
import model.SalesLineItem;

public class SalesLineItemTest {

	@Test
	public void addQuantityTest() {
		Product p = new Product("1", "toy", 10, 100, 100, 10);
		SalesLineItem sli = new SalesLineItem(p, 5);
		assertEquals(5, sli.getQuantity());
		
		sli.addQuantity();
		assertEquals(6, sli.getQuantity());
	}
	
	@Test
	public void subTotalTest() {
		Product p = new Product("1", "toy", 10, 100, 100, 10);
		SalesLineItem sli = new SalesLineItem(p, 5);
		assertEquals(50,sli.getSubtotal());
	}
}
