package model;

import java.util.Map;

import menu.SuperMarketSystem;

public class WareHouseStaff extends User{

	public WareHouseStaff(String name, int id, String pwd) {
		super(name, id, pwd);
	}

	public void addProduct(Product product) {
		SuperMarketSystem.products.put(product.getProductID(), product);
	}

	public void listProductInformation() {
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("*** LIST OF PRODUCTS INFORMATION ***");
		System.out.println("------------------------------------------------------------------------\n");
		for(Map.Entry<String, Product> entry: SuperMarketSystem.products.entrySet()) {
			entry.toString();
		}
	}

	public void replenishQuantity(Product product, int quantity) {
		product.replenishQuantity(quantity);
	}

	public void removeProduct(Product product) {
		if(SuperMarketSystem.products.containsValue(product)) {
			SuperMarketSystem.products.remove(product.getProductID());
		}
	}

}
