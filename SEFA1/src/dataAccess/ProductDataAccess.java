package dataAccess;

import java.util.HashMap;
import java.util.List;
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

	public static List<Product> getAllProducts() {
		throw new RuntimeException("Not implemented");
	}

	/**
	 * 
	 * @param productID
	 * @return true if removed, false otherwise
	 */
	public static boolean removeProduct(String productID) {
		throw new RuntimeException("Not implemented");
	}

	/**
	 * 
	 * @param productID
	 * @return true if replenished, false otherwise
	 */
	public static boolean replenishProductQuantity(String productID, int quantity) {
		throw new RuntimeException("Not implemented");
	}

	/**
	 * 
	 * @param productID
	 * @return the price of the product or throws an Exception if not found
	 */
	public static double getProductPrice(String productID) {
		throw new RuntimeException("Not implemented");
	}


}
