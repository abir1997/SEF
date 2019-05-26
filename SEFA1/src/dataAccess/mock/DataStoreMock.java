package dataAccess.mock;

import dataAccess.DataStoreInterface;
import dataAccess.ProductDataAccess;
import dataAccess.SupplierDataAccess;
import dataAccess.UserDataAccess;
import model.Customer;
import model.CustomerCard;
import model.Manager;
import model.Product;
import model.SalesStaff;
import model.Supplier;
import model.User;
import model.WareHouseStaff;

public class DataStoreMock implements DataStoreInterface {

	@Override
	public void saveData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadData() {
		loadSupplierData();
		loadProductData();
		loadUserData();
	}

	private void loadUserData() {
		int id = 0;
		User u = new Manager("Charles", id++, "pass");
		UserDataAccess.users.put(u.getId(), u);
		
		u = new WareHouseStaff("Mate", id++, "pass");
		UserDataAccess.users.put(u.getId(), u);

		u = new SalesStaff("Mate", id++, "pass");
		UserDataAccess.users.put(u.getId(), u);

		u = new Customer("Johny", id++, "pass", new CustomerCard(0, "123"+id));
		UserDataAccess.users.put(u.getId(), u);
		
		u = new Customer("Kiddy", id++, "pass", new CustomerCard(0, "123"+id));
		UserDataAccess.users.put(u.getId(), u);
	}
	
	private void loadProductData() {
		int id = 0;
		//Product(String productId, String name, int warehouseQty, int replenishLevel, int orderQty, double price)
		Product p = new Product("Coke1", "p"+id++, 500, 200, 100, 5);
		ProductDataAccess.products.put(p.getProductId(), p);

		p = new Product("Pepsi", "p"+id++, 300, 200, 100, 4);
		ProductDataAccess.products.put(p.getProductId(), p);

	}

	private void loadSupplierData() {
		int id = 0;
		Supplier s = new Supplier("SAM", "S"+id++, "Email@sam.com", "0412314444", "124 a st, 2000");
		SupplierDataAccess.suppliers.put(s.getId(), s);
		
		s = new Supplier("JON", "S"+id++, "Email@jon.com", "0412312312", "2 b st, 3000");
		SupplierDataAccess.suppliers.put(s.getId(), s);

	}

}
