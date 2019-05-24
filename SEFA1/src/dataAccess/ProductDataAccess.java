package dataAccess;

import java.util.HashMap;
import java.util.Map;

import model.Product;

public class ProductDataAccess {
	public static Map<String, Product> products = new HashMap<>();
	
	public static int getProductsQty(String productId) {
		Product prod = ProductDataAccess.products.get(productId);
		if (prod == null) {
			throw new RuntimeException("Product does not exist");
		}
		return prod.getWarehouseQuantity();
	}


}
