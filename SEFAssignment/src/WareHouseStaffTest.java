import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WareHouseStaffTest {
	
	Product product;
	WareHouseStaff warehousestaff;
	@Before
	public void setUp() {
		product = new Product("Coke1", 10, 3.50);
		
		warehousestaff = new WareHouseStaff("Peter", "warehousestaff@gmail.com", "supplier", "0464934573");
		
	}

	@Test
	public void getWareHouseStaffName() {
		assertEquals("Peter", warehousestaff.getName());
	}

	@Test
	public void getWareHouseStaffNameTest() {
		assertNotEquals("John", warehousestaff.getName());
		warehousestaff.setName("John");
		assertEquals("John", warehousestaff.getName());
	}

	@Test
	public void addProduct() {
	    assertEquals(0,warehousestaff.getProducts().size());
		warehousestaff.addProduct(product);
		 assertEquals(1,warehousestaff.getProducts().size());
	}


	@Test
	public void replenishProductQuantity()
	{
		assertEquals(10, product.getQuantity());
		warehousestaff.replenishQuantity(product, 20);
		assertEquals(30, product.getQuantity());
	   
	}
	
	


}
