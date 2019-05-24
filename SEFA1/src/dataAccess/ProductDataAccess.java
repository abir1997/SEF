package dataAccess;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import exception.ProductNotFoundException;
import model.Product;

public class ProductDataAccess {
	public static Map<String, Product> products = new HashMap<>();

	public static int getProductsQty(String productId) throws ProductNotFoundException {
		Product prod = getProduct(productId);
		return prod.getWarehouseQuantity();
	}

	public static Product getProduct(String productId) throws ProductNotFoundException {
		Product prd = products.get(productId);
		if (prd == null) {
			throw new ProductNotFoundException();
		}
		return prd;
	}

	public static Collection<Product> getAllProducts() {
		return Collections.unmodifiableCollection(products.values());
	}

	/**
	 * 
	 * @param productID
	 * @return true if removed, false otherwise
	 */
	public static boolean removeProduct(String productID) {
		Product prd = products.remove(productID);
		return (prd == null) ? false : true;
	}

	/**
	 * 
	 * @param productID
	 * @return true if replenished, false otherwise
	 */
	public static boolean replenishProductQuantity(String productId, int quantity) {
		try {
			Product prd = getProduct(productId);
			prd.replenishQuantity(quantity);
			return true;
		} catch (ProductNotFoundException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param productID
	 * @return the price of the product or throws an Exception if not found
	 */
	public static double getProductPrice(String productId) throws ProductNotFoundException {
		Product prd = getProduct(productId);
		return prd.getPrice();
	}

}
