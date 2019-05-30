package report;

import model.Product;
import model.SalesLineItem;

public class Reports {
	

	
	// method to override standard price on specific product (3)
	public void changeStandardPrice(Product product, double price) {
		product.setPrice(price);
	}

	// method to generate a sales report (5)
	public double generateSalesReport(SalesLineItem item) {
		return item.getSubtotal();
	}
}
