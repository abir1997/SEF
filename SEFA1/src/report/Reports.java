package report;

import dataAccess.SupplierDataAccess;
import model.Product;
import model.SalesLineItem;
import model.Supplier;

public class Reports {
	

	
	// method to list supplier details (2)
	public String listSupplierDetails(boolean includeProducts) {
		StringBuffer detailsSb = new StringBuffer();
		for (Supplier supplier : SupplierDataAccess.getSuppliers()){
			detailsSb.append(supplier.getDetails(includeProducts));
			detailsSb.append("\n");
		}
		return detailsSb.toString();
	}

	// method to override standard price on specific product (3)
	public void changeStandardPrice(Product product, double price) {
		product.setPrice(price);
	}

	// method to generate a sales report (5)
	public double generateSalesReport(SalesLineItem item) {
		return item.getSubtotal();
	}
}
