package system;

import menu.SuperMarketSystem;
import model.Product;

public class DataAccess {
	
	public static int calcTotalProductsQty() {
		int sum = 0;
		for (String key: SuperMarketSystem.products.keySet()) {
			sum+=SuperMarketSystem.products.get(key).getQuantity();
		}
		return sum;
	}
	
	public static int calcAProductsQty(String productId) {

		Product prod = SuperMarketSystem.products.get(productId);
		if (prod == null) {
			throw new RuntimeException("Product does not exist");
		}
		
		return prod.getQuantity();
	}
}
