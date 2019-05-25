package main;

import model.Supplier;
import dataAccess.DataStore;
import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import dataAccess.UserDataAccess;
import menu.SuperMarketMenus;
import model.Manager;
import model.Product;
import model.User;

public class Driver {
	public static void main(String[] args) {
		//new SuperMarketMenus().mainMenu();
//		Product p = new Product("Coke1", 5, 5);
//		ProductDataAccess.products.put("C", p);
//		User m = new Manager("Charles", 1, "ada");
//		UserDataAccess.users.put(2, m);
//		Supplier s = new Supplier("SAM", "AXS", "Email", "124", "124");
//		SupplierDataAccess.suppliers.put("a", s);
//		DataStore.saveData();
		DataStore.loadData();
	}
}
