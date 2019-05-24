package dataAccess;

import java.util.Collection;
import java.util.HashMap;

import model.Product;
import model.Supplier;

public class SupplierDataAccess {

	private static HashMap<String, Supplier> suppliers = new HashMap<>();
	
	public static int getProductsQty(String productId) {
		Product prod = ProductDataAccess.products.get(productId);
		if (prod == null) {
			throw new RuntimeException("Product does not exist");
		}
		return prod.getWarehouseQuantity();
	}
	
	public static Collection<Supplier> getSuppliers() {
		return suppliers.values();
	}
	public static void addSupplier(Supplier supplier) {
		suppliers.put(supplier.getId(), supplier);
	}
	
	public static void removeSupplier(String id) {
		suppliers.remove(id);
	}

	public static void updateSupplierDetails(String id) {
		suppliers.remove(id);
	}

}
